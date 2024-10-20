// src/main/java/com/secure_voting_system/vote/service/VoteService.java
package com.secure_voting_system.vote.service;

import com.secure_voting_system.candidate.model.Candidate;
import com.secure_voting_system.candidate.service.CandidateService;
import com.secure_voting_system.voter.model.Voter;
import com.secure_voting_system.voter.service.VoterService;
import com.secure_voting_system.vote.model.Vote;
import com.secure_voting_system.vote.repository.VoteRepository;
import com.secure_voting_system.votingRoom.model.VotingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private VoterService voterService;

    @Autowired
    private CandidateService candidateService;

    // Cast votes for candidates
    public boolean castVotes(Long voterId, Long votingRoomId, Map<Long, Integer> votes) {
        Voter voter = voterService.findVoterById(voterId);
        VotingRoom votingRoom = voter.getVotingRoom();

        // Ensure the voter is voting within the right voting room
        if (!votingRoom.getId().equals(votingRoomId)) {
            throw new RuntimeException("Voter is not registered in this voting room");
        }

        // Ensure total votes do not exceed 10
        int totalVotes = votes.values().stream().mapToInt(Integer::intValue).sum();
        if (totalVotes > 10) {
            throw new RuntimeException("You cannot cast more than 10 votes.");
        }

        // Check if the voter has already cast votes in this room
        List<Vote> existingVotes = voteRepository.findByVoterIdAndVotingRoomId(voterId, votingRoomId);
        if (!existingVotes.isEmpty()) {
            throw new RuntimeException("You have already voted in this room.");
        }

        // Save votes
        votes.forEach((candidateId, voteCount) -> {
            Candidate candidate = candidateService.findCandidateById(candidateId);

            Vote vote = new Vote();
            vote.setVoter(voter);
            vote.setCandidate(candidate);
            vote.setVotingRoom(votingRoom);
            vote.setVoteCount(voteCount);

            voteRepository.save(vote);
        });

        return true;
    }

    // Fetch voting results for a voting room
    public Map<Long, Integer> getVotingResults(Long votingRoomId) {
        List<Vote> votes = voteRepository.findByVotingRoomId(votingRoomId);

        // Summarize votes for each candidate
        return votes.stream()
                .collect(Collectors.groupingBy(vote -> vote.getCandidate().getId(),
                        Collectors.summingInt(Vote::getVoteCount)));
    }
}

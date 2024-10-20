package com.secure_voting_system.candidate.service;

import com.secure_voting_system.candidate.model.Candidate;
import com.secure_voting_system.candidate.repository.CandidateRepository;
import com.secure_voting_system.votingRoom.model.VotingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public Candidate addCandidate(String name, VotingRoom votingRoom) {
        Candidate candidate = new Candidate();
        candidate.setName(name);
        candidate.setVotingRoom(votingRoom);
        return candidateRepository.save(candidate);
    }

    public Candidate findCandidateById(Long candidateId) {
        return candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found with id: " + candidateId));
    }

    // Add more methods for other candidate-related logic
}

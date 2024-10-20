package com.secure_voting_system.voter.service;


import com.secure_voting_system.voter.model.Voter;
import com.secure_voting_system.voter.repository.VoterRepository;
import com.secure_voting_system.votingRoom.model.VotingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoterService {
    @Autowired
    private VoterRepository voterRepository;

    public Voter addVoter(String name, VotingRoom votingRoom) {
        Voter voter = new Voter();
        voter.setName(name);
        voter.setVotingRoom(votingRoom);
        return voterRepository.save(voter);
    }
    public Voter findVoterById(Long voterId) {
        return voterRepository.findById(voterId)
                .orElseThrow(() -> new RuntimeException("Voter not found with id: " + voterId));
    }
    // Logic for casting votes goes here
}

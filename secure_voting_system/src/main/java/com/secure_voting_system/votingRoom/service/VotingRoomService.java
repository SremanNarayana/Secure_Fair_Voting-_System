package com.secure_voting_system.votingRoom.service;


import com.secure_voting_system.votingRoom.model.VotingRoom;
import com.secure_voting_system.votingRoom.repository.VotingRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VotingRoomService {
    @Autowired
    private VotingRoomRepository votingRoomRepository;

    public VotingRoom createVotingRoom(String name) {
        VotingRoom room = new VotingRoom();
        room.setName(name);
        return votingRoomRepository.save(room);
    }

    public VotingRoom findById(Long id) {
        return votingRoomRepository.findById(id).orElseThrow(() -> new RuntimeException("Voting Room not found"));
    }

    // Add more methods as needed
}

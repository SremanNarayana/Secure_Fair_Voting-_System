package com.secure_voting_system.votingRoom.controller;


import com.secure_voting_system.votingRoom.model.VotingRoom;
import com.secure_voting_system.votingRoom.service.VotingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votingroom")
public class VotingRoomController {
    @Autowired
    private VotingRoomService votingRoomService;

    @PostMapping("/create")
    public VotingRoom createVotingRoom(@RequestParam String name) {
        return votingRoomService.createVotingRoom(name);
    }

    // Other endpoints to manage voting rooms
}

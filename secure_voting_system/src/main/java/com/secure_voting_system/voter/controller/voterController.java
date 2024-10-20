package com.secure_voting_system.voter.controller;

import com.secure_voting_system.voter.model.Voter;
import com.secure_voting_system.voter.service.VoterService;
import com.secure_voting_system.votingRoom.model.VotingRoom;
import com.secure_voting_system.votingRoom.service.VotingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voter")
public class voterController {

    @Autowired
    private VoterService voterService;

    @Autowired
    private VotingRoomService votingRoomService;

    // Endpoint to add a new voter and associate with a voting room
    @PostMapping("/add")
    public Voter addVoter(@RequestParam String name, @RequestParam Long votingRoomId) {
        // Fetch the voting room by ID
        VotingRoom votingRoom = votingRoomService.findById(votingRoomId);

        // Add voter to the voting room
        return voterService.addVoter(name, votingRoom);
    }

    // Optional: Get Voter details (for testing purposes)
    @GetMapping("/{voterId}")
    public Voter getVoterById(@PathVariable Long voterId) {
        return voterService.findVoterById(voterId); // Assuming VoterService has this method
    }
}

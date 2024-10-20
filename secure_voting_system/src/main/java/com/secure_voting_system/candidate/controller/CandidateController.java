package com.secure_voting_system.candidate.controller;


import com.secure_voting_system.candidate.model.Candidate;
import com.secure_voting_system.candidate.service.CandidateService;
import com.secure_voting_system.votingRoom.model.VotingRoom;
import com.secure_voting_system.votingRoom.service.VotingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @Autowired
    private VotingRoomService votingRoomService;

    @PostMapping("/add")
    public Candidate addCandidate(@RequestParam String name, @RequestParam Long roomId) {
        VotingRoom votingRoom = votingRoomService.findById(roomId);  // Assuming this method exists in VotingRoomService
        return candidateService.addCandidate(name, votingRoom);
    }
}

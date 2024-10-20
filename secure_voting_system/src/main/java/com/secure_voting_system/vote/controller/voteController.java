// src/main/java/com/secure_voting_system/vote/controller/VoteController.java
package com.secure_voting_system.vote.controller;

import com.secure_voting_system.vote.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/vote")
public class voteController {

    @Autowired
    private VoteService voteService;

    // Endpoint to cast votes
    @PostMapping("/cast")
    public String castVotes(@RequestParam Long voterId, @RequestParam Long votingRoomId,
                            @RequestBody Map<Long, Integer> votes) {
        boolean success = voteService.castVotes(voterId, votingRoomId, votes);
        if (success) {
            return "Votes successfully cast.";
        } else {
            return "Error: Failed to cast votes.";
        }
    }

    // Endpoint to get voting results
    @GetMapping("/results/{votingRoomId}")
    public Map<Long, Integer> getVotingResults(@PathVariable Long votingRoomId) {
        return voteService.getVotingResults(votingRoomId);
    }
}


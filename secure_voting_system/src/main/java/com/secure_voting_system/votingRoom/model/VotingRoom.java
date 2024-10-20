package com.secure_voting_system.votingRoom.model;

import com.secure_voting_system.candidate.model.Candidate;
import com.secure_voting_system.voter.model.Voter;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class VotingRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "votingRoom", cascade = CascadeType.ALL)
    private List<Candidate> candidates;

    @OneToMany(mappedBy = "votingRoom", cascade = CascadeType.ALL)
    private List<Voter> voters;

    // Getters and setters
}

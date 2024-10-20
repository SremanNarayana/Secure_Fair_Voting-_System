package com.secure_voting_system.vote.model;

import com.secure_voting_system.voter.model.Voter;
import com.secure_voting_system.candidate.model.Candidate;
import com.secure_voting_system.votingRoom.model.VotingRoom;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Voter voter;

    @ManyToOne
    private Candidate candidate;

    @ManyToOne
    private VotingRoom votingRoom;

    private int voteCount;
}

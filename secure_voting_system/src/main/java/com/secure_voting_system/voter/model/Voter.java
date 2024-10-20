package com.secure_voting_system.voter.model;

import com.secure_voting_system.votingRoom.model.VotingRoom;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Voter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToOne
    @JoinColumn(name = "votingRoom_id")
    private VotingRoom votingRoom;

    // Getters and setters
}

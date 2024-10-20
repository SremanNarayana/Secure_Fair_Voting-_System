package com.secure_voting_system.voter.repository;

import com.secure_voting_system.voter.model.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<Voter, Long> {
}

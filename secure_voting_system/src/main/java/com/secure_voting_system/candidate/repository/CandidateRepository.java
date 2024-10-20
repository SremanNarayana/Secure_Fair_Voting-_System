package com.secure_voting_system.candidate.repository;

import com.secure_voting_system.candidate.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}

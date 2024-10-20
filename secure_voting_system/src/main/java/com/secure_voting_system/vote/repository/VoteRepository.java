// src/main/java/com/secure_voting_system/vote/repository/VoteRepository.java
package com.secure_voting_system.vote.repository;

import com.secure_voting_system.vote.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {


    List<Vote> findByVotingRoomId(Long votingRoomId);

    List<Vote> findByVoterIdAndVotingRoomId(Long voterId, Long votingRoomId);
}

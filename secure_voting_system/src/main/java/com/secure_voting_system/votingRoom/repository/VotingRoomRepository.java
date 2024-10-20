package com.secure_voting_system.votingRoom.repository;

import com.secure_voting_system.votingRoom.model.VotingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotingRoomRepository extends JpaRepository<VotingRoom, Long> {
}

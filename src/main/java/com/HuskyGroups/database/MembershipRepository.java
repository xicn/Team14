package com.HuskyGroups.database;

import com.HuskyGroups.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface MembershipRepository extends JpaRepository<Membership, UUID> {
}

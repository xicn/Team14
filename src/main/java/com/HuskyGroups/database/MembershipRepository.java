package com.HuskyGroups.database;

import com.HuskyGroups.entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MembershipRepository extends JpaRepository<Membership, Long> {
}

package com.HuskyGroups.database;

import com.HuskyGroups.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);
    Boolean existsByEmail(String email);
}

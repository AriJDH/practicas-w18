package com.example.frescos.repository;

import com.example.frescos.entity.Agent;
import com.example.frescos.entity.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
    Optional<Agent> findByUserName(String username);
}

package com.example.demo.client.repository;

import com.example.demo.client.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role getRoleByRole(String role);
}

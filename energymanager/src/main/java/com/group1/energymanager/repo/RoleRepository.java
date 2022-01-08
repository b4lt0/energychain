package com.group1.energymanager.repo;

import java.util.Optional;

import com.group1.energymanager.model.ERole;
import com.group1.energymanager.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface RoleRepository extends JpaRepository<Role, Long> {
        Optional<Role> findByName(ERole name);
    }


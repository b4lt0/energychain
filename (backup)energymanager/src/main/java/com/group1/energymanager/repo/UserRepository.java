package com.group1.energymanager.repo;

import com.group1.energymanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {}


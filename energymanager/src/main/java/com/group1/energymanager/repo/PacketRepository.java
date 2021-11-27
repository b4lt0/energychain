package com.group1.energymanager.repo;

import com.group1.energymanager.model.Packet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacketRepository extends JpaRepository<Packet, String> {}

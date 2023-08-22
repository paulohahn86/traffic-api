package com.algaworks.traffic.repositories;

import com.algaworks.traffic.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerImpl extends JpaRepository<Owner, Long> {
}

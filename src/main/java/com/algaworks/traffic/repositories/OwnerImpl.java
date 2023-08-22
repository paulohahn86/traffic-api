package com.algaworks.traffic.repositories;

import com.algaworks.traffic.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerImpl extends JpaRepository<Owner, Long> {

    List<Owner> findByNameContaining(String name);


}

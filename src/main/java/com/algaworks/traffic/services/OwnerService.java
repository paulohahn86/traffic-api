package com.algaworks.traffic.services;

import com.algaworks.traffic.entities.Owner;
import com.algaworks.traffic.repositories.OwnerImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OwnerService{

    private OwnerImpl ownerImpl;

    public List<Owner> findAll(){
        return ownerImpl.findAll();
    }

    public Optional<Owner> findById(Long id){
        return ownerImpl.findById(id);
    }

    public List<Owner> findByNameContaining(String name){
        return ownerImpl.findByNameContaining(name);
    }

    public Owner insert(Owner owner){
        return ownerImpl.save(owner);
    }



}

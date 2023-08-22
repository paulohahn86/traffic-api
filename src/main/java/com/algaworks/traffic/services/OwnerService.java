package com.algaworks.traffic.services;

import com.algaworks.traffic.entities.Owner;
import com.algaworks.traffic.repositories.OwnerImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class OwnerService{

    private OwnerImpl ownerImpl;

    public List<Owner> findAll(){
        return ownerImpl.findAll();
    }



}

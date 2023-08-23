package com.algaworks.traffic.services;

import com.algaworks.traffic.entities.Owner;
import com.algaworks.traffic.repositories.OwnerImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class OwnerService{

    private OwnerImpl ownerImpl;

    @Transactional(readOnly = true)
    public List<Owner> findAll(){
        return ownerImpl.findAll();
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Owner> findById(Long id){
        if(!ownerImpl.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        Owner owner = ownerImpl.findById(id).get();

        return ResponseEntity.ok(owner);
    }

    @Transactional(readOnly = true)
    public List<Owner> findByNameContaining(String name){
        return ownerImpl.findByNameContaining(name);
    }


    @Transactional
    public Owner insert(Owner owner){
        return ownerImpl.save(owner);
    }


    @Transactional
    public ResponseEntity<Owner> update(Owner owner, Long id){
        if(!ownerImpl.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        owner.setId(id);
        Owner ownerUpdate = ownerImpl.save(owner);
        return ResponseEntity.ok(ownerUpdate);
    }

    @Transactional
    public ResponseEntity<Void> delete(Long id){

        if(!ownerImpl.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        Owner owner = ownerImpl.findById(id).get();
        ownerImpl.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}

package com.algaworks.traffic.controllers;


import com.algaworks.traffic.entities.Owner;
import com.algaworks.traffic.repositories.OwnerImpl;
import com.algaworks.traffic.services.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController()
public class OwnerController {

    private OwnerService ownerService;

    @GetMapping("/owners")
    public ResponseEntity<List<Owner>> findAll(){
        List<Owner> ownersList = ownerService.findAll();
        return ResponseEntity.ok(ownersList);
    }

    @GetMapping("/owners/{id}")
    public ResponseEntity<Owner> findById(@PathVariable Long id){
        Owner owner = ownerService.findById(id).orElseThrow();
        return ResponseEntity.accepted().body(owner);
    }

   @GetMapping("/owners/name")
   public ResponseEntity<List<Owner>> findByNameContaining(@RequestParam String name){
        List<Owner> ownerList = ownerService.findByNameContaining(name);
        return ResponseEntity.ok(ownerList);
    }

    @PostMapping("/owners")
    public ResponseEntity<Owner> insert(@RequestBody Owner owner){
        ownerService.insert(owner);
        return ResponseEntity.status(HttpStatus.CREATED).body(owner);
    }

}

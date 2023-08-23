package com.algaworks.traffic.controllers;


import com.algaworks.traffic.entities.Owner;
import com.algaworks.traffic.services.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController()
@RequestMapping("/owners")
public class OwnerController {

    private OwnerService ownerService;

    @GetMapping()
    public ResponseEntity<List<Owner>> findAll(){
        List<Owner> ownersList = ownerService.findAll();
        return ResponseEntity.ok(ownersList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> findById(@PathVariable Long id){
        return ownerService.findById(id);
    }

   @GetMapping("/name")
   public ResponseEntity<List<Owner>> findByNameContaining(@RequestParam String name){
        List<Owner> ownerList = ownerService.findByNameContaining(name);
        return ResponseEntity.ok(ownerList);
    }

    @PostMapping()
    public ResponseEntity<Owner> insert(@RequestBody Owner owner){
        ownerService.insert(owner);
        return ResponseEntity.status(HttpStatus.CREATED).body(owner);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Owner> update(@RequestBody Owner owner,@PathVariable Long id){
        return ownerService.update(owner,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return ownerService.delete(id);
    }

}

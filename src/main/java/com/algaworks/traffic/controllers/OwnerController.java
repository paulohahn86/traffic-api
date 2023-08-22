package com.algaworks.traffic.controllers;


import com.algaworks.traffic.entities.Owner;
import com.algaworks.traffic.repositories.OwnerImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RestController
public class OwnerController {

    private OwnerImpl ownerService;

    @GetMapping("/owners")
    public ResponseEntity<List<Owner>> findAll(){
        List<Owner> ownersList = ownerService.findAll();
        return ResponseEntity.ok(ownersList);
    }
}

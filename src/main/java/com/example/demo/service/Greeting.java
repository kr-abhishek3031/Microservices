package com.example.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Greeting implements Greet {


    @Override
    public ResponseEntity<String> greet() {
        return new ResponseEntity<String>("Inventory is active", HttpStatus.OK);
    }
}

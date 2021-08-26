package com.example.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface Greet{

    public ResponseEntity<String> greet();
}

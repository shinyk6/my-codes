package com.lab02.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/handle")
public class TestController {

    @GetMapping
     public ResponseEntity<String> handle() {
       URI location =  ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/new-resource/{id}")
               .buildAndExpand("123") 
               .toUri();
       return ResponseEntity.created(location) //해당 로케이션이 있으면
               .header("MyResponseHeader", "MyValue") 
               .body("Hello World");
     }
}
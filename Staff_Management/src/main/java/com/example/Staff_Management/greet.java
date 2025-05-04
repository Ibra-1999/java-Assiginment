package com.example.Staff_Management;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class greet {
    @GetMapping("/greet")
    public String Greet(){
        return "ASC Dear";
    }

    @GetMapping("/{name}")
    public String greeting(@PathVariable String name){
        return "Welcome Mr/Mrs "+name;
    }

    @GetMapping("/success")
    public ResponseEntity<String> disOK(){
        String result = "The work is done and its OK";
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/notfound")
    public ResponseEntity<Map<String, String>> Notfound(){
        Map<String,String> errordetail = new HashMap<>();
        errordetail.put("Error","404 Happen");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errordetail);
    }
    @PostMapping("/create")
    public ResponseEntity<String> creating() {
        HttpHeaders headers = new HttpHeaders();
        String naming = "created";
        headers.add("create", "resource " +naming);
        String body = "resource "+naming ;
        return new ResponseEntity<>(body, headers, HttpStatus.CREATED);
    }
}

package com.example.demo.rest;

import com.xpe.projetoaplicado.crypto.library.application.CryptographyFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {

    CryptographyFacade cryptography = new CryptographyFacade();

    public Controller() throws Exception {
    }

    @PostMapping("/encrypt")
    public ResponseEntity<String> input(@RequestParam(value = "input") String input) throws Exception {
        String result = cryptography.encrypt(input);
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/decrypt")
    public ResponseEntity<String> output(@RequestBody Map<String, String> payload) throws Exception {
        String input = payload.get("input");
        String result = cryptography.decrypt(input);
        return ResponseEntity.ok().body(result);
    }
}

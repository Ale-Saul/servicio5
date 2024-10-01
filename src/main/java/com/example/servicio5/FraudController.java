package com.example.servicio5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FraudController {

    private final List<String> blacklist = Arrays.asList("1234567812345678", "9876543210987654");

    @GetMapping("/checkFraud")
    public String checkFraud(@RequestParam String cardNumber) {
        // Verifica si el número de tarjeta está en la lista negra
        if (blacklist.contains(cardNumber)) {
            return "La tarjeta " + cardNumber + " está en la lista negra.";
        } else {
            return "La tarjeta " + cardNumber + " es válida.";
        }
    }
}
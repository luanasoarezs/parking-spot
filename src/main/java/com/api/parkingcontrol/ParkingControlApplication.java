package com.api.parkingcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
// pra class "saber" que é um Bean do tipo controller, e serem geradas as dependencias quando for necessario.
public class ParkingControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingControlApplication.class, args);
    }

    @GetMapping("/")
    public String index() {
        return "Ola Mundo!";
    }
}

package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {

    final private ParkingSpotService parkingSpotService;

    public ParkingSpotController(final ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingSpotModel saveParkingSpot(final @RequestBody @Valid ParkingSpotDto parkingSpotDto) {
        var parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
        parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return parkingSpotService.save(parkingSpotModel);
    }

    @GetMapping
    public ParkingSpotModel getById(final @RequestParam String id) {
        var parkingSpotModel = parkingSpotService.getById(id);
        parkingSpotModel.setResponsibleName("Milo");
        return parkingSpotModel;
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(final @RequestParam String id) {
        parkingSpotService.deleteById(id);
    }

}

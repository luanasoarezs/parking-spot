package com.api.parkingcontrol.services;

import com.api.parkingcontrol.exceptions.BadRequestException;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService {

    final private ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public ParkingSpotModel save(final ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }

    public ParkingSpotModel getById(final String id) {
        final Optional<ParkingSpotModel> optionalParkingSpotModel = parkingSpotRepository.findById(UUID.fromString(id));
        if (optionalParkingSpotModel.isEmpty()) {
            throw new BadRequestException("Cannot found parking spot with id ".concat(id));
        }

        return optionalParkingSpotModel.get();
    }

    public void deleteById(final String id) {
        try {
            parkingSpotRepository.deleteById(UUID.fromString(id));
        } catch (final Exception e) {
            throw new BadRequestException("Error: the id cannot be found");
        }
    }
}

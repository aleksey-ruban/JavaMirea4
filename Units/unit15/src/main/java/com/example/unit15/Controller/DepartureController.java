package com.example.unit15.Controller;

import com.example.unit15.Entity.Departure;
import com.example.unit15.Service.DepartureService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class DepartureController {

    private final DepartureService service;

    @GetMapping(path = "/departures")
    public @ResponseBody ResponseEntity getOrders() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.readAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping(path = "/departures")
    public @ResponseBody ResponseEntity createOrder(Departure departure) {
        try {
            service.create(departure);
            return ResponseEntity.status(HttpStatus.OK).body("Departure was created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/departures")
    public @ResponseBody ResponseEntity deleteOrder(int id) {
        try {
            if (service.delete(id)) {
                return ResponseEntity.status(HttpStatus.OK).body("Departure was deleted");
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error during deleting");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

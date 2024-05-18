package com.example.unit15.Controller;

import com.example.unit15.Entity.PostOffice;
import com.example.unit15.Service.PostOfficeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class PostOfficeController {

    private final PostOfficeService service;

    @GetMapping(path = "/post-office")
    public @ResponseBody ResponseEntity getOrders() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.readAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping(path = "/post-office")
    public @ResponseBody ResponseEntity createOrder(PostOffice postOffice) {
        try {
            service.create(postOffice);
            return ResponseEntity.status(HttpStatus.OK).body("PostOffice was created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/post-office")
    public @ResponseBody ResponseEntity deleteOrder(int id) {
        try {
            if (service.delete(id)) {
                return ResponseEntity.status(HttpStatus.OK).body("PostOffice was deleted");
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error during deleting");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

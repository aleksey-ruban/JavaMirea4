package com.example.unit19.Controller;

import com.example.unit19.Entity.Departure;
import com.example.unit19.Service.DepartureService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.query.Query;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@AllArgsConstructor
public class DepartureController {

    private final DepartureService service;

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/departures")
    public String getItemsPage(Model model, @RequestParam(required = false) String sort) {
        if (sort == null) { sort = "departureDate"; }
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Departure> itemCriteriaQuery = builder.createQuery(Departure.class);
        Root<Departure> root = itemCriteriaQuery.from(Departure.class);
        itemCriteriaQuery.select(root).orderBy(builder.asc(root.get(sort)));
        Query<Departure> query = (Query<Departure>) entityManager.createQuery(itemCriteriaQuery);
        model.addAttribute("departures", query.getResultList());
        return "departures";
    }

    @GetMapping(path = "/departures/get_departures")
    public @ResponseBody ResponseEntity getOrders() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.readAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping(path = "/departures/add_departure")
    public @ResponseBody ResponseEntity createOrder(@RequestParam String type, @RequestParam LocalDateTime departureDate) {
        try {
            service.create(new Departure(type, departureDate));
            return ResponseEntity.status(HttpStatus.OK).body("Departure was created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping(path = "/departures/delete_departure")
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

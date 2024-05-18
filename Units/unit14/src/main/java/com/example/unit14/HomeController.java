package com.example.unit14;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class HomeController {

    private ArrayList<Departure> departures = new ArrayList<>();
    private ArrayList<PostOffice> postOffices = new ArrayList<>();

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/departure")
    public @ResponseBody String returnDeparture() {
        StringBuilder builder = new StringBuilder();
        for (Departure departure : departures) {
            builder.append(departure.getType()).append(" ").append(" ").append(departure.getDepartureDate()).append("\n");
        }
        return builder.toString();
    }

    @GetMapping("office")
    public @ResponseBody String returnPostOffice() {
        StringBuilder builder = new StringBuilder();
        for (PostOffice postOffice : postOffices) {
            builder.append(postOffice.getName()).append(" ")
                    .append(postOffice.getCityName()).append("\n");
        }
        return builder.toString();
    }

    @PutMapping("/departure/add")
    public @ResponseBody String addDeparture(@RequestParam String type,
                                        @RequestParam String creationDate) {
        if (findDeparture(type, creationDate) != -1) {
            return "Departure with the same type is already exists";
        }
        departures.add(new Departure(type, creationDate));
        return "Success!";
    }

    @PutMapping("/office/add")
    public @ResponseBody String addPostOffice(@RequestParam String name,
                                         @RequestParam String city) {
        PostOffice office = new PostOffice(name, city);
        if (findPostOffice(name, city) != -1) {
            return "The same office is already exists";
        }
        postOffices.add(office);
        return "Success!";
    }

    @DeleteMapping(value = "/departure/delete")
    public @ResponseBody String removeDeparture(@RequestParam String type,
                                                @RequestParam String departureDate) {
        int id = findDeparture(type, departureDate);
        if (id == -1) {
            return "There is no item with that type and date";
        }
        departures.remove(id);
        return "Success";
    }

    @DeleteMapping("/office/delete")
    public @ResponseBody String removePostOffice(@RequestParam String name,
                                            @RequestParam String cityName) {
        int id = findPostOffice(name, cityName);
        if (id == -1) {
            return "The is no such an office";
        }
        postOffices.remove(id);
        return "Success!";
    }

    private int findDeparture(String type, String date) {
        for (int i = 0; i < departures.size(); ++i) {
            if (departures.get(i).getType().equals(type) && departures.get(i).getDepartureDate().equals(date))
                return i;
        }
        return -1;
    }

    private int findPostOffice(String name, String city) {
        for (int i = 0; i < postOffices.size(); ++i) {
            if (postOffices.get(i).getName().equals(name) && postOffices.get(i).getCityName().equals(city))
                return i;
        }
        return -1;
    }

}

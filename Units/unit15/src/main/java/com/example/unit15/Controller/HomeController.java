package com.example.unit15.Controller;

import com.example.unit15.Entity.Departure;
import com.example.unit15.Entity.PostOffice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "index";
    }


}

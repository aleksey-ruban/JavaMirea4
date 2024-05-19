package com.example.unit18.Controller;

import com.example.unit18.Entity.PostOffice;
import com.example.unit18.Service.PostOfficeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class PostOfficeController {

    private final PostOfficeService service;

    @GetMapping(path = "/post-offices")
    public String getOrders(Model model) {
        model.addAttribute("postOffices", service.readAll());
        return "postOffices";
    }

    @PostMapping(path = "/post-offices/add_post-office")
    public @ResponseBody ResponseEntity createOrder(@RequestParam String name, @RequestParam String city) {
        try {
            service.create(new PostOffice(name, city));
            return ResponseEntity.status(HttpStatus.OK).body("PostOffice was created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(path = "/post-offices/delete_post-office", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity deleteOrder(@RequestParam Integer id) {
        System.out.println("djewihf3uyg37yiqfyi71");
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

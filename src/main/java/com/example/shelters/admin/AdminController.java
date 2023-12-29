package com.example.shelters.admin;

import com.example.shelters.shelter.Shelter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping(path = "admins")
public class AdminController {
    private AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @PostMapping("logIn")
    public int logIn(@RequestBody Admin admin) throws IOException {
        return adminService.logIn(admin);
    }
    // addShelter -> returns shelterId
    @PostMapping("addShelter/{adminId}") // name, location, contact
    public int addShelter(@PathVariable int adminId, @RequestBody Shelter shelter){
        return adminService.addShelter(adminId, shelter);
    }
    @PostMapping("updateShelter/{adminId}")
    public boolean updateShelter(@PathVariable int adminId, @RequestBody Shelter shelter){
        return adminService.updateShelter(adminId, shelter);
    }
}

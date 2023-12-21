package com.example.shelters.staff;

import com.example.shelters.admin.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "staffs")
public class StaffController {
    private StaffService staffService;
    @Autowired
    public StaffController(StaffService staffService){
        this.staffService = staffService;
    }

    @PostMapping("logIn")
    public int logIn(@RequestBody Staff staff) throws IOException {
        return staffService.logIn(staff);
    }
    @PostMapping("signUp/{shelterId}")
    public int signUp(@PathVariable int shelterId, @RequestBody Staff staff) throws IOException {
        return staffService.signUp(staff, shelterId);
    }
}

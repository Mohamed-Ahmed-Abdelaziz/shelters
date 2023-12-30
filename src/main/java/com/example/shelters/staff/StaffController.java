package com.example.shelters.staff;

import com.example.shelters.admin.Admin;
import com.example.shelters.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping(path = "staffs")
public class StaffController {
    private StaffService staffService;
    @Autowired
    public StaffController(StaffService staffService){
        this.staffService = staffService;
    }

    @GetMapping
    public List<Staff> getStaffs(){
        return staffService.getStaffs();
    }
    @PostMapping("logIn")
    public ResponseEntity<Object> logIn(@RequestBody Staff staff) throws IOException {
        try {
            return new ResponseEntity<>(staffService.logIn(staff), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), org.springframework.http.HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("signUp/{shelterId}")
    public ResponseEntity<String> signUp(@PathVariable int shelterId, @RequestBody Staff staff) throws IOException {
        try {
            staffService.signUp(staff, shelterId);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), org.springframework.http.HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Staff created successfully", org.springframework.http.HttpStatus.CREATED);
    }
    @GetMapping(path = "getApplications/{staffId}")
    public List<Application> getStaffApplications(@PathVariable int staffId){
        return staffService.getStaffApplications(staffId);
    }
}

package com.example.Staff_Management;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

public class controlerstaff {
    private final servicestaff service;

    public controlerstaff(servicestaff service) {
        this.service = service;
    }

    @GetMapping("all")
    public Collection<classstaff> getstaffs(){
        return service.allstaff();
    }
    @GetMapping("{id}")
    public classstaff stafff(@PathVariable Long id){
        return service.getbyid(id);
    }

    @PostMapping("all")
    public classstaff Insertion(@RequestBody classstaff newStaff){
        return service.save(newStaff);
    }
    @PutMapping("{id}")
    public classstaff Updates(@PathVariable Long id, @RequestBody classstaff newStaff){
        return service.update(id,newStaff);
    }
    @DeleteMapping("{id}")
    public classstaff Deleting(@PathVariable Long id){
        return service.DeleteStaff(id);
    }
}

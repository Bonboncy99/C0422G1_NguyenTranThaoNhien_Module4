package com.codegym.controller;

import com.codegym.model.Phone;
import com.codegym.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class PhoneRestController {
    @Autowired
    private IPhoneService iPhoneService;

    @GetMapping("/")
    public ResponseEntity<List<Phone>> goToList() {
        List<Phone> phoneList = this.iPhoneService.findAll();
        if (phoneList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(phoneList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> addPhone(@RequestBody Phone phone) {
        this.iPhoneService.add(phone);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deletePhone(@RequestParam int id) {
        Phone phoneDB = this.iPhoneService.findById(id);
        if (phoneDB==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.iPhoneService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/update")
    public ResponseEntity<Phone> getPhone(@RequestParam(defaultValue = "0") int id) {
        Phone phone = this.iPhoneService.findById(id);
        if (phone == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(phone,HttpStatus.OK);
    }
    @PatchMapping ("/update")
    public ResponseEntity<Void> update(@RequestBody Phone phone) {
        Phone phoneDB = this.iPhoneService.findById(phone.getId());
        if (phoneDB==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.iPhoneService.update(phone);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

package com.api.demo.controller;

import com.api.demo.dto.DemoDto;
import com.api.demo.models.DemoModel;
import com.api.demo.services.DemoServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking_spot")
public class DemoController {

    @Autowired
    DemoServices demoServices;


    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid DemoDto demoDto){
        var demoModel = new DemoModel();
        BeanUtils.copyProperties(demoDto, demoModel);
        demoModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(demoServices.save(demoModel));
    }
}

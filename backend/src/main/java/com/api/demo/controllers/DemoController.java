package com.api.demo.controllers;

import com.api.demo.dto.DemoDto;
import com.api.demo.models.DemoModel;
import com.api.demo.services.Demo.DemoServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)   //permitir acesso de qualquer fonte
@RequestMapping("/parking-spot")  // Url de acesso
public class DemoController {

    @Autowired
    DemoServices demoServices;


    // @RequestBody = Salvando em Json, @Valid = validando o DemoDto,
    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid DemoDto demoDto) {
        // variável temporária com o modelo do programa
        var demoModel = new DemoModel();
        // Copiando as propriedades para a validação
        BeanUtils.copyProperties(demoDto, demoModel);
        // Registrando local, hora e data do dia
        demoModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        // Retornando o status da resposta e, salvando-o no método save
        return ResponseEntity.status(HttpStatus.CREATED).body(demoServices.save(demoModel));
    }

}

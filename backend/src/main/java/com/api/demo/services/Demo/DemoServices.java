package com.api.demo.services.Demo;

import com.api.demo.models.DemoModel;
import com.api.demo.repositories.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

// Uma Camada de serviço
// Ponto de injeção: Controller > Services > Repositories
@Service
public class DemoServices {

    @Autowired
    DemoRepository demoRepository;

    @Transactional  // caso de errado ele garante que volta ao normal
    public DemoModel save(DemoModel demoModel) {
        return demoRepository.save(demoModel);
    }
}

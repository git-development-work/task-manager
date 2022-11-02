package com.api.demo.services;

import com.api.demo.models.DemoModel;
import com.api.demo.repositories.DemoRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DemoServices {

    @Autowired
    DemoRepositories demoRepositories;

    @Transactional
    public DemoModel save(DemoModel demoModel) {
        return demoRepositories.save(demoModel);
    }
}

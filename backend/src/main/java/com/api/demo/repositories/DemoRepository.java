package com.api.demo.repositories;

import com.api.demo.models.DemoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

// Extendo até o JpaRepository para ter acesso: atualização, criação, exclusão... para o banco de dados
@Repository
public interface DemoRepository extends JpaRepository<DemoModel, UUID> {
}

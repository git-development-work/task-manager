package com.api.demo.repositories;

import com.api.demo.models.DemoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DemoRepositories extends JpaRepository<DemoModel, UUID> {
}

package com.projects.restapi.repository;

import com.projects.restapi.models.Obat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObatRepo extends JpaRepository<Obat, Long> {
}

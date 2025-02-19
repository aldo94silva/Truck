package com.TruckFlow.repository;

import com.TruckFlow.models.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaminhaoRepository extends JpaRepository<Caminhao, Long> {
}

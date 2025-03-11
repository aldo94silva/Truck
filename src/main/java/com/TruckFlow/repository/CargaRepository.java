package com.TruckFlow.repository;

import com.TruckFlow.models.Caminhao;
import com.TruckFlow.models.Carga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargaRepository extends JpaRepository<Carga, Long> {

}

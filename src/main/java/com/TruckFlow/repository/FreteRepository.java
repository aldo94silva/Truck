package com.TruckFlow.repository;

import com.TruckFlow.models.Caminhao;
import com.TruckFlow.models.Frete;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FreteRepository extends JpaRepository<Frete, Long> {

}

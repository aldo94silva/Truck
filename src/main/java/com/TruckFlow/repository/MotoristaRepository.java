package com.TruckFlow.repository;

import com.TruckFlow.models.Caminhao;
import com.TruckFlow.models.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    Motorista findByCpf(String cpf);
    Motorista findByCnh(String cnh);
    Motorista findBytelefone(String telefone);

}

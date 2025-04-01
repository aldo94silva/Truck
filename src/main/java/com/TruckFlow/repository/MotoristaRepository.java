package com.TruckFlow.repository;

import com.TruckFlow.models.Caminhao;
import com.TruckFlow.models.Motorista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

    Optional<Motorista> findByCpfOrCnhOrTelefone(String cpf, String cnh, String telefone);


}

package com.TruckFlow.repositories;


import com.TruckFlow.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCnpjCpfOrTelefone(String cnpjCpf, String telefone);

}

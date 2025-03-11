package com.TruckFlow.spec;

import com.TruckFlow.exceptions.BusinessExeption;
import com.TruckFlow.repository.CargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class CargaSpec {

    @Autowired
    private CargaRepository cargaRepository;

    private static final String MSG_ID = "Id não pode ser nulo";

    public void verificarCampoIdNulo(Long id) {
        if (isNull(id)) throw new BusinessExeption(MSG_ID);

    }

}

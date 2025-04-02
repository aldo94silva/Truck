package com.TruckFlow.specs;

import com.TruckFlow.exceptions.BusinessExeption;
import com.TruckFlow.repositories.CargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class CargaSpec {

    @Autowired
    CargaRepository cargaRepository;

    private static final String MSG_ID = "Carga não encontrada";

    public void verificarCampoIdNulo(Long id) {
        if (isNull(id)) throw new BusinessExeption(MSG_ID);

    }

}

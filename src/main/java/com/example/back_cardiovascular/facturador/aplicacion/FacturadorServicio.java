package com.example.back_cardiovascular.facturador.aplicacion;

import com.example.back_cardiovascular.facturador.dominio.Facturador;
import com.example.back_cardiovascular.facturador.dominio.IFacturadorRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacturadorServicio {

    private final IFacturadorRepositorio facturadorRepositorio;

    public boolean save(Facturador facturador){
        return facturadorRepositorio.save(facturador) != null;
    }
    public Optional<Facturador> get(Long id){
        return facturadorRepositorio.findById(id);
    }

}

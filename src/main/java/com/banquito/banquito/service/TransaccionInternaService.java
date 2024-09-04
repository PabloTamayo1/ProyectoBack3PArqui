package com.banquito.banquito.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banquito.banquito.model.TransaccionInterna;
import com.banquito.banquito.repository.TransaccionInternaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransaccionInternaService {

    private final TransaccionInternaRepository transaccionInternaRepository;

    public List<TransaccionInterna> listarTransacciones() {
        return transaccionInternaRepository.findAll();
    }

    public TransaccionInterna obtenerTransaccionPorId(Long id) {
        return transaccionInternaRepository.findById(id).orElse(null);
    }

    public TransaccionInterna crearTransaccion(TransaccionInterna transaccionInterna) {
        return transaccionInternaRepository.save(transaccionInterna);
    }

    public void eliminarTransaccion(Long id) {
        transaccionInternaRepository.deleteById(id);
    }
}


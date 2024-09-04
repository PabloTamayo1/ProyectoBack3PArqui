package com.banquito.banquito.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.banquito.banquito.model.HistorialCrediticio;
import com.banquito.banquito.repository.HistorialCrediticioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HistorialCrediticioService {

    private final HistorialCrediticioRepository historialCrediticioRepository;

    public List<HistorialCrediticio> listarHistoriales() {
        return historialCrediticioRepository.findAll();
    }

    public HistorialCrediticio obtenerHistorialPorId(Long id) {
        return historialCrediticioRepository.findById(id).orElse(null);
    }

    public HistorialCrediticio crearHistorial(HistorialCrediticio historialCrediticio) {
        return historialCrediticioRepository.save(historialCrediticio);
    }

    public void eliminarHistorial(Long id) {
        historialCrediticioRepository.deleteById(id);
    }
}



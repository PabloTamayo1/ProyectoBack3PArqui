package com.banquito.banquito.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.banquito.banquito.model.LogActividad;
import com.banquito.banquito.repository.LogActividadRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogActividadService {

    private final LogActividadRepository logActividadRepository;

    public List<LogActividad> listarLogs() {
        return logActividadRepository.findAll();
    }

    public LogActividad obtenerLogPorId(Long id) {
        return logActividadRepository.findById(id).orElse(null);
    }

    public LogActividad crearLog(LogActividad logActividad) {
        return logActividadRepository.save(logActividad);
    }

    public void eliminarLog(Long id) {
        logActividadRepository.deleteById(id);
    }
}

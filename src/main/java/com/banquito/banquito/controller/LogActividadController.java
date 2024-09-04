package com.banquito.banquito.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.banquito.model.LogActividad;
import com.banquito.banquito.service.LogActividadService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/logs")
@RequiredArgsConstructor
public class LogActividadController {

    private final LogActividadService logActividadService;

    @GetMapping
    public ResponseEntity<List<LogActividad>> listarLogs() {
        return new ResponseEntity<>(logActividadService.listarLogs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogActividad> obtenerLogPorId(@PathVariable Long id) {
        LogActividad log = logActividadService.obtenerLogPorId(id);
        return log != null ? ResponseEntity.ok(log) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<LogActividad> crearLog(@RequestBody LogActividad logActividad) {
        return new ResponseEntity<>(logActividadService.crearLog(logActividad), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLog(@PathVariable Long id) {
        logActividadService.eliminarLog(id);
        return ResponseEntity.noContent().build();
    }
}


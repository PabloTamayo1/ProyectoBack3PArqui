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

import com.banquito.banquito.model.HistorialCrediticio;
import com.banquito.banquito.service.HistorialCrediticioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/historiales")
@RequiredArgsConstructor
public class HistorialCrediticioController {

    private final HistorialCrediticioService historialCrediticioService;

    @GetMapping
    public ResponseEntity<List<HistorialCrediticio>> listarHistoriales() {
        return new ResponseEntity<>(historialCrediticioService.listarHistoriales(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialCrediticio> obtenerHistorialPorId(@PathVariable Long id) {
        HistorialCrediticio historial = historialCrediticioService.obtenerHistorialPorId(id);
        return historial != null ? ResponseEntity.ok(historial) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<HistorialCrediticio> crearHistorial(@RequestBody HistorialCrediticio historialCrediticio) {
        return new ResponseEntity<>(historialCrediticioService.crearHistorial(historialCrediticio), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHistorial(@PathVariable Long id) {
        historialCrediticioService.eliminarHistorial(id);
        return ResponseEntity.noContent().build();
    }
}


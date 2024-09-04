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

import com.banquito.banquito.model.AnalistaCredito;
import com.banquito.banquito.service.AnalistaCreditoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/analistas")
@RequiredArgsConstructor
public class AnalistaCreditoController {

    private final AnalistaCreditoService analistaCreditoService;

    @GetMapping
    public ResponseEntity<List<AnalistaCredito>> listarAnalistas() {
        return new ResponseEntity<>(analistaCreditoService.listarAnalistas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnalistaCredito> obtenerAnalistaPorId(@PathVariable Long id) {
        AnalistaCredito analista = analistaCreditoService.obtenerAnalistaPorId(id);
        return analista != null ? ResponseEntity.ok(analista) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AnalistaCredito> crearAnalista(@RequestBody AnalistaCredito analistaCredito) {
        return new ResponseEntity<>(analistaCreditoService.crearAnalista(analistaCredito), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAnalista(@PathVariable Long id) {
        analistaCreditoService.eliminarAnalista(id);
        return ResponseEntity.noContent().build();
    }
}


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

import com.banquito.banquito.model.TransaccionInterna;
import com.banquito.banquito.service.TransaccionInternaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/transacciones")
@RequiredArgsConstructor
public class TransaccionInternaController {

    private final TransaccionInternaService transaccionInternaService;

    @GetMapping
    public ResponseEntity<List<TransaccionInterna>> listarTransacciones() {
        return new ResponseEntity<>(transaccionInternaService.listarTransacciones(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransaccionInterna> obtenerTransaccionPorId(@PathVariable Long id) {
        TransaccionInterna transaccion = transaccionInternaService.obtenerTransaccionPorId(id);
        return transaccion != null ? ResponseEntity.ok(transaccion) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TransaccionInterna> crearTransaccion(@RequestBody TransaccionInterna transaccionInterna) {
        return new ResponseEntity<>(transaccionInternaService.crearTransaccion(transaccionInterna), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTransaccion(@PathVariable Long id) {
        transaccionInternaService.eliminarTransaccion(id);
        return ResponseEntity.noContent().build();
    }
}


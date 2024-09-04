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

import com.banquito.banquito.model.Documento;
import com.banquito.banquito.service.DocumentoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/documentos")
@RequiredArgsConstructor
public class DocumentoController {

    private final DocumentoService documentoService;

    // Listar todos los documentos
    @GetMapping
    public ResponseEntity<List<Documento>> listarDocumentos() {
        return new ResponseEntity<>(documentoService.listarDocumentos(), HttpStatus.OK);
    }

    // Obtener un documento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Documento> obtenerDocumentoPorId(@PathVariable Long id) {
        Documento documento = documentoService.obtenerDocumentoPorId(id);
        return documento != null ? ResponseEntity.ok(documento) : ResponseEntity.notFound().build();
    }

    // Crear un nuevo documento
    @PostMapping
    public ResponseEntity<Documento> crearDocumento(@RequestBody Documento documento) {
        return new ResponseEntity<>(documentoService.crearDocumento(documento), HttpStatus.CREATED);
    }

    // Eliminar un documento por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDocumento(@PathVariable Long id) {
        documentoService.eliminarDocumento(id);
        return ResponseEntity.noContent().build();
    }
}


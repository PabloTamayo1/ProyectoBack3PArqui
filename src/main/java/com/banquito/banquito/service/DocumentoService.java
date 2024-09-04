package com.banquito.banquito.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.banquito.banquito.model.Documento;
import com.banquito.banquito.repository.DocumentoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocumentoService {

    private final DocumentoRepository documentoRepository;

    public List<Documento> listarDocumentos() {
        return documentoRepository.findAll();
    }

    public Documento obtenerDocumentoPorId(Long id) {
        return documentoRepository.findById(id).orElse(null);
    }

    public Documento crearDocumento(Documento documento) {
        return documentoRepository.save(documento);
    }

    public void eliminarDocumento(Long id) {
        documentoRepository.deleteById(id);
    }
}


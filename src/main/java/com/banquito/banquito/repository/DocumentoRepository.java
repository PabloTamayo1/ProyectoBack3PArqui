package com.banquito.banquito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.banquito.model.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {}

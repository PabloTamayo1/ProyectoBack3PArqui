package com.banquito.banquito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.banquito.model.SolicitudCredito;

@Repository
public interface SolicitudCreditoRepository extends JpaRepository<SolicitudCredito, Long> {}

package com.api.soporte_ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.soporte_ticket.models.SoporteTicket;

public interface SoporteTicketRepository extends JpaRepository <SoporteTicket, Long> {   

    
} 
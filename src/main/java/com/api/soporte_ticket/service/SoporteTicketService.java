package com.api.soporte_ticket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.soporte_ticket.models.SoporteTicket;
import com.api.soporte_ticket.repository.SoporteTicketRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SoporteTicketService {

    private final SoporteTicketRepository soporteTicketRepository;

    
    public List<SoporteTicket> listarTickets() {
        return soporteTicketRepository.findAll();
    }

    
    public SoporteTicket crearTicket(SoporteTicket ticket) {
        return soporteTicketRepository.save(ticket);
    }

   
    public SoporteTicket buscarTicketPorId(Long id) {
        return soporteTicketRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Ticket no encontrado con ID: " + id));
    }

    
    public SoporteTicket actualizarTicket(Long id, SoporteTicket ticketActualizado) {
        SoporteTicket ticketExistente = soporteTicketRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Ticket no encontrado con ID: " + id));

        ticketExistente.setTitulo(ticketActualizado.getTitulo());
        ticketExistente.setDescripcion(ticketActualizado.getDescripcion());
        ticketExistente.setEstado(ticketActualizado.getEstado());
        ticketExistente.setPrioridad(ticketActualizado.getPrioridad());
        ticketExistente.setFechaCreacion(ticketActualizado.getFechaCreacion());
        ticketExistente.setFechaActualizacion(ticketActualizado.getFechaActualizacion());
        ticketExistente.setUsuario(ticketActualizado.getUsuario());

        return soporteTicketRepository.save(ticketExistente);
    }

    
    public void eliminarTicket(Long id) {
        soporteTicketRepository.deleteById(id);
    }
}

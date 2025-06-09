package com.api.soporte_ticket.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.soporte_ticket.models.SoporteTicket;
import com.api.soporte_ticket.service.SoporteTicketService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/soporte-tickets")
@RequiredArgsConstructor
public class SoporteTicketController {

    private final SoporteTicketService soporteTicketService;

    
    @GetMapping
    public List<SoporteTicket> getAll() {
        return soporteTicketService.listarTickets();
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            SoporteTicket ticket = soporteTicketService.buscarTicketPorId(id);
            return ResponseEntity.ok(ticket);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body(Map.of("mensaje", ex.getMessage()));
        }
    }

    
    @PostMapping
    public ResponseEntity<SoporteTicket> crear(@RequestBody SoporteTicket nuevoTicket) {
        SoporteTicket creado = soporteTicketService.crearTicket(nuevoTicket);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<SoporteTicket> actualizar(@PathVariable Long id, @RequestBody SoporteTicket ticketActualizado) {
        SoporteTicket actualizado = soporteTicketService.actualizarTicket(id, ticketActualizado);
        return ResponseEntity.ok(actualizado);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        soporteTicketService.eliminarTicket(id);
        return ResponseEntity.noContent().build();
    }
}

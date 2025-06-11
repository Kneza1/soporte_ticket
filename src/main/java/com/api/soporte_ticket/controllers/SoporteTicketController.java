package com.api.soporte_ticket.controllers;

import com.api.soporte_ticket.dto.SoporteTicketDTO;
import com.api.soporte_ticket.service.SoporteTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/soporte")
public class SoporteTicketController {

    @Autowired
    private SoporteTicketService soporteTicketServices;

    @PostMapping
    public ResponseEntity<SoporteTicketDTO> crear(@RequestBody SoporteTicketDTO dto) {
        return ResponseEntity.ok(soporteTicketServices.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<SoporteTicketDTO>> listar() {
        return ResponseEntity.ok(soporteTicketServices.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoporteTicketDTO> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(soporteTicketServices.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SoporteTicketDTO> actualizar(@PathVariable Integer id, @RequestBody SoporteTicketDTO dto) {
        return ResponseEntity.ok(soporteTicketServices.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        soporteTicketServices.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}

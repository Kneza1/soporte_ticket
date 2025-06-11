package com.api.soporte_ticket.service;

import com.api.soporte_ticket.models.SoporteTicket;
import com.api.soporte_ticket.models.Usuario;
import com.api.soporte_ticket.repository.SoporteTicketRepository;
import com.api.soporte_ticket.repository.UsuarioRepository;
import com.api.soporte_ticket.dto.SoporteTicketDTO;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
@Service
public class SoporteTicketService {


    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private SoporteTicketRepository soporteTicketRepository;

    private SoporteTicketDTO toDTO(SoporteTicket soporteTicket) {
        return new SoporteTicketDTO(
            soporteTicket.getIdSoporte(),
            soporteTicket.getUsuario().getIdUsuario(),
            soporteTicket.getDescripcion(),
            soporteTicket.getTipo(),
            soporteTicket.getEstado(),
            soporteTicket.getFechaCreacion(),
            soporteTicket.getFechaResolucion()
        );
    }

    private SoporteTicket toEntity(SoporteTicketDTO dto) {
        SoporteTicket soporteTicket = new SoporteTicket();
        soporteTicket.setIdSoporte(dto.getIdSoporte());
        soporteTicket.setFechaCreacion(dto.getFechaCreacion());
        soporteTicket.setFechaResolucion(dto.getFechaResolucion());
        soporteTicket.setDescripcion(dto.getDescripcion());
        soporteTicket.setTipo(dto.getTipo());
        soporteTicket.setEstado(dto.getEstado());
        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        soporteTicket.setUsuario(usuario);
        return soporteTicket;
    }

    public SoporteTicketDTO crear(SoporteTicketDTO dto) {
        SoporteTicket soporteTicket = toEntity(dto);
        return toDTO(soporteTicketRepository.save(soporteTicket));
    }

    public List<SoporteTicketDTO> listar() {
        return soporteTicketRepository.findAll().stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

    public SoporteTicketDTO buscar(Integer id) {
        SoporteTicket soporteTicket = soporteTicketRepository.findById(id.longValue())
            .orElseThrow(() -> new RuntimeException("Soporte no encontrado"));
        return toDTO(soporteTicket);
    }

    public SoporteTicketDTO actualizar(Integer id, SoporteTicketDTO dto) {
        SoporteTicket existente = soporteTicketRepository.findById(id.longValue())
            .orElseThrow(() -> new RuntimeException("Soporte no encontrado"));
        existente.setFechaCreacion(dto.getFechaCreacion());
        existente.setFechaResolucion(dto.getFechaResolucion());
        existente.setDescripcion(dto.getDescripcion());
        existente.setTipo(dto.getTipo());
        existente.setEstado(dto.getEstado());
        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        existente.setUsuario(usuario);
        return toDTO(soporteTicketRepository.save(existente));
    }

    public void eliminar(Integer id) {
        soporteTicketRepository.deleteById(id.longValue());
    }
}

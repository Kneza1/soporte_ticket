package com.api.soporte_ticket.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoporteTicketDTO {
    private Integer id;
    private String titulo;
    private String descripcion;
    private String fechaCreacion;
    private String estado;
    private String fechaActualizacion;
    private String usuario;
}

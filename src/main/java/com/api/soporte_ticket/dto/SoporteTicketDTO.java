package com.api.soporte_ticket.dto;

import org.springframework.hateoas.RepresentationModel;
import lombok.*;
import java.sql.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoporteTicketDTO extends RepresentationModel<SoporteTicketDTO> {
    private Integer idSoporte;
    private Integer idUsuario;
    private String descripcion;
    private String Tipo;
    private String Estado;
    private Date FechaCreacion;
    private Date FechaResolucion;
}

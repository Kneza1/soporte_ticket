package com.api.soporte_ticket.dto;
import lombok.*;
import java.sql.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoporteTicketDTO {
    private Integer idSoporte;
    private Integer idUsuario;
    private String descripcion;
    private String Tipo;
    private String Estado;
    private Date FechaCreacion;
    private Date FechaResolucion;
}

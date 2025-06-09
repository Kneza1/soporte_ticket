package com.api.soporte_ticket.models;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "soporte_ticket")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoporteTicket {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_soporte_ticket")
    private Integer id;
    private String titulo;
    private String descripcion;
    private String estado;
    private String prioridad;
    private String fechaCreacion;
    private String fechaActualizacion;
    private String usuario;
    

}

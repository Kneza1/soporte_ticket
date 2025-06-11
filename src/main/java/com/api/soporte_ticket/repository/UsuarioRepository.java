package com.api.soporte_ticket.repository;

import com.api.soporte_ticket.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}

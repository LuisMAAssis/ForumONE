package com.luismiguel.forumOne.domain.perfil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
  UserDetails findByLogin(String login);
}
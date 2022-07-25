package com.vicente.microserviciousuarios.service;

import com.vicente.microserviciocommons.service.CommonServiceImpl;
import com.vicente.microserviciousuarios.entity.Usuario;

import com.vicente.microserviciousuarios.repository.UsuarioRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends CommonServiceImpl<Usuario, UsuarioRepository> implements UsuarioService {

}

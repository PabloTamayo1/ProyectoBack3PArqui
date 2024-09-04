package com.banquito.banquito.controller;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.banquito.model.Usuario;
import com.banquito.banquito.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@Controller
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Métodos REST
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuariosREST() {
        return new ResponseEntity<>(usuarioService.listarUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorIdREST(@PathVariable Long id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Usuario> crearUsuarioREST(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.crearUsuario(usuario), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuarioREST(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    // Métodos GraphQL
    @QueryMapping
    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @QueryMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @MutationMapping
    public Usuario crearUsuario(String nombre, String correoElectronico, String numeroIdentificacion, Float ingresosMensuales, String direccion) {
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setCorreoElectronico(correoElectronico);
        usuario.setNumeroIdentificacion(numeroIdentificacion);
        usuario.setIngresosMensuales(BigDecimal.valueOf(ingresosMensuales));
        usuario.setDireccion(direccion);
        return usuarioService.crearUsuario(usuario);
    }
}

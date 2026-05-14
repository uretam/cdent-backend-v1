package com.cdent.usuarios.services;

import com.cdent.usuarios.models.Usuario;
import com.cdent.usuarios.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> update(Long id, Usuario usuario) {
        return usuarioRepository.findById(id).map(existing -> {
            usuario.setIdUsuario(existing.getIdUsuario());
            return usuarioRepository.save(usuario);
        });
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}

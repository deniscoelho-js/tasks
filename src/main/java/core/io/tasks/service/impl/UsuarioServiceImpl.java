package core.io.tasks.service.impl;


import core.io.tasks.entity.Usuario;
import core.io.tasks.repository.TaskRepository;
import core.io.tasks.repository.UsuarioRepository;
import core.io.tasks.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Transactional
    public Usuario salvarUsuario(Usuario usuario) {
        try {
            return usuarioRepository.save(usuario);
        } catch (DataIntegrityViolationException ex) {
            throw new IllegalArgumentException(String.format("Usuário '%s' já cadastrado", usuario.getNome()));
        }
    }

    @Transactional
    public Usuario listarUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuário id = %s não encontrado.", id))
        );
    }

    @Transactional
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Transactional
    @Override
    public void deletarUsuario(Integer id) {
        Usuario user = listarUsuarioPorId(id);
        usuarioRepository.delete(user);
    }

    @Transactional
    @Override
    public Usuario editarUsuario(Integer id, Map<String, Object> updates) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Usuario id %s nao encontrado", id))
        );

        updates.forEach((key, value) -> {
            switch (key) {
                case "nome" -> usuario.setNome( (String) value);
                case "email" -> usuario.setEmail((String) value);
                case "senha" -> usuario.setSenha((String) value);
                case "dataDeRegistro" -> usuario.setDataDeRegistro(OffsetDateTime.parse((String) value));
                default -> throw new IllegalArgumentException(String.format("Campo %s nao é formatavel", id));
            }
                });

        return usuarioRepository.save(usuario);
    }
}

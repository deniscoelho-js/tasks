package core.io.tasks.controller;


import core.io.tasks.dto.UsuarioRequestDTO;
import core.io.tasks.dto.UsuarioResponseDTO;
import core.io.tasks.dto.mapper.UsuarioMapper;
import core.io.tasks.entity.Usuario;
import core.io.tasks.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> create(@RequestBody UsuarioRequestDTO requestDTO){
        Usuario usuario = usuarioService.salvarUsuario(UsuarioMapper.toUsuario(requestDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toUsuarioResponseDTO(usuario));
//        return new ResponseEntity<>(UsuarioMapper.toUsuarioResponseDTO(usuario), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> getById(@PathVariable Integer id) {
        Usuario user = usuarioService.buscarUsuarioPorId(id);
        return ResponseEntity.ok().body(UsuarioMapper.toUsuarioResponseDTO(user));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarTodos() {
        List<Usuario> users = usuarioService.listarUsuarios();
        return ResponseEntity.ok().body(UsuarioMapper.toListDTO(users));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        try {
            usuarioService.deletarUsuario(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editarUsuario(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        try {
            Usuario usuarioAtualizado = usuarioService.editarUsuario(id, updates);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}

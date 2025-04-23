package core.io.tasks.service;

import core.io.tasks.dto.UsuarioRequestDTO;
import core.io.tasks.entity.Usuario;


import java.util.List;
import java.util.Map;

public interface UsuarioService {
    public Usuario salvarUsuario(Usuario usuario) ;
    public List<Usuario> listarUsuarios();
    public void deletarUsuario(Integer id);
    public Usuario editarUsuario(Integer id, Map<String, Object> updates);
    public Usuario listarUsuarioPorId(Integer id);

}

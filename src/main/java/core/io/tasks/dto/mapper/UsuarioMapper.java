package core.io.tasks.dto.mapper;

import core.io.tasks.dto.UsuarioRequestDTO;
import core.io.tasks.dto.UsuarioResponseDTO;
import core.io.tasks.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {
    public static Usuario toUsuario(UsuarioRequestDTO requestDTO){
        return new ModelMapper().map(requestDTO, Usuario.class);
    }

    public static UsuarioResponseDTO toUsuarioResponseDTO(Usuario usuario){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(usuario, UsuarioResponseDTO.class);
    }

    public static List<UsuarioResponseDTO> toListDTO(List<Usuario> usuarioList) {
        return usuarioList.stream().map(user -> toUsuarioResponseDTO(user)).collect(Collectors.toList());
    }
}


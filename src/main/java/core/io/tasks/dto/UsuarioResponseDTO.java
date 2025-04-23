package core.io.tasks.dto;

import core.io.tasks.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDTO {
    private Integer id;
    private String nome;
    private String email;
    private OffsetDateTime dataDeRegistro;
    private List<TaskResponseDTO> tasks = new ArrayList<>();
}

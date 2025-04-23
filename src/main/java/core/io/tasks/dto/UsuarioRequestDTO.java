package core.io.tasks.dto;

import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDTO {
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private OffsetDateTime dataDeRegistro;


}

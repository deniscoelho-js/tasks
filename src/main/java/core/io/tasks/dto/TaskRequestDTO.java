package core.io.tasks.dto;

import core.io.tasks.entity.Usuario;
import core.io.tasks.enums.Categoria;
import core.io.tasks.enums.Prioridade;
import core.io.tasks.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDTO {

    private String titulo;
    private String descricao;
    private Status status;
    private Prioridade prioridade;
    private Categoria categoria;
    private OffsetDateTime dataCriacao;
//    private Integer usuarioId;
    
}

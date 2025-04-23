package core.io.tasks.dto.mapper;

import core.io.tasks.dto.TaskRequestDTO;
import core.io.tasks.dto.TaskResponseDTO;
import core.io.tasks.entity.Task;
import core.io.tasks.entity.Usuario;
import core.io.tasks.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public  Task toTask(TaskRequestDTO requestDTO) {
        return new ModelMapper().map(requestDTO, Task.class);
    }

    public  TaskResponseDTO toTaskResponseDTO(Task task) {
        return new ModelMapper().map(task, TaskResponseDTO.class);
    }

    public List<TaskResponseDTO> toTaskListResponseDTO(List<TaskRequestDTO> taskListRequestDTO) {
        return taskListRequestDTO.stream().map(requestDTO -> new  ModelMapper().map(requestDTO, TaskResponseDTO.class)).
                collect(Collectors.toList());
    }
}


package core.io.tasks.service;

import core.io.tasks.dto.TaskRequestDTO;
import core.io.tasks.dto.TaskResponseDTO;

import java.util.List;
import java.util.Map;

public interface TaskService {
    public TaskResponseDTO salvarTask(TaskRequestDTO taskRequestDTO);
    public List<TaskResponseDTO> listarTasks();
    public void deletarTask(Integer id);
    public TaskResponseDTO editarTask(Integer id, Map<String, Object> updates);
    public TaskResponseDTO listarTaskPorId(Integer id);
}

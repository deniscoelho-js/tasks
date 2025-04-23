package core.io.tasks.service.impl;

import core.io.tasks.dto.TaskRequestDTO;
import core.io.tasks.dto.TaskResponseDTO;
import core.io.tasks.dto.mapper.TaskMapper;
import core.io.tasks.entity.Task;
import core.io.tasks.enums.Categoria;
import core.io.tasks.enums.Prioridade;
import core.io.tasks.enums.Status;
import core.io.tasks.repository.TaskRepository;
import core.io.tasks.service.TaskService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    @Transactional
    @Override
    public TaskResponseDTO salvarTask(TaskRequestDTO taskRequestDTO) {
        // Mapeia o DTO de requisição para uma entidade Task
        Task task = taskRepository.save(taskMapper.toTask(taskRequestDTO));
        // Mapeia a entidade salva para um DTO de resposta
        return taskMapper.toTaskResponseDTO(task);
    }

    @Transactional
    @Override
    public List<TaskResponseDTO> listarTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(taskMapper::toTaskResponseDTO).collect(Collectors.toList());
    }

    @Override

    @Transactional
    public void deletarTask(Integer id) {
        Task task = taskRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("task id = %s não encontrado", id)));
        // Remove a tarefa do repositório
        taskRepository.delete(task);
    }

    @Transactional
    @Override
    public TaskResponseDTO editarTask(Integer id, Map<String, Object> updates) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Task com id %s não encontrada", id)));

        // Atualiza os campos na entidade Task
        updates.forEach((key, value) -> {
            switch (key) {
                case "titulo" -> task.setTitulo((String) value);
                case "descricao" -> task.setDescricao((String) value);
                case "status" -> task.setStatus(Status.valueOf((String) value));
                case "prioridade" -> task.setPrioridade(Prioridade.valueOf((String) value));
                case "categoria" -> task.setCategoria(Categoria.valueOf((String) value));
                case "dataCriacao" -> task.setDataCriacao(OffsetDateTime.parse((String) value));
                case "dataDeConclusao" -> task.setDataDeConclusao(OffsetDateTime.parse((String) value));
                default -> throw new IllegalArgumentException(String.format("Campo %s não é formatável", key));
            }
        });

        // Salva a entidade atualizada no repositório
        Task taskAtualizada = taskRepository.save(task);

        // Mapeia a Task atualizada para TaskResponseDTO e retorna
        return taskMapper.toTaskResponseDTO(taskAtualizada);
    }

    @Transactional
    @Override
    public TaskResponseDTO listarTaskPorId(Integer id) {
        Task task = taskRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("task id = %s não encontrado", id)));
        return taskMapper.toTaskResponseDTO(task);
    }
}

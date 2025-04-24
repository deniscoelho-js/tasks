package core.io.tasks.controller;

import core.io.tasks.dto.TaskRequestDTO;
import core.io.tasks.dto.TaskResponseDTO;
import core.io.tasks.dto.mapper.TaskMapper;
import core.io.tasks.entity.Usuario;
import core.io.tasks.service.TaskService;
import core.io.tasks.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<TaskResponseDTO> create(@RequestBody TaskRequestDTO taskRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.salvarTask(taskRequestDTO));
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> listarTasks() {
        return ResponseEntity.ok().body(taskService.listarTasks());
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<TaskResponseDTO>> listarTasksPorIdUsuario(@PathVariable Integer id) {
        List<TaskResponseDTO> tasks = taskService.listarTasksPorIdUsuario(id);
        return ResponseEntity.ok(tasks);
    }

}

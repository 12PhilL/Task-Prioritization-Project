package dio.me.gestortarefas.controller;

import dio.me.gestortarefas.dto.TaskRequestDTO;
import dio.me.gestortarefas.model.Task;
import dio.me.gestortarefas.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/criar")
    public ResponseEntity<Task> criarTask(@RequestBody @Valid TaskRequestDTO dto) {
        Task task = new Task();
        task.setTitulo(dto.getTitulo());
        task.setPrazo(dto.getPrazo());
        task.setDescricao(dto.getDescricao());
        task.setConcluida(dto.isConcluida());
        task.setCategoria(dto.getCategoria());
        Task taskSalva = taskService.saveTask(task);
        return ResponseEntity.ok(taskSalva);
    }

    @GetMapping("/NaoConcluidas")
    public ResponseEntity<List<Task>> listarTaskNaoConcluidas() {
        return ResponseEntity.ok(taskService.listarTaskNaoConcluidas());
    }

    @GetMapping("/todas")
    public ResponseEntity<List<Task>> listasTodasTask() {
        return ResponseEntity.ok(taskService.listarTodasTasks());
    }

    @GetMapping("/concluidas")
    public ResponseEntity<List<Task>> listarTaskConcluidas() {
        return ResponseEntity.ok(taskService.listarTaskConcluidas());
    }

    @GetMapping("/prioridade/{prioridade}")
    public ResponseEntity<List<Task>> filtrarPorPrioridade(@PathVariable Integer prioridade) {
        return ResponseEntity.ok(taskService.filtarPorPrioridade(prioridade));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> atualizarTask(@PathVariable Long id, @RequestBody Task taskAtualizada) {
        return ResponseEntity.ok(taskService.atualizarTask(id, taskAtualizada));
    }

    @PatchMapping("/{id}/concluir")
    public ResponseEntity<Task> marcarComoConcluida(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.marcarComoConcluida(id));
    }
}

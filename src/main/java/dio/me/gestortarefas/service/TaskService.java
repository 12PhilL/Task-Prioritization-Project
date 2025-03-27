package dio.me.gestortarefas.service;

import dio.me.gestortarefas.model.Categoria;
import dio.me.gestortarefas.model.Task;
import dio.me.gestortarefas.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task saveTask(Task task) {
        task.setPrioridade(calcularPrioridade(task));
        return taskRepository.save(task);
    }

    private Integer calcularPrioridade(Task task){
        boolean isUrgente = task.getPrazo() != null &&
                task.getPrazo().isBefore(LocalDateTime.now());

        boolean isImportante = task.getCategoria() == Categoria.TRABALHO ||
                task.getCategoria() == Categoria.ESTUDO;

        if (isUrgente && isImportante) {
            return 3;
        } else if (isUrgente) {
            return 1;
        } else if (isImportante) {
            return 2;
        } else {
            return 0;
        }
    }

    public List<Task> listarTodasTasks() {
        return taskRepository.findAll();
    }

    public List<Task> listarTaskNaoConcluidas() {
        return taskRepository.findByConcluidaFalse();
    }

    public List<Task> listarTaskConcluidas() {
        return taskRepository.findByConcluidaTrue();
    }

    public List<Task> filtarPorPrioridade(Integer prioridade) {
        return taskRepository.findByPrioridade(prioridade);
    }

    public  Task atualizarTask(Long id, Task taskAtualizada) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitulo(taskAtualizada.getTitulo());
                    task.setDescricao(taskAtualizada.getDescricao());
                    task.setPrazo(taskAtualizada.getPrazo());
                    task.setCategoria(taskAtualizada.getCategoria());
                    task.setPrioridade(calcularPrioridade(task));
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada!"));
    }

    public Task marcarComoConcluida(Long id) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setConcluida(true);
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada!"));
    }
}

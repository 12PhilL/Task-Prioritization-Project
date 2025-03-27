package dio.me.gestortarefas.repository;

import dio.me.gestortarefas.model.Categoria;
import dio.me.gestortarefas.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByConcluidaFalse();
    List<Task> findByCategoria(Categoria categoria);
    List<Task> findByConcluidaTrue();
    List<Task> findByPrioridade(Integer prioridade);
}

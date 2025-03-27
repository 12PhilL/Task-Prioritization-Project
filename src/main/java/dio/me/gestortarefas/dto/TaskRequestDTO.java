package dio.me.gestortarefas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dio.me.gestortarefas.model.Categoria;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;

public class TaskRequestDTO {
    @Getter
    @NotNull
    private String titulo;

    @Getter
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime prazo;

    @Getter
    private String descricao;

    @Getter
    private boolean concluida = false;

    @Getter
    private Categoria categoria;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPrazo(LocalDateTime prazo) {
        this.prazo = prazo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
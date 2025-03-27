# 🚀 Task Priority Manager

Sistema de gerenciamento de tarefas com priorização automática usando Spring Boot

## 📌 Funcionalidades

- ✅ Cadastro de tarefas com título, descrição, prazo e categoria
- ⚡ Priorização automática (0-3) baseada em:
  - `Urgente`: Prazo anterior à data atual
  - `Importante`: Categorias TRABALHO ou ESTUDO
- 🔍 Filtros por:
  - Status (concluída/não concluída)
  - Prioridade
  - Categoria
- 📅 Formatação de datas (dd/MM/yyyy HH:mm)

## 📊 Tabela de Prioridades

| Código | Condição                   | Exemplo                |
|--------|----------------------------|------------------------|
| 3      | Vencida + Importante       | Prazo ontem + TRABALHO ou ESTUDO |
| 2      | Apenas Importante          | ESTUDO ou TRABALHO (prazo futuro)  |
| 1      | Apenas Vencida             | Prazo para ontem  |
| 0      | Nem vencida, nem importante| PESSOAL com prazo futuro |

## 🛠 Tecnologias

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database (dev) / MySQL (prod)
- Lombok
- Swagger (Documentação API)

## 🔧 Configuração

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/task-manager.git

2. Configure o arquivo `application.properties:`
   ```bash
   # Banco de dados (H2 para desenvolvimento)
   spring.datasource.url=jdbc:h2:mem:taskdb
   spring.h2.console.enabled=true

   # Formato de data
   spring.mvc.format.date-time=dd/MM/yyyy HH:mm
   
3. Execute:
   ```bash
   mvn spring-boot:run

## 📚 Endpoints (Swagger UI)

Acesse a documentação interativa em:
  ```bash
  http://localhost:8080/swagger-ui.html
```

## 🎯 Exemplo de JSON
  ```bash
  {
  "titulo": "Reunião Sprint Planning",
  "descricao": "Preparar materiais para reunião",
  "prazo": "15/11/2023 09:00",
  "concluida": false,
  "categoria": "TRABALHO"
  }
```
## 🤝 Contribuição
Faça um fork do projeto

1. Crie uma branch (git checkout -b feature/nova-funcionalidade)
2. Commit suas mudanças (git commit -m 'Adiciona nova funcionalidade')
3. Push para a branch (git push origin feature/nova-funcionalidade)
4. Abra um Pull Request


### Destaques incluídos:
1. **Sistema de priorização** explicado visualmente
2. **Configuração do H2** para desenvolvimento rápido
3. **Exemplos práticos** de JSON e prioridades
4. **Link para Swagger** (doc interativa)
5. **Guia de contribuição** padronizado

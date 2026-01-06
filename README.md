# task-manager

## `task-manager` — **Task Manager (REST API)**  
*(Spring Boot, JPA, Security, Swagger)*

```markdown
# 📋 Task Manager  
**Современный REST API для управления задачами с аутентификацией и документацией**  
> Production-ready Spring Boot сервис: от валидации до деплоя.

[![Spring Boot 3](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![JPA/Hibernate](https://img.shields.io/badge/JPA-Hibernate-007ACC)](https://hibernate.org)
---

##  Возможности

-  **CRUD через REST**: `GET /tasks`, `POST /tasks`, `PUT /tasks/{id}`, `DELETE /tasks/{id}`
-  **Безопасность**:  
  - Пользователь видит **только свои задачи**,  
  - HR — всех (готово к расширению до JWT).
-  **Валидация**: `@NotNull`, `@Size`, `@PastOrPresent`, кастомные проверки (`completedAt` только при `DONE`).
-  **Документация**:  
  - Swagger UI — интерактивная спецификация,  
  - Javadoc — enterprise-уровень (описание логики, ограничений, примеров).
-  **Тестирование**:  
  - `@WebMvcTest` — контроллеры,  
  - `@DataJpaTest` — репозитории,  
  - Mockito — сервисы.

---

##  Быстрый старт

```bash
./mvnw spring-boot:run

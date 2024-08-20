package com.todo.repository;

import com.todo.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing {@link TodoItem} entities.
 * -------
 * This interface provides CRUD operations for {@link TodoItem} objects by extending
 * the {@link JpaRepository} interface, which comes with built-in implementations for common
 * data access operations such as saving, deleting, and finding entities.
 * -----------
 * The {@code @Repository} annotation indicates that this interface is a Spring Data repository,
 * which will be automatically implemented by Spring Data JPA at runtime.
 */
@Repository
public interface TodoRepository extends JpaRepository<TodoItem, Long> {
    // No additional methods are required at this time as JpaRepository
    // provides the necessary CRUD operations for TodoItem.
}

package com.todo.service;

import com.todo.model.TodoItem;
import com.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing To-Do items.
 * ------
 * This class provides methods to perform operations on To-Do items, including
 * retrieving all To-Do items, finding a specific item by its ID, creating new items,
 * updating existing items, and deleting items. It interacts with the repository
 * layer to perform these operations.
 */
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    /**
     * Constructs a new {@link TodoService} instance.
     * -----
     * This constructor is used by Spring to inject the {@link TodoRepository} dependency.
     *
     * @param todoRepository the repository used to perform CRUD operations on To-Do items
     */
    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    /**
     * Retrieves all To-Do items.
     */
    public List<TodoItem> getAllTodos() {
        return todoRepository.findAll();
    }

    /**
     * Retrieves a To-Do item by its ID.
     */
    public Optional<TodoItem> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    /**
     * This method saves a new To-Do item to the database using the repository.
     */
    public void createTodoItem(TodoItem todoItem) {
        todoRepository.save(todoItem);
    }

    /**
     * Updates an existing To-Do item.
     * -----
     * This method updates an existing To-Do item in the database based on the provided ID
     * and new information. If the item with the specified ID is found, it is updated
     * and saved back to the repository.

     * @return the updated {@link TodoItem} if the update was successful, or null if not found
     */
    public TodoItem updateTodoItem(Long id, TodoItem todoItem) {
        Optional<TodoItem> existingTodo = todoRepository.findById(id);
        if (existingTodo.isPresent()) {
            TodoItem updatedTodo = existingTodo.get();
            updatedTodo.setTitle(todoItem.getTitle());
            updatedTodo.setDescription(todoItem.getDescription());
            updatedTodo.setCompleted(todoItem.isCompleted());
            return todoRepository.save(updatedTodo);
        } else {
            return null;
        }
    }

    /**
     * This method removes the To-Do item with the specified ID from the database.
     */
    public void deleteTodoItem(Long id) {
        todoRepository.deleteById(id);
    }
}

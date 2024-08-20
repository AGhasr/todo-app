package com.todo.controller;

import com.todo.model.TodoItem;
import com.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 * Controller class to handle CRUD operations for To-Do items.
 * This controller manages the creation, editing, deletion, and updating of To-Do items.
 */
@Controller
public class TodoController {

    private final TodoService todoService;

    /**
     * Autowired constructor to inject TodoService dependency.
     */
    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    /**
     * Displays the form for creating a new To-Do item.
     *
     * @param model the model to pass data to the view.
     * @return the name of the view for creating a new To-Do item.
     */
    @GetMapping("/create-todo")
    public String showCreateForm(Model model) {
        model.addAttribute("todoItem", new TodoItem());
        return "new-todo-item";
    }

    /**
     * Handles the submission of a new To-Do item.
     *
     * @param todoItem the To-Do item to be created.
     * @param result the binding result for validation.
     * @param model the model to pass data to the view in case of validation errors.
     * @return a redirect to the home page if successful, or the form view if there are validation errors.
     */
    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("todoItem", todoItem);
            return "new-todo-item";
        }
        todoService.createTodoItem(todoItem);
        return "redirect:/home";
    }

    /**
     * Handles the deletion of a To-Do item by ID.
     *
     * @param id the ID of the To-Do item to be deleted.
     * @return a redirect to the home page after deletion.
     */
    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id) {
        todoService.deleteTodoItem(id);
        return "redirect:/home";
    }

    /**
     * Displays the form for editing an existing To-Do item.
     *
     * @param id the ID of the To-Do item to be edited.
     * @param model the model to pass data to the view.
     * @return the name of the view for editing the To-Do item.
     */
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        TodoItem todoItem = todoService
                .getTodoById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id: " + id + " not found"));
        model.addAttribute("todo", todoItem);
        return "edit-todo";
    }

    /**
     * Handles the submission of an updated To-Do item.
     *
     * @param id the ID of the To-Do item to be updated.
     * @param todoItem the updated To-Do item.
     * @param result the binding result for validation.
     * @param model the model to pass data to the view in case of validation errors.
     * @return a redirect to the home page if successful, or the form view if there are validation errors.
     */
    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable("id") Long id, @Valid TodoItem todoItem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("todo", todoItem);
            return "edit-todo";
        }
        todoService.updateTodoItem(id, todoItem);
        return "redirect:/home";
    }
}

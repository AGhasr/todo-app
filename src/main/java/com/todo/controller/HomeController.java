package com.todo.controller;

import com.todo.model.TodoItem;
import com.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * This controller provides methods to handle requests for displaying the list of all To-Do items
 * on the home page. It interacts with the {@link TodoService} to retrieve the necessary data.
 */
@Controller
public class HomeController {

    private final TodoService todoService;

    /**
     * This constructor is used by Spring to inject the {@link TodoService} dependency.
     */
    @Autowired
    public HomeController(TodoService todoService) {
        this.todoService = todoService;
    }

    /**
     * Handles GET requests to the root URL ("/").
     * ----------
     * This method retrieves all To-Do items from the service and adds them to the model,
     * which is then used to render the home page view. The view displays a list of To-Do items.
     *
     * @return a {@link ModelAndView} object containing the view name ("displayTodoList") and the model
     *         with the list of To-Do items
     */
    @GetMapping("/")
    public ModelAndView index() {
        List<TodoItem> todoItems = todoService.getAllTodos();
        ModelAndView modelAndView = new ModelAndView("todo-list");
        modelAndView.addObject("todoItems", todoItems);
        return modelAndView;
    }
}

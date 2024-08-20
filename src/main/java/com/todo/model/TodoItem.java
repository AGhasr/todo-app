package com.todo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

/**
 * Represents a To-Do item in the application.
 * -----
 * This entity class includes information such as title, description, completion status,
 * and timestamps for creation and updates. It maps to the "todo_items" table in the database.
 */
@Setter
@Getter
@Entity
@Table(name = "todo_items")
public class TodoItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Unique identifier for the To-Do item.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Title of the To-Do item.
     * This field is mandatory and must not be blank.
     */
    @NotBlank(message = "Title is mandatory")
    private String title;

    /**
     * Description of the To-Do item.
     * This field is optional and can be left blank.
     */
    private String description;

    /**
     * Indicates whether the To-Do item has been completed.
     */
    private boolean completed;

    /**
     * This field is automatically set when the item is first persisted.
     */
    private Instant createdAt;

    /**
     * This field is automatically updated whenever the item is modified.
     */
    private Instant updatedAt;

    /**
     * Default constructor.
     */
    public TodoItem() {}

    /**
     * Constructor with parameters to create a new To-Do item.
     *
     * @param title the title of the To-Do item
     * @param description the description of the To-Do item
     * @param completed the completion status of the To-Do item
     */
    public TodoItem(String title, String description, boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    /**
     * @return a string representation of the To-Do item
     */
    @Override
    public String toString() {
        return String.format("TodoItem{id=%d, title=%s, description=%s, completed=%s, createdAt=%s, updatedAt=%s}",
                id, title, description, completed, createdAt, updatedAt);
    }

    /**
     * Callback method that is invoked before the To-Do item is persisted to the database.
     * Sets the creation and update timestamps.
     */
    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
        updatedAt = Instant.now();
    }

    /**
     * Callback method that is invoked before the To-Do item is updated in the database.
     * Updates the timestamp for the last modification.
     */
    @PreUpdate
    protected void onUpdate() {
        updatedAt = Instant.now();
    }
}

package com.example;

import java.time.LocalDate;

public class Task {
    public String description;
    public boolean isDone;
    public LocalDate dueDate;

    Task(String description, LocalDate dueDate) {
        this.description = description;
        this.dueDate = dueDate;
        this.isDone = false;
    }

    @Override
    public String toString() {
        String status = isDone ? "[✓] " : "[ ] ";
        String dateStr = dueDate != null ? dueDate.toString() : "No due date";
        return status + " " + description + "(Due: " + dateStr + ")";
    }
}

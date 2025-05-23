package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static  org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    @BeforeEach
    void setup(){
        TaskManager.tasks.clear();
    }

    @Test
    void testAddTask(){
        Task task = new Task("Test task", LocalDate.now());
        TaskManager.tasks.add(task);

        assertEquals(1, TaskManager.tasks.size());
        assertEquals("Test task", TaskManager.tasks.get(0).description);
    }

    @Test
    void testMarkTaskDone(){
        Task task = new Task("Finish test", LocalDate.now());
        TaskManager.tasks.add(task);

        TaskManager.tasks.get(0).isDone = true;

        assertTrue(TaskManager.tasks.get(0).isDone);
    }

    @Test
    void testDeleteTask(){
        Task task = new Task("To be deleted", null);
        TaskManager.tasks.add(task);

        TaskManager.tasks.remove(0);

        assertTrue(TaskManager.tasks.isEmpty());
    }

    @Test
    void testSaveAndLoadTasksJson(){
        Task task = new Task("Persist me", LocalDate.of(2024, 6, 1));
        task.isDone = true;
        TaskManager.tasks.add(task);

        TaskStorage.saveTasks(TaskManager.tasks);
        List<Task> loaded = TaskStorage.loadTasks();

        assertEquals(1, loaded.size());
        assertEquals("Persist me", loaded.get(0).description);
        assertTrue(loaded.get(0).isDone);
        assertEquals(LocalDate.of(2024, 6, 1), loaded.get(0).dueDate);
    }
}

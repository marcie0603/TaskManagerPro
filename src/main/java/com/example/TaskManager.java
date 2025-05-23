package com.example;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TaskManager {

    static List<Task> tasks = TaskStorage.loadTasks();
    static Scanner scanner = new Scanner(System.in);

/*    static void loadTasksFromFile() {
        File file = new File("tasks.txt");
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                boolean isDone = line.startsWith("[✓]");
                int dueIndex = line.lastIndexOf("(Due: ");

                String description = line.substring(3, dueIndex).trim();
                String dueDateStr = line.substring(dueIndex + 6, line.length() -1).trim();

                LocalDate dueDate = null;
                if(!dueDateStr.equalsIgnoreCase("No due date")){
                    try{
                        dueDate = LocalDate.parse(dueDateStr);
                    } catch (Exception e){
                        System.out.println("Could not parse due date: " + dueDateStr);
                    }
                }

                Task task = new Task(description, dueDate);
                task.isDone = isDone;
                tasks.add(task);
            }
        } catch (IOException e) {
            System.out.println("Could not load tasks");
        }
    }*/

    public static void main(String[] args) {
        // loadTasksFromFile();
        while (true) {
            System.out.println("\n--- main.java.com.example.Task Manager ---");
            System.out.println("1. Add main.java.com.example.Task");
            System.out.println("2. View main.java.com.example.Task");
            System.out.println("3. Mark main.java.com.example.Task as Done");
            System.out.println("4. Delete main.java.com.example.Task");
            System.out.println("5. View Tasks Due Before Date");
            System.out.println("6. Exit");
            System.out.println("Choose an option: ");

            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> markTaskDone();
                case 4 -> deleteTask();
                case 5 -> viewUpcomingTasks();
                case 6 -> {
                    TaskStorage.saveTasks(tasks);
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    static void addTask() {
        System.out.println("Enter task description: ");
        String desc = scanner.nextLine();

        System.out.println("Enter due date (YYYY-MM-DD) or leave blank: ");
        String dateInput = scanner.nextLine();

        LocalDate dueDate = null;
        if (!dateInput.isBlank()) {
            try {
                dueDate = LocalDate.parse(dateInput);
            } catch (Exception e) {
                System.out.println("Inavlid date format. Setting due date as none.");
            }
        }

        tasks.add(new Task(desc, dueDate));
        System.out.println("main.java.com.example.Task added");
    }

    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    static void markTaskDone() {
        viewTasks();
        System.out.println("Enter task number to mark as done: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index >= 0 && index < tasks.size()) {
                tasks.get(index).isDone = true;
                System.out.println("main.java.com.example.Task marked as done.");
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number. ");
        }
    }

    static void deleteTask() {
        viewTasks();
        System.out.println("Enter task number to delete: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index >= 0 && index < tasks.size()) {
                tasks.remove(index);
                System.out.println("main.java.com.example.Task deleted.");
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number. ");
        }
    }

    static void viewUpcomingTasks() {
        System.out.println("Enter date to filter before (YYYY-MM-DD): ");
        String input = scanner.nextLine();

        try {
            LocalDate filterDate = LocalDate.parse(input);
            System.out.println("Tasks due before " + filterDate + ":");

            boolean found = false;
            for (Task task : tasks) {
                if (task.dueDate != null && task.dueDate.isBefore(filterDate)) {
                    System.out.println("- " + task);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No tasks due before that date.");
            }
        } catch (Exception e) {
            System.out.println("Invalid date format.");
        }
    }

/*    static void TaskStorage.saveTasks(tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tasks.txt"))) {
            for (Task task : tasks) {
                writer.write(task.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not save tasks.");
        }
    }*/
}

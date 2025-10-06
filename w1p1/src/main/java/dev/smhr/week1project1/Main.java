package dev.smhr.week1project1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scnr = new Scanner(System.in)) {
            TaskManager taskManager = new TaskManager();
            String option = printMenu(scnr);
            while (!option.equals("4")) {
                switch (option) {
                    case "1":
                        askUserInputAndAddTask(scnr, taskManager);
                        break;
                    case "2":
                        viewAllTask(taskManager);
                        break;
                    case "3":
                        markTaskComplete(scnr, taskManager);
                        break;
                }
                option = printMenu(scnr);
            }
        }

    }

    public static void markTaskComplete(Scanner scnr, TaskManager taskManager) {
        viewAllTask(taskManager);
        System.out.print("Your choice (1, 2, 3, 4): ");
        String userChoice = scnr.next();
        Integer id = Integer.parseInt(userChoice);
        taskManager.markTaskCompleted(id);
        System.out.println("Mark as Completed");
    }

    public static void viewAllTask(TaskManager taskManager) {
        System.out.print("\nCurrent Tasks:");
        taskManager.printAllTask();
    }

    public static void askUserInputAndAddTask(Scanner scnr, TaskManager taskManager) {
        System.out.print("Add Task? (Y or N): ");
        String userChoice = scnr.next();

        if ((userChoice.equals("Y") || userChoice.equals("y"))) {
            System.out.print("Enter Description: ");
            String description = scnr.next();
            System.out.print("Enter Priority (LOW, MEDIUM, HIGH): ");
            Priority priority = Priority.valueOf(scnr.next().toUpperCase());
            System.out.print("Enter Due Date: ");
            String dueDate = scnr.next();
            System.out.print("Enter Status (PENDING, COMPLETED, PROGRESS): ");
            Status status = Status.valueOf(scnr.next().toUpperCase());
            taskManager.addTask(description, priority, dueDate, status);
            System.out.println("Task Added");
        }
    }

    public static String printMenu(Scanner scnr) {
        System.out.println("Select from options: ");
        System.out.println("1. Add Task");
        System.out.println("2. View Tasks");
        System.out.println("3. Mark Task Complete");
        System.out.println("4. Exit");

        System.out.print("Your choice (1, 2, 3, 4): ");
        return scnr.next();
    }
}

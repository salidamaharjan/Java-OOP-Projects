package dev.smhr.week1project1;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> taskList = new ArrayList<>();

    public TaskManager() {
        addTask("Study", Priority.HIGH, "09/29/2025", Status.PROGRESS);
        addTask("Cook", Priority.LOW, "09/29/2025", Status.PENDING);
    }

    public void addTask(String description, Priority priority, String dueDate, Status status) {
        Task task = new Task(description, priority, dueDate, status);
        taskList.add(task);
    }

    public void printAllTask() {
        System.out.println();
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(i + 1 + "." + taskList.get(i));
        }
    }

    public void markTaskCompleted(Integer id) {
        // out of bound check and doing nothing
        if (id.equals(0)) return;
        if (id > taskList.size()) return;
        // id-1 because in line 22 we print id as (i + 1)
        taskList.get(id - 1).setStatus(Status.COMPLETED);
    }

}

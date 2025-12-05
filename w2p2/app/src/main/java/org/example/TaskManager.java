package org.example;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private static TaskManager taskManager = null;
    private final List<Task> taskList = new ArrayList<>();

    public static TaskManager getInstance() {
        if (taskManager == null)
            taskManager = new TaskManager();

        return taskManager;
    }

    public List<Task> getTaskList() {
        return this.taskList;
    }

    public void addTask(String description, Priority priority, String dueDate, Status status) {
        Task task = new Task(description, priority, dueDate, status);
        taskList.add(task);
    }

    public void clear() {
        taskList.clear();
    }

    public void markTaskCompleted(Integer id) {
        if (id.equals(0)) return;
        System.out.println("taskList size " + taskList.size());
        if (id > taskList.size()) return;
        taskList.get(id - 1).setStatus(Status.COMPLETED);
        System.out.println("Mark completed");
    }

}

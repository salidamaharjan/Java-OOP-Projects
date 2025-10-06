package dev.smhr.week1project1;

public class Task {
    private String description;
    private Priority priority;
    private String dueDate;
    private Status status;

    public Task(String description, Priority priority, String dueDate, Status status) {
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return this.status;
    }

    public String toString() {
        return "Description: " + description + ", Priority: " + priority + ", Due Date: " + dueDate + ", Status: " + status;
    }
}

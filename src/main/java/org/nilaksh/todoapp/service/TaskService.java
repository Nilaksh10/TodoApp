package org.nilaksh.todoapp.service;

import org.nilaksh.todoapp.Repository.TaskRepository;
import org.nilaksh.todoapp.models.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private  final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }



    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createTasks(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }
    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Task not found"));
        task.setCompleted(!task.getCompleted());
        taskRepository.save(task);
    }
}

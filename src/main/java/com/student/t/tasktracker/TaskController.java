// ✅ FIXED - MATCHES YOUR FOLDER
package com.student.t.tasktracker;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    // ✅ Create Task
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    // ✅ Get All Tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // ✅ Get Task by ID
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable String id) {
        return taskRepository.findById(id);
    }

    // ✅ Update Task
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable String id, @RequestBody Task task) {
        task.setId(id);
        return taskRepository.save(task);
    }

    // ✅ Delete Task
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        taskRepository.deleteById(id);
    }
}

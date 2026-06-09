package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    @Cacheable("tasks")
    public List<Task> getAll() {
        return (List<Task>) repo.findAll();
    }

    @CacheEvict(value = "tasks", allEntries = true)
    public Task save(Task t) {
        return (Task) repo.save(t);
    }

    @CacheEvict(value = "tasks", allEntries = true)
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
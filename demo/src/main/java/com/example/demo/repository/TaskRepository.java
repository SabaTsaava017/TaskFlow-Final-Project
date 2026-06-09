package com.example.demo.repository;

import com.example.demo.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Object save(Task t);

    Object findAll();

    void deleteById(long l);}
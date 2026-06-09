package com.example.demo;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    TaskRepository repo = Mockito.mock(TaskRepository.class);
    TaskService service = new TaskService(repo);

    @Test
    void testSave() {
        Task t = new Task();
        t.setTitle("Test");

        Mockito.when(repo.save(t)).thenReturn(t);

        assertEquals("Test", service.save(t).getTitle());
    }

    @Test
    void testGetAll() {
        Mockito.when(repo.findAll()).thenReturn(List.of(new Task()));
        assertEquals(1, service.getAll().size());
    }

    @Test
    void testDelete() {
        service.delete(1L);
        Mockito.verify(repo).deleteById(1L);
    }
}

package com.example.springbootproject.controller;

import com.example.springbootproject.entity.Worker;
import com.example.springbootproject.repository.WorkerRepository;
import com.example.springbootproject.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class WorkerController {

    @Autowired
    WorkerRepository repository;

    @Autowired
    WorkerService workerService;

    @PostMapping("/workers")
    public ResponseEntity<Worker> addWorker(@RequestBody Worker worker) {
        return ResponseEntity.ok(repository.save(worker));
    }

    @GetMapping("/workers")
    public List<Worker> getAllWorkers() {
        return repository.findAll();
    }
    
    @PutMapping("/workers/{id}")
    public ResponseEntity<Worker> updateWorker(@RequestBody Worker worker, @PathVariable int id) {
        worker.setId(id);
       Worker returnValue = workerService.updateDeparture(worker);

        if (Objects.isNull(returnValue)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(returnValue);
        }
    }
}

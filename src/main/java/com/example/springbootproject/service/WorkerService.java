package com.example.springbootproject.service;

import com.example.springbootproject.logger.Logger;
import com.example.springbootproject.entity.Worker;
import com.example.springbootproject.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkerService {
    @Autowired
    WorkerRepository workerRepository;

    @Autowired
    Logger logger;

    public Worker updateWorker(Worker worker) {
        Optional<Worker> workerById = workerRepository.findById(worker.getId());

        if (workerById.isEmpty()) {
            logger.logMessage(String.format("No such worker to update with id = %s", worker.getId()));
            return null;
        } else {
            return workerRepository.save(worker);
        }
    }

}

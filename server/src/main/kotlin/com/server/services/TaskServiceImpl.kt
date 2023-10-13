package com.server.services

import com.server.config.exception.TaskNotFoundException
import com.server.models.Task
import com.server.repositories.TaskRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class TaskServiceImpl(private val taskRepository: TaskRepository) : TaskService {

    @Transactional
    override fun findAll(): MutableList<Task> {
        return taskRepository.findAll();
    }

    @Transactional
    override fun findById(id: UUID): Task {
//        val taskOptional : Optional<Task> = taskRepository.findById(id);
//        if(!taskOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found.");
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(taskOptional.get());
//        if(!taskOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found.");
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(taskOptional.get());
        return taskRepository.findById(id).orElseThrow { TaskNotFoundException() }
    }

    @Transactional
    override fun create(model: Task): Task {
        return taskRepository.save(model);
    }

    @Transactional
    override fun update(model: Task): Task {
//        if (model.id !== id) {
//            return throw TaskNotFoundException();
//        }
        val task = this.findById(model.id!!);

        task.title = model.title;
        task.description = model.description;
        task.status = model.status;
        task.priority = model.priority;

        return this.create(task);
    }

    @Transactional
    override fun delete(id: UUID) {
        taskRepository.delete(this.findById(id));
    }
}
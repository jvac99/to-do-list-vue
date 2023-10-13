package com.server.controllers

import com.server.models.Task
import com.server.services.TaskService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.Optional
import java.util.UUID


@RestController
@CrossOrigin(origins = ["*"], maxAge = 3600)
@RequestMapping("task")
class TaskController(val taskService: TaskService) {

    @PostMapping
    fun saveTask(@RequestBody task: Task): ResponseEntity<Task> =
        ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(task));

    @GetMapping
    fun getAllTask(): ResponseEntity<MutableList<Task>> {
        return ResponseEntity.ok(taskService.findAll());
    }

    @GetMapping("/{id}")
    fun getOneTask(@PathVariable(value = "id") id: UUID): ResponseEntity<Task> {
        return ResponseEntity.ok(taskService.findById(id));
    }

    @PutMapping
    fun updateTask(@RequestBody task: Task): ResponseEntity<Task> {
//        val taskOptional : Optional<Task> = taskRepository.findById(id);
//        if(!taskOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found.");
//        }
//        var taskModel: Task = taskOptional.get();
//        taskModel.title = task.title;
//        return ResponseEntity.status(HttpStatus.OK).body(taskRepository.save(taskModel));
        return ResponseEntity.ok(taskService.update(task))
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable(value = "id") id: UUID): ResponseEntity<Unit> {
//        val taskOptional : Optional<Task> = taskRepository.findById(id);
//        if(!taskOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found.");
//        }
//        taskRepository?.delete(taskOptional.get());
//        return ResponseEntity.status(HttpStatus.OK).body("Task deleted successfully");
        return ResponseEntity.ok(taskService.delete(id))
    }
}
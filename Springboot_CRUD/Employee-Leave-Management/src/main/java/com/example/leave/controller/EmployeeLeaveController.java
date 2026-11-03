package com.example.leave.controller;

import com.example.leave.model.EmployeeLeave;
import com.example.leave.service.EmployeeLeaveService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/leaves")
public class EmployeeLeaveController {

    private final EmployeeLeaveService service;

    public EmployeeLeaveController(EmployeeLeaveService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeLeave applyLeave(@Valid @RequestBody EmployeeLeave leave) {
        return service.applyLeave(leave);
    }

    @GetMapping
    public List<EmployeeLeave> getAllLeaves() {
        return service.getAllLeaves();
    }

    @GetMapping("/{id}")
    public EmployeeLeave getLeaveById(@PathVariable Long id) {
        EmployeeLeave leave = service.getLeaveById(id);
        if (leave == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Leave not found");
        }
        return leave;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLeave(@PathVariable Long id) {
        if (!service.deleteLeave(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Leave not found");
        }
    }
}

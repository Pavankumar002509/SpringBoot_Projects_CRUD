package com.example.leave.service;

import com.example.leave.model.EmployeeLeave;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeLeaveService {

    private final List<EmployeeLeave> leaves = new ArrayList<>();
    private long nextId = 1;

    public EmployeeLeave applyLeave(EmployeeLeave leave) {
        leave.setEmployeeId(nextId++);
        leaves.add(leave);
        return leave;
    }

    public List<EmployeeLeave> getAllLeaves() {
        return new ArrayList<>(leaves);
    }

    public EmployeeLeave getLeaveById(Long id) {
        for (EmployeeLeave leave : leaves) {
            if (leave.getEmployeeId().equals(id)) {
                return leave;
            }
        }
        return null;
    }

    public boolean deleteLeave(Long id) {
        EmployeeLeave leave = getLeaveById(id);
        return leave != null && leaves.remove(leave);
    }
}

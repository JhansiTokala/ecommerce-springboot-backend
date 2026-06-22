package com.jhansi.ecommerce.controller;

import com.jhansi.ecommerce.dto.DashboardResponse;
import com.jhansi.ecommerce.service.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(
            AdminService adminService) {

        this.adminService = adminService;
    }

    @GetMapping("/dashboard")
    public DashboardResponse getDashboard() {

        return adminService.getDashboard();
    }
}
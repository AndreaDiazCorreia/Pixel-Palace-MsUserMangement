package com.pixelpalace.msUserManagement.controller;


import com.pixelpalace.msUserManagement.model.PixelUser;
import com.pixelpalace.msUserManagement.service.PixelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class PixelUserController {
    @Autowired
    PixelUserService pixelUserService;

    public PixelUserController(PixelUserService pixelUserService) {
        this.pixelUserService = pixelUserService;
    }

    @PutMapping("/{id}")
    public PixelUser update(@PathVariable Long id, @RequestBody PixelUser user) {
        return pixelUserService.update(id, user);
    }
}






package com.example.user.controller;

import com.example.user.model.PixelUser;
import com.example.user.service.PixelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class PixelUserController {
    @Autowired
    PixelUserService pixelUserService;

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody PixelUser pixelUser) throws Exception {
        pixelUserService.postUser(pixelUser);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

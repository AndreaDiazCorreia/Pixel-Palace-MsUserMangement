package com.pixelpalace.msUserManagement.controller;

import com.pixelpalace.msUserManagement.model.PixelUser;
import com.pixelpalace.msUserManagement.service.PixelUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class PixelUserController {
    @Autowired
    PixelUserService pixelUserService;

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody PixelUser pixelUser) throws Exception {
        pixelUserService.postUser(pixelUser);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado exitosamente");
    }


    @DeleteMapping(path = "/{id}")
    public void deleteUser( @PathVariable long id, HttpServletRequest request){
        PixelUser userDelete =  pixelUserService.findById(id);

        pixelUserService.deleteUser(userDelete);
    }

    @GetMapping("by_username/{username}")
    public ResponseEntity<PixelUser>findbyUsername(@PathVariable String username){
        PixelUser pixelUser = pixelUserService.findByUsername(username);
        if (pixelUser != null){
            return ResponseEntity.ok(pixelUser);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("by_email/{email}")
    public ResponseEntity<PixelUser>findbyEmail(@PathVariable String email){
        PixelUser pixelUser = pixelUserService.findByEmail(email);
        if (pixelUser != null){
            return ResponseEntity.ok(pixelUser);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    /*
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") long id){
        try {
            pixelUserService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario eliminado exitosamente");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo eliminar al usuario");
        }
    }

     */
}
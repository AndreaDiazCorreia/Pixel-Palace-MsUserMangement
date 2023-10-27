package com.pixelpalace.msUserManagement.service;

import com.pixelpalace.msUserManagement.model.PixelUser;
import org.springframework.http.ResponseEntity;

public interface PixelUserService {
    void postUser(PixelUser pixelUser) throws Exception;

//    ResponseEntity<Object> deleteUser(long id);

    void  deleteUser(PixelUser pixelUser);

    PixelUser findById(long id);

    PixelUser findByUsername(String username);
    PixelUser findByEmail(String email);
}
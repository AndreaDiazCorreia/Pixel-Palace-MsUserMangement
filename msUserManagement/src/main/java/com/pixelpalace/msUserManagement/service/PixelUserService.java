package com.pixelpalace.msUserManagement.service;

import com.pixelpalace.msUserManagement.model.PixelUser;
import org.springframework.http.ResponseEntity;

public interface PixelUserService {
    void postUser(PixelUser pixelUser) throws Exception;

    ResponseEntity<Object> deleteUser(long id);

     PixelUser update(Long id, PixelUser user);
}

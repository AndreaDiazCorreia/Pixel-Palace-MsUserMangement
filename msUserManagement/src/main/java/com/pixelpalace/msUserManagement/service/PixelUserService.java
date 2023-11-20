package com.pixelpalace.msUserManagement.service;

import com.pixelpalace.msUserManagement.Dto.LoginDto;
import com.pixelpalace.msUserManagement.Dto.PixelUserDto;
import com.pixelpalace.msUserManagement.Dto.Response.LoginResponse;
import com.pixelpalace.msUserManagement.model.PixelUser;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface PixelUserService {
    String postUser(PixelUserDto pixelUserDto);

    Optional<PixelUser> findOneByUsernameAndPassword(String username, String password);

//   ResponseEntity<Object> deleteUser(long id);

    ResponseEntity<Object> deleteUser(long id);

    PixelUser findById(long id);

    PixelUser findByUsername(String username);
    PixelUser findByEmail(String email);

    PixelUser update(Long id, PixelUser user) throws ChangeSetPersister.NotFoundException;

    LoginResponse Login_user (LoginDto loginDto);
}
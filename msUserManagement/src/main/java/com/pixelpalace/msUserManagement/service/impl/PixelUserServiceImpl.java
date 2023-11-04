package com.pixelpalace.msUserManagement.service.impl;

import com.pixelpalace.msUserManagement.model.PixelUser;
import com.pixelpalace.msUserManagement.repository.PixelUserRepository;
import com.pixelpalace.msUserManagement.service.PixelUserService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PixelUserServiceImpl implements PixelUserService {
PixelUserRepository pixelUserRepository;

    public PixelUserServiceImpl(PixelUserRepository repository) {
        this.pixelUserRepository = repository;
    }

    @Override
    public PixelUser update(Long id, PixelUser user) {
        PixelUser existingUser = pixelUserRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found with id: " + id));


        existingUser.setName(user.getName());
        existingUser.setLastname(user.getLastname());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setBirthday(user.getBirthday());


        return pixelUserRepository.save(existingUser);
    }

}

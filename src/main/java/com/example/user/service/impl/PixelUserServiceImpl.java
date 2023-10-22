package com.example.user.service.impl;

import com.example.user.model.PixelUser;
import com.example.user.repository.PixelUserRepository;
import com.example.user.service.PixelUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PixelUserServiceImpl implements PixelUserService {

    @Autowired
    PixelUserRepository pixelUserRepository;

    @Autowired
    ObjectMapper mapper;

    public void postUser(PixelUser pixelUser) throws Exception{
        try {
            pixelUserRepository.save(pixelUser);
        } catch (Exception e){
            throw new Exception("No se pudo guardar el usuario", e);
        }
    }

}

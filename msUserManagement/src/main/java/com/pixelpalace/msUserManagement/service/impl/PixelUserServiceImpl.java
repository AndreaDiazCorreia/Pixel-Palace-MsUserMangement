package com.pixelpalace.msUserManagement.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pixelpalace.msUserManagement.model.PixelUser;
import com.pixelpalace.msUserManagement.repository.PixelUserRepository;
import com.pixelpalace.msUserManagement.service.PixelUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    public ResponseEntity<Object> deleteUser(long id){
        if (!pixelUserRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario con ID " + id + " no se encontró en la base de datos.");
        }

            try {

            pixelUserRepository.deleteById(id);
            return ResponseEntity.ok("El usuario con ID " + id + " ha sido eliminado correctamente.");

            }catch (EmptyResultDataAccessException e){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo eliminar al usuario.");
        }
    }


}

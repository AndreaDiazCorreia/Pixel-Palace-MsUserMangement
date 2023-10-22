package com.example.user.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


@Data
@Entity
@Table(name = "user")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class PixelUser {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastname;
    private String username;
    private String password;
    private String email;
    //private List<Productos>; //queda pendiente este atributo

    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private String birthday;


}

package com.pixelpalace.msUserManagement.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pixelpalace.msUserManagement.Dto.PixelUserDto;
import com.pixelpalace.msUserManagement.util.Rol;
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

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private String birthday;

    @JsonIgnore
    private String existingName;
    @JsonIgnore
    private String existingLastname;
    @JsonIgnore
    private String existingUsername;
    @JsonIgnore
    private String existingPassword;
    @JsonIgnore
    private String existingEmail;
    @JsonIgnore
    private String existingBirthday;




    public PixelUser(PixelUserDto pixelUserDto) {
        this.id = pixelUserDto.getId();
        this.name = pixelUserDto.getName();
        this.lastname = pixelUserDto.getLastname();
        this.birthday = pixelUserDto.getBirthday();
        this.username = pixelUserDto.getUsername();
        this.email = pixelUserDto.getEmail();
        this.password = pixelUserDto.getPassword();

    }



    public PixelUser() {

    }
}

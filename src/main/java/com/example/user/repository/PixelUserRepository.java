package com.example.user.repository;

import com.example.user.model.PixelUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PixelUserRepository extends JpaRepository<PixelUser, Long> {

}

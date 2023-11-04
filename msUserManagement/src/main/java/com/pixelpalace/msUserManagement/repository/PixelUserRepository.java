package com.pixelpalace.msUserManagement.repository;

import com.pixelpalace.msUserManagement.model.PixelUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PixelUserRepository extends JpaRepository <PixelUser, Long>{

}

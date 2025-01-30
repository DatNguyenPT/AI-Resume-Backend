package com.DatNguyen.ImageGenerator.Repository;

import com.DatNguyen.ImageGenerator.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    @Query("SELECT u FROM Users u WHERE u.email = :email")
    Users findByEmail(@Param("email") String email);
    Users findByUserID(UUID userID);

}

package com.example.validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.validation.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>
{

}

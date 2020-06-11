package com.advancedjava.springwebmvc.repository;

import com.advancedjava.springwebmvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}

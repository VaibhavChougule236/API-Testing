package com.ActuatorImpl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ActuatorImpl.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

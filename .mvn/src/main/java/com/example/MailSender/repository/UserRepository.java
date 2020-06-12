package com.example.MailSender.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.MailSender.model.User;

import java.util.List;
import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {


    Optional<User> deleteById(int id);


    User getOne(int i);


    User findByName(String name);
}
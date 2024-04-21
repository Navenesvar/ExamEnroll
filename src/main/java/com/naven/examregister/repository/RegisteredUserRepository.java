package com.naven.examregister.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naven.examregister.domain.RegisteredUser;

@Repository
public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Integer> {

    List<RegisteredUser> findAll();

    @SuppressWarnings("unchecked")
    RegisteredUser save(RegisteredUser registeredUser);

}


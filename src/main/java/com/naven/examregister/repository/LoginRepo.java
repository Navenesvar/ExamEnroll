package com.naven.examregister.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naven.examregister.domain.Login1;



@Repository
public interface LoginRepo extends JpaRepository<Login1, String>
{

    Login1 findByUsernameAndPassword(String username, String password);
    @SuppressWarnings("unchecked")
    Login1 save(Login1 login1);
   
}
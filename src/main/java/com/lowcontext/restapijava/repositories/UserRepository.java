package com.lowcontext.restapijava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lowcontext.restapijava.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

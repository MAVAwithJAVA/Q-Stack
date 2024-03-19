package com.qstack.codeflow.qstack.repositories;

import com.qstack.codeflow.qstack.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


}

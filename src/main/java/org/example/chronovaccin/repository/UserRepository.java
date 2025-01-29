package org.example.chronovaccin.repository;

import org.example.chronovaccin.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u.is_user, u.is_admin FROM User u WHERE u.email = ?1")
    List<String> findRolesByEmail(String userEmail);
}

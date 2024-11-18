package org.example.chronovaccin.repository;

import org.example.chronovaccin.entities.Center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CenterRepository extends JpaRepository<Center, Integer> {

    List<Center> findByName(String name);
    Optional<Center> findById(Integer id);

    @Query("SELECT c FROM Center c JOIN FETCH c.id")
    List<Center> findAllWithId();

    @Query("SELECT c FROM Center c JOIN Address a ON a.id = c.addressId WHERE a.city = :city")
    List<Center> findByCity(@Param("city") String city);
}

package org.boot.datajpa.repository;

import java.util.List; // Added import for List for custom queries
import org.boot.datajpa.entity.Contacts;
import org.springframework.data.jpa.repository.JpaRepository; // Changed from CrudRepository to JpaRepository as it's more common in Spring Data JPA and provides more features.
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, Integer> { // Changed to JpaRepository
    // Derived query method
    Contacts findByFirstName(String firstName);

    // Custom JPQL query
    @Query("select objContact from Contacts objContact where objContact.firstName like :criteria%")
    List<Contacts> showAllContactsLike(@Param("criteria") String like);

    // Custom native query
    @Query(value = "select * from contacts where first_name like :criteria%", nativeQuery = true)
    List<Contacts> showAllLike(@Param("criteria") String like);
}
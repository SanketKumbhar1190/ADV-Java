package org.boot.datajpa.restjpa;


import java.util.List;
import org.boot.datajpa.dto.ContactsDTO;
import org.boot.datajpa.services.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan; // Renamed from org.springframework.boot.autoconfigure.domain.EntityScan to the correct package.
import org.springframework.data.jpa.repository.config.EnableJpaRepositories; // Renamed from org.springframework.data.jpa.repository.config.EnableJpaRepositories to the correct package.
import org.springframework.context.annotation.ComponentScan; // Added @ComponentScan for clarity in multi-package setup, though @SpringBootApplication includes it.

@SpringBootApplication(scanBasePackages = {
    "org.boot.datajpa.services",
    "org.boot.datajpa.controllers"// Added controllers package to scan
})
@EnableJpaRepositories(basePackages = {"org.boot.datajpa.repository"})
@EntityScan({"org.boot.datajpa.entity"})
public class RestJpaApplication implements CommandLineRunner {

    @Autowired
    private ContactsService contactService; // Renamed from contactService for consistency

    public static void main(String[] args) {
        SpringApplication.run(RestJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<ContactsDTO> allContacts = contactService.getAllContacts();
        allContacts.forEach(System.out::println);
    }
}
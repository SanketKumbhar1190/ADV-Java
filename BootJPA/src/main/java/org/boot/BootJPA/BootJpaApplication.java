package org.boot.BootJPA;

import java.util.Iterator;
import java.util.Scanner;

import org.boot.BootJPA.dto.CategoryDTO;
import org.boot.BootJPA.repositories.CategoryRepository;
//import org.boot.BootJPA.repositories.UsersRepository;
import org.boot.BootJPA.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SuppressWarnings("unused")
@SpringBootApplication
//(scanBasePackages = {"org.boot.BootJPA.services"})
//@EntityScan(basePackages = {"org.boot.BootJPA.entity"})
//@EnableJpaRepositories(basePackages = {"org.boot.BootJPA.repositories"})
public class BootJpaApplication implements CommandLineRunner {
//    @Autowired
//    UsersRepository userRepo;
	


    @Autowired
    CategoryService categoryService;

    public static void main(String[] args) {
        SpringApplication.run(BootJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            // Category objCategory = categoryService.getCategoryById(1);
            // System.out.println(objCategory);

            Iterator<CategoryDTO> iter = categoryService.getAllCategories();
            iter.forEachRemaining(System.out::println);
        }
    }
}
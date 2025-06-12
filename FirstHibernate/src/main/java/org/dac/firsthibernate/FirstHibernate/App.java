package org.dac.firsthibernate.FirstHibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.cdac.pojo.Users;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        
        Configuration hibernateConfiguration = null;
        SessionFactory hibernateFactory = null;
        Session hibernateSession = null;
        
        try {
            hibernateConfiguration = new Configuration();
            hibernateConfiguration.configure("first.cfg.xml");
            hibernateFactory = hibernateConfiguration.buildSessionFactory();
            hibernateSession = hibernateFactory.openSession();
            
            try (Scanner scanner = new Scanner(System.in)) {
                
                System.out.println("Enter the username");
                String userName = scanner.next();
                
                System.out.println("Enter the pass");
                String password = scanner.next();
                
                System.out.println("Enter the name");
                String name = scanner.next();
                
                System.out.println("Enter the email");
                String email = scanner.next();
                
                System.out.println("Enter the city");
                String city = scanner.next();
                
                Users objuser = new Users(name, userName, password, email, city);
                
                hibernateSession.beginTransaction();
                
                hibernateSession.persist(objuser);
                
                hibernateSession.getTransaction().commit();
                
                System.out.println("User registered");
                
            } catch (Exception e) {
                if (hibernateSession != null && hibernateSession.getTransaction() != null) {
                    hibernateSession.getTransaction().rollback();
                }
                e.printStackTrace();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (hibernateSession != null)
                hibernateSession.close();
            if (hibernateFactory != null)
                hibernateFactory.close();
        }
    }
}
package main.java.com.fintech;

import javax.security.auth.login.Configuration;

import org.hibernate.SessionFactory;

public class HibernateUtil {
    private static SessionFactory factory;

    static {
        try {
            factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
                    .addAnnotatedClass(Genre.class).addAnnotatedClass(Game.class)
                    .addAnnotatedClass(Order.class).addAnnotatedClass(OrderItem.class)
                    .addAnnotatedClass(Payment.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getFactory() {
        return factory;
    }

    public static void closeFactory() {
        factory.close();
    }
}

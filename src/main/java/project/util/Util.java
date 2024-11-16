package project.util;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.cfg.Configuration;
import project.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Util {

    private static EntityManagerFactory entityFactory;

    public static EntityManager getEntityFactory() {
        if (entityFactory == null) {
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/project_2_3_1_mikv");
            configuration.setProperty("hibernate.connection.username", "root");
            configuration.setProperty("hibernate.connection.password", "djnaTWPI");
            configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            configuration.setProperty("hibernate.show_sql", "false");
            configuration.setProperty("hibernate.hbm2ddl.auto", "none");
            configuration.addPackage("src/main/java/project/model");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            entityFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return entityFactory.createEntityManager();
    }
}

package org.gs.db;

import org.flywaydb.core.Flyway;
import org.gs.entity.Client;
import org.gs.entity.Planet;
import org.gs.props.PropertiesUtil;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static final HibernateUtils INSTANCE = new HibernateUtils();
    private final SessionFactory sessionFactory;
    private static final String DB_URL_KEY = "hibernate.connection.url";

    private HibernateUtils() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .buildSessionFactory();

        flywayMigration(PropertiesUtil.getPropertyValue(DB_URL_KEY));
    }

    public static HibernateUtils getInstance() {
        return INSTANCE;
    }
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void closeSessionFactory() {
        sessionFactory.close();
    }

    private void flywayMigration(String dbConnectionUrl) {
        Flyway flyway = Flyway.configure().dataSource(dbConnectionUrl, null, null).load();
        flyway.migrate();
    }
}
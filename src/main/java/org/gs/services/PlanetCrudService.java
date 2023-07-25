package org.gs.services;

import org.gs.db.HibernateUtils;
import org.gs.entity.Planet;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class PlanetCrudService {
    public void createPlanet(Planet planet) {
        Session session = HibernateUtils.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(planet);
        transaction.commit();
        session.close();
    }

    public Planet getPlanetById(String id) {
        Session session = HibernateUtils.getInstance().getSessionFactory().openSession();
        Planet planet = session.get(Planet.class, id);
        session.close();
        return planet;
    }

    public void updatePlanet(Planet planet) {
        Session session = HibernateUtils.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(planet);
        transaction.commit();
        session.close();
    }

    public void deletePlanet(String id) {
        Session session = HibernateUtils.getInstance().getSessionFactory().openSession();;
        Transaction transaction = session.beginTransaction();
        Planet planet = session.get(Planet.class, id);
        session.remove(planet);
        transaction.commit();
        session.close();
    }

    public List<Planet> getAllPlanets() {
        Session session = HibernateUtils.getInstance().getSessionFactory().openSession();
        List<Planet> allPlanets = session.createQuery("FROM Planet", Planet.class).list();
        session.close();
        return allPlanets;
    }
}
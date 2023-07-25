package org.gs.services;

import org.gs.db.HibernateUtils;
import org.gs.entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ClientCrudService {
    public void createClient(Client client) {
        Session session = HibernateUtils.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(client);
        transaction.commit();
        session.close();
    }

    public Client getClientById(long id) {
        Session session = HibernateUtils.getInstance().getSessionFactory().openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }

    public void updateClient(Client client) {
        Session session = HibernateUtils.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(client);
        transaction.commit();
        session.close();
    }

    public void deleteClient(long id) {
        Session session = HibernateUtils.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Client client = session.get(Client.class, id);
        session.remove(client);
        transaction.commit();
        session.close();
    }

    public List<Client> getAllClients() {
        Session session = HibernateUtils.getInstance().getSessionFactory().openSession();
        List<Client> allClients = session.createQuery("FROM Client", Client.class).list();
        session.close();
        return allClients;
    }
}
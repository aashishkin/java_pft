package ru.stqa.pft.addressbook.appmanager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

public class DbHelper {

    private final SessionFactory sessionFactory;

    public DbHelper() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();

            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();


    }

    public Groups groups() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<GroupData> result = session.createQuery( "from GroupData" ).list();
        for ( GroupData group : result ) {
            System.out.println(group);
        }
        session.getTransaction().commit();
        session.close();
        return new Groups(result);

    }

    public int getGroupMaxId(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        int maxId = Integer.parseInt(session.createQuery( "select max(id) from GroupData" ).list().toString().replaceAll("[\\[\\]]", ""));
        session.getTransaction().commit();
        session.close();
        return maxId;
    }

}

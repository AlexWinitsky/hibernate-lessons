package hibernate_lessons;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
    	@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
 
		Person user = new Person();
		user.setFirstName("Alex");
		user.setSecondName("Vinitsky");
		session.save(user);
 
		session.getTransaction().commit();
		session.close();
    }
}

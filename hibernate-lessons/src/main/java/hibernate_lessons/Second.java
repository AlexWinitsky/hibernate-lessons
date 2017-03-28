package hibernate_lessons;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Second {
	 private SessionFactory sessionFactory;

	    public Second() {
	        try {
	            sessionFactory = new Configuration().configure().buildSessionFactory();
	            Session session = null;
	            try {
	            session = sessionFactory.openSession();
	            session.getTransaction().begin();
	            Person2 person2 = new Person2();
	            person2.setName("Dmitry");
	            Person1 person1 = new Person1();
	            person1.setName("Boiko");
	            session.save(person1); session.save(person2);
	            System.out.printf("Insert Person2: %s, Insert Person1: %s\n", person1,person2);
	            Long id = person2.getId();
	            session.getTransaction().commit();
	            session.close();
	            session = sessionFactory.openSession();
	            session.getTransaction().begin();
	            Person2 person = (Person2) session.get(Person2.class, id);
	            System.out.printf("Person select: %s\n", person);
	            session.getTransaction().commit();
	            } finally {
	              if (session!=null) session.close();
	            }

	        } finally {
	            if (sessionFactory != null) sessionFactory.close();
	        }
	    }

	    public static void main(String args[]) {
	        new Second();
	    }
}

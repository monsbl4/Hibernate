import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = Util.getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        Employee employee = new Employee((byte) 12,"Elena","Ch");
        Employee employee1 = new Employee((byte) 34,"Serg","Den");
        session.persist(employee);
        session.persist(employee1);
        System.out.println("Employee saved");
        tx.commit();


        Query query  = session.createQuery("select e from Employee e");
        List<Employee> list = query.list();
        for(Employee emp:list){
            System.out.println(emp.toString());
        }
        session.close();

    }
}

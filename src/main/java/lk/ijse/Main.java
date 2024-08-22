package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.embed.FullName;
import lk.ijse.entity.Employee;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       Session session = FactoryConfiguration.getInstance().getSession();

       FullName fullName = new FullName("Amali", "Perera");
       Student student = new Student();
       student.setId(2);
       student.setName(fullName);
       student.setAddress("Panadura");

       Employee employee = new Employee();
       employee.setId(2);
       employee.setName("isha");
       employee.setEmail("ish123@gmail.com");
       employee.setSalary(20000);

       Transaction transaction = session.beginTransaction();

       //session.delete("2",student);
       // session.save(student);
       // session.update(student);

       //session.save(employee);
       //session.update(employee);
       Employee employee1 = (Employee) session.get(Employee.class, "2");

       transaction.commit();  // Commit the transaction

       System.out.println(employee1);

       session.close();
    }
}
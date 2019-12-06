package program;


import DAO.DAO;
import model.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String args[]) throws SQLException, ParseException {
        //Student s = new Student("Lisa", 5.5, new Date(), 801);
        //DAO.addObject(s);
        //Driver d = new Driver(15, "a", s);
        //DAO.addObject(d);

        /*Professor professor = new Professor("Ivanenko", 73);
        DAO.addObject(professor);
        DAO.addObject(new Driver(10, "fkjek", professor));*/

       /* Car car1 = new Car("lada", "vlack","bbb", (Driver) DAO.getObjectById(21L, Driver.class));
        DAO.closeOpenedSession();
        Car car2 = new Car("opel", "black","aaaa",(Driver) DAO.getObjectById(21L, Driver.class));
        DAO.closeOpenedSession();
        DAO.addObject(car1);
        DAO.addObject(car2);*/


        /*List allObjects = DAO.getAllObjects(Professor.class);
        DAO.closeOpenedSession();
        DAO.addObject(new Student("Anton", 4.0, new Date(), 202, allObjects));*/

        List allObjects = DAO.getAllObjects(Subject.class);
        System.out.println(allObjects);
        DAO.closeOpenedSession();
        List gr_name = DAO.getObjectsByParam("groupName", 202, Student.class);
        System.out.println(gr_name);
        DAO.closeOpenedSession();
        DAO.addObject(new Subject("FFFF"));
        List<Subject> lst = new ArrayList<>();
        lst.add(new Subject("FFFF"));
        Professor f =new Professor("Telek", 46, gr_name,lst);
        DAO.addObject(f);
        DAO.addObject(new Driver(11,"abc",f ));

    }
}

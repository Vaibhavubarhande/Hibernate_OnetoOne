package com.carnation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.carnation.entity.Marks;
import com.carnation.entity.Student;

public class App 
{
    public static void main( String[] args ) {
    	
    
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class)
    													   .addAnnotatedClass(Marks.class); //Config
     	
     	SessionFactory sf = cfg.buildSessionFactory(); //Session build 
     	
     	Session session = sf.openSession(); //session open 
     	
     	session.beginTransaction(); //session start
     	
     	
     	Student st1 = new Student();
     	
     	st1.setRollno(1);
     	st1.setName("Vaibhav");
     	st1.setAddress("Pune");
     	
     	session.save(st1);
     	
     	Marks m1 = new Marks();
     	
     	m1.setId(101);
     	m1.setMath(98);
     	m1.setEnglish(99);
     	m1.setStudent(st1);
     	
     	session.save(m1);
     	
     	session.getTransaction().commit();
     	session.close(); //session close 

    }
}

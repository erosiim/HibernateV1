
import configuration.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Persona;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author exkapp
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona p = new Persona();
        p.setClave("15");
        p.setNombre("Alonso");
        p.setDireccion("Mi casita");
        Session session  = SessionManager.getSession();
        Transaction tx = session.beginTransaction();
        session.save(p);
        session.save(p);
        tx.commit();
        session.close();   
    }
    
}

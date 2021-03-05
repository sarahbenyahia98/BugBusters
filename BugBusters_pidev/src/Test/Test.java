/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entities.Gender;
import Entities.Reclamation;
import Entities.Type;
import Entities.User;
import Services.ServiceReclamation;
import Services.ServiceUser;
import Services.ServiceUser;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Sarah
 */
public class Test {
  /**
     * @param args the command line arguments
     */
static Statement ste;
static ResultSet result;
    public static void main(String[] args) {
        // TODO code application logic here
      ServiceUser ser = new ServiceUser();
        
        User p1 = new User();
        p1.setEmail("email");
        p1.setPassword("password");
        p1.setNom("nom");
        p1.setPrenom("prenom");
        p1.setNumero("27751856");
        p1.setAdresse("adresse");
        p1.setBirthDate(Date.valueOf("1998-04-28"));
        p1.setGender(Gender.Female);
        p1.setType(Type.Artist);
       p1.setEnable(true);
       User p2 = new User();
        p2.setEmail("email");
        p2.setPassword("password");
        p2.setNom("nom");
        p2.setPrenom("prenom");
        p2.setNumero("27751878");
        p2.setAdresse("adresse");
        p2.setBirthDate(Date.valueOf("1998-01-25"));
        p1.setGender(Gender.Male);
        p1.setType(Type.SimpleUser);
       p2.setEnable(true);
       
        //User Sarah= new User("sarah","ben yahia","sarahbenyahia@gmail.com","sarah12-*","1998-04-28",Gender.Female,"27751856",Type.artist,true);
        
        //x.insert(sarah);
        ser.insert(p1);
        ser.delete(p2);
        ser.update(p1);
        
        ServiceReclamation serR = new ServiceReclamation();
        Reclamation r1 = new Reclamation();
        r1.setdescription("description");
        r1.setetat("etat");
        r1.setType(Type.SimpleUser);
        
        serR.insert(r1);
        
        
    }
}

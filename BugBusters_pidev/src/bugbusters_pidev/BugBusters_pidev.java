/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugbusters_pidev;


import Entities.Gender;
import Entities.Type;
import Entities.User;
import Services.ServiceUser;
import java.sql.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Sarah
 */
public class BugBusters_pidev extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        ServiceUser ser = new ServiceUser();
        //User Sarah= new User("sarah","ben yahia","sarahbenyahia@gmail.com","sarah12-*","1998-04-28",Gender.Female,"27751856",Type.artist,true);
        
        //ser.insert(sarah);
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
       
        
        ser.insert(p1);
        ser.delete(p2);
        ser.update(p1);
        
    }
    
}

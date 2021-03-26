/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugbusters_pidev;

import Entities.Publicite;
import Service.ServicePublicite;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author seif
 */
public class FXMLToplikeController implements Initializable {

    @FXML
    private Label id;
    @FXML
    private Label username;
    @FXML
    private Label pubnom;
    @FXML
    private Label description;
    @FXML
    private Label date;
    @FXML
    private Label nblike;
    @FXML
    private Button bback;
    @FXML
    private Label nbdislike;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          ServicePublicite ser = new ServicePublicite();
          int max= ser.topl();
          System.out.print(max);
          Publicite p =new Publicite();
          p=ser.showpub(max);
          String s=String.valueOf(p.getId());
          username.setText("Username : "+p.getUsername());
          pubnom.setText("Pub Name : "+p.getPubnom());
          description.setText("Description : "+p.getDescription());
          date.setText("Date : "+p.getDate());
          String g= String.valueOf(ser.countlike(max));
          nblike.setText(g+" Likes");
           String f= String.valueOf(ser.countdislike(max));
          nbdislike.setText(f+" Dislikes");
          

    }    

    @FXML
    private void goback(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLchart.fxml"));
        
        Scene scene = new Scene(root);
        
         Stage appstage = (Stage)((Node) event.getSource()).getScene().getWindow() ;
        appstage.setScene(scene);
        appstage.show();
    }
    
}

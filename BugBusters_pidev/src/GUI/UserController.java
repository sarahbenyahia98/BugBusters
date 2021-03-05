/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.User;
import Services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Sarah
 */
public class UserController implements Initializable {
@FXML
    private AnchorPane bloquer;
    @FXML
    private Button retour;
    @FXML
    private Button vider;
    @FXML
    private TextField recherche;
    @FXML
    private TableView<User> table;
    @FXML
    private TableColumn<User, String> clNom;
    @FXML
    private TableColumn<User, String> clPrenom;
    @FXML
    private TableColumn<User, String> clEmail;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprenom;
    @FXML
    private Text nomm;
    @FXML
    private Text prenom;
    @FXML
    private TextField txtemail;
    @FXML
    private TextField txtroles;
    @FXML
    private Button btn;
    @FXML
    private Button supprimer;
    
    @FXML
    private Button bloc;
    
        ObservableList<User> dataEvent = FXCollections.observableArrayList();
        
        
        Stage dialogStage = new Stage();
    Scene scene;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         clNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        clPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        clEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        
        ServiceUser srv =new ServiceUser();
       
        dataEvent =FXCollections.observableArrayList(srv.GetAll());
        
        table.setItems(dataEvent);  
        setCellValue();
    }

public void setCellValue ()
  {
        
      table.setOnMouseClicked(new EventHandler<MouseEvent>(){
          @Override
          public void handle(MouseEvent event) {
              User e= table.getItems().get(table.getSelectionModel().getSelectedIndex());
              txtnom.setText(e.getNom());
              txtprenom.setText(e.getPrenom());
              txtemail.setText(e.getEmail());
              
              
          }
          
      });
  }

    @FXML
    private void directAccueil(ActionEvent event) throws IOException {
         Node node = (Node)event.getSource();
                    dialogStage = (Stage) node.getScene().getWindow();
                    dialogStage.close();
                    scene = new Scene(FXMLLoader.load(getClass().getResource("/proj/gestionUser/GUI/Home.fxml")));
                    dialogStage.setScene(scene);
                    System.out.println("Going to Home");
                    dialogStage.show(); 
    }

    @FXML
    private void vider(ActionEvent event) {
         txtnom.clear();
        txtprenom.clear();
        txtemail.clear();
        
    }

 

    @FXML
    private void validerModif(ActionEvent event) {
        
        
    }

    @FXML
    private void validersupp(ActionEvent event) {
    }

    @FXML
    private void validerBloc(ActionEvent event) {
    }
    
    
}

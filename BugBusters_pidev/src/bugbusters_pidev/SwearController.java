/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugbusters_pidev;


import Entities.swear;
import Services.ServiceSwear;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author seif
 */
public class SwearController implements Initializable {

    @FXML
    private TableView<swear> tview;
    @FXML
    private TextField sfield;
    @FXML
    private TableColumn<swear, String> colword;
    
    public ObservableList<swear> data = FXCollections.observableArrayList();
    @FXML
    private Button badd;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        colword.setText("swear");
     colword.setCellValueFactory(new PropertyValueFactory<>("word"));
      ServiceSwear ser = new ServiceSwear();
        data = ser.swearAction();
        

       tview.setItems(data);
       System.out.print(data);
    }    

    @FXML
    private void addswear(ActionEvent event) throws SQLException {
        
         ServiceSwear sc=new ServiceSwear();
            swear c=new swear();

           c.setWord(sfield.getText());
          
           

                sc.Addswear(c);
                data = sc.swearAction();
            tview.setItems(data);
           
    }
    
}

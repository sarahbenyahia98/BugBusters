/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import Service.ServicePublicite;
import Entities.Publicite;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author seif
 */
public class FXMLPubController implements Initializable {

    @FXML
    private TextField tfdescription;
    @FXML
    private Button addpub;
    @FXML
    private TableView<Publicite> table;
    @FXML
    private TableColumn<Publicite, Integer> colId;
    @FXML
    private TableColumn<Publicite, String> colnompub;
    @FXML
    private TableColumn<Publicite, String> coldescription;
    @FXML
    private TableColumn<Publicite, String> coldate;
    @FXML
    private TextField tfpubnom;
    @FXML
    private TableColumn<Publicite, Integer> userid;
    
    public ObservableList<Publicite> data = FXCollections.observableArrayList();
 @FXML
    private TableColumn<Publicite, Void> supp;
    @FXML
    private TableColumn<Publicite, Void> interaction;
    @FXML
    private Button interraction;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        colId.setCellValueFactory(new PropertyValueFactory<Publicite,Integer>("id"));
     colnompub.setCellValueFactory(new PropertyValueFactory<Publicite,String>("pubnom"));
    coldescription.setCellValueFactory(new PropertyValueFactory<Publicite,String>("description"));
     coldate.setCellValueFactory(new PropertyValueFactory<Publicite,String>("date"));
      userid.setCellValueFactory(new PropertyValueFactory<Publicite,Integer>("userid"));

     
       
       ServicePublicite ser = new ServicePublicite();
        
        data = ser.indexAction();
        table.setItems(data);
         suppButton();
         showInteraction();
        System.out.println(data);
        table.setEditable(true);
       colnompub.setCellFactory(TextFieldTableCell.forTableColumn());
       coldescription.setCellFactory(TextFieldTableCell.forTableColumn());

       
       
        
    }    

   
    @FXML
    private void AjouterPublicite(ActionEvent event) {
          if (tfdescription.getText() == null || tfdescription.getText().length() == 0) {
               Alert alert = new Alert(Alert.AlertType.WARNING);
    //  alert.initOwner(AjoutEquipmentController.getPrimaryStage());
        alert.setTitle("No Selection");
        alert.setHeaderText("description vide");
        alert.setContentText("le champs de commentaire est vide .");

        alert.showAndWait();
    
        }
        else
        {
      
        ServicePublicite sc=new ServicePublicite();
        Publicite c=new Publicite();
        System.out.println(java.time.LocalDate.now());  

       c.setDate(java.time.LocalDate.now().toString());
        c.setPubnom(tfpubnom.getText());

        c.setDescription(tfdescription.getText());
        try {
            sc.AddPub(c);
            data = sc.indexAction();
        table.setItems(data);
         
        } catch (SQLException ex) {
            Logger.getLogger(FXMLInteractionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }}
    
     @FXML
    private void editnom(TableColumn.CellEditEvent ec) {
        
        Publicite c=table.getSelectionModel().getSelectedItem();
        c.setPubnom(ec.getNewValue().toString());
        ServicePublicite ser = new ServicePublicite();
        ser.updateAction(c);
    }       
    
     @FXML
    private void editdescription(TableColumn.CellEditEvent ec) {
        
       Publicite c=table.getSelectionModel().getSelectedItem();
        c.setDescription(ec.getNewValue().toString());
        ServicePublicite ser = new ServicePublicite();
        ser.updateAction(c);
    }     

    
 
    
    private void showInteraction() {
         Callback<TableColumn<Publicite, Void>, TableCell<Publicite, Void>> 
        cellFactory = new Callback<TableColumn<Publicite, Void>, TableCell<Publicite, Void>>() {
            @Override
            public TableCell<Publicite, Void> call(final TableColumn<Publicite, Void> param) {
                final TableCell<Publicite, Void> cell = new TableCell<Publicite, Void>() {
                    private final Button btn = new Button("Interactions");

                    {
                          btn.setOnAction((ActionEvent event) -> {
                              Publicite selectedCat = getTableView().getItems().get(getIndex());
              System.out.println("********************************************");

                System.out.println(selectedCat.getId());
                 ServicePublicite ser = new ServicePublicite();
                ser.upadatepost(selectedCat.getId());
                              
                              
                            Parent root = null;
                              try {
                                  root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                              } catch (IOException ex) {
                                  Logger.getLogger(FXMLPubController.class.getName()).log(Level.SEVERE, null, ex);
                              }
        
        Scene scene = new Scene(root);
        Stage appstage = (Stage)((Node) event.getSource()).getScene().getWindow() ;
        appstage.setScene(scene);
        appstage.show();  
                              //*****************************
                              

                              
                             
                            
                        });
                    }                   
                                              
            @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        table.setItems(data);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
        interaction.setCellFactory(cellFactory);

        }  
    
                
     private void suppButton() {
        

        Callback<TableColumn<Publicite, Void>, TableCell<Publicite, Void>> 
        cellFactory = new Callback<TableColumn<Publicite, Void>, TableCell<Publicite, Void>>() {
            @Override
            public TableCell<Publicite, Void> call(final TableColumn<Publicite, Void> param) {
                final TableCell<Publicite, Void> cell = new TableCell<Publicite, Void>() {
                    private final Button btn = new Button("supp");

                    {
                          btn.setOnAction((ActionEvent event) -> {
                            Publicite selectedCat = getTableView().getItems().get(getIndex());
                            System.out.println("selectedDat\n" +
"                            ds.SupprimerDocument(data.getId());a: " + selectedCat);
                            ServicePublicite suppService = new ServicePublicite();
                            suppService.deleteAction(selectedCat.getId());
                            ServicePublicite ser = new ServicePublicite();
                            data = ser.indexAction();
                            table.setItems(data);
                            
                        });
                    }                   
                                              
            @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        table.setItems(data);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };
        supp.setCellFactory(cellFactory);

        }  


     

    
    }
/**
    @FXML
    private void editnom(TableColumn.CellEditEvent<S, T> event) {
    }

    @FXML
    private void editdescription(TableColumn.CellEditEvent<S, T> event) {
    }
    **/
    


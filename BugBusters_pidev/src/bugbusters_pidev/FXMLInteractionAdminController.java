/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugbusters_pidev;

import Entities.Comment;
import Entities.Like;
import Service.ServiceComment;
import Service.ServiceLike;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author seif
 */
public class FXMLInteractionAdminController implements Initializable {

    
    @FXML
    private TextField tfcomment;
    @FXML
    private Button post;
    private Label laffiche;
    
    @FXML
    private TableColumn<Comment, Integer> colId;
    @FXML
    private TableColumn<Comment, Integer> userid;
     public ObservableList<Comment> data = FXCollections.observableArrayList();
     @FXML
    private TableColumn<Comment, Void> supp;
    
    @FXML
    private TableView<Comment> table;
    @FXML
    private Button blike;
    @FXML
    private Button bdislike;
    @FXML
    private TableColumn<Comment, String> colusername;
    @FXML
    private TableColumn<Comment, String> colcomment;
    @FXML
    private Button bach;
    @FXML
    private Label llike;
    @FXML
    private Label ldislike;
    @FXML
    private Button gostat;
    @FXML
    private AnchorPane interctadmin;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        //label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      //  AfficheComment();
      int x = 0;
            int y = 0;

         colId.setCellValueFactory(new PropertyValueFactory<Comment,Integer>("id"));
        userid.setCellValueFactory(new PropertyValueFactory<Comment,Integer>("userid"));
     colcomment.setCellValueFactory(new PropertyValueFactory<Comment,String>("comment"));
    colusername.setCellValueFactory(new PropertyValueFactory<Comment,String>("username"));
      
     
       
       ServiceComment ser = new ServiceComment();
       ServiceLike serr = new ServiceLike();
       
        x=serr.countlike();
       String s=String.valueOf(x);

 llike.setText(s);
 
   
        y=serr.countdislike();
       String p=String.valueOf(y);

 ldislike.setText(p);
 
        data = ser.indexAction();
        table.setItems(data);
         suppButton();
        //System.out.println(data);
        table.setEditable(true);
        
        colcomment.setCellFactory(TextFieldTableCell.forTableColumn());
  
    }    
    private void suppButton() {
        

        Callback<TableColumn<Comment, Void>, TableCell<Comment, Void>> 
        cellFactory = new Callback<TableColumn<Comment, Void>, TableCell<Comment, Void>>() {
            @Override
            public TableCell<Comment, Void> call(final TableColumn<Comment, Void> param) {
                final TableCell<Comment, Void> cell = new TableCell<Comment, Void>() {
                    private final Button btn = new Button("supp");

                    {
                          btn.setOnAction((ActionEvent event) -> {
                            Comment selectedCat = getTableView().getItems().get(getIndex());
                          
                            ServiceComment suppService = new ServiceComment();

                            suppService.deleteAction(selectedCat.getId());
                            ServiceComment ser = new ServiceComment();
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
                       

    @FXML
    private void editcomment(TableColumn.CellEditEvent ec) {
        
        Comment c=table.getSelectionModel().getSelectedItem();
        c.setComment(ec.getNewValue().toString());
        ServiceComment ser = new ServiceComment();
         if(c.getId()==ser.getsessionid()){
        ser.updateAction(c);
    }       
         
                               
                            else{
                                Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setContentText("User can only modify his own publication ");
                                alert.showAndWait();
                                }
         
         }

       
           

       
        

    @FXML
    private void AjouterComment(ActionEvent event) {
       
        
        if (tfcomment.getText() == null || tfcomment.getText().length() == 0) {
               Alert alert = new Alert(Alert.AlertType.WARNING);
    //  alert.initOwner(AjoutEquipmentController.getPrimaryStage());
        alert.setTitle("No Selection");
        alert.setHeaderText("commentaire vide");
        alert.setContentText("le champs de commentaire est vide .");

        alert.showAndWait();
    
        }
        else
        {
      
        ServiceComment sc=new ServiceComment();
        Comment c=new Comment();
        
       c.setUserid(sc.getsessionid());
       c.setUsername(sc.getsessionname());
        c.setComment(tfcomment.getText());
        try {
            
            sc.AddComment(c);
            data = sc.indexAction();
        table.setItems(data);
        
       TrayNotification tray = new TrayNotification();
                tray.setTitle("New Comment");
                tray.setMessage(tfcomment.getText());
                tray.setNotificationType(NotificationType.SUCCESS);
                tray.showAndDismiss(Duration.seconds(5));
        
         
        } catch (SQLException ex) {
            Logger.getLogger(FXMLInteractionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }}

        @FXML
    private void AjouterLike(ActionEvent event) throws SQLException {

        ServiceLike sc=new ServiceLike();
        Like c=new Like();
        
        c.setEtat(1);
        
        c.setUserid(1);
        
         
       if(sc.search(c)==1)
           {
               sc.deleteAction(c.getUserid());
               sc.updatenbl(-1);
           }
       else{
            if(sc.search(c)==-1)
           {
               sc.deleteAction(c.getUserid());
           }
        try {
            sc.AddLike(c);
            sc.updatenbl(1);

        table.setItems(data);
         
        } catch (SQLException ex) {
            Logger.getLogger(FXMLInteractionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       ServiceLike serr = new ServiceLike();
       
       int x=serr.countlike();
       String s=String.valueOf(x);

 llike.setText(s);
 
 int y=serr.countdislike();
       String p=String.valueOf(y);

 ldislike.setText(p);
}
    
    
    @FXML
    private void AjouterDislike(ActionEvent event) throws SQLException {

        ServiceLike sc=new ServiceLike();
        Like c=new Like();
        
        c.setEtat(-1);
        c.setUserid(1);
        
         
       if(sc.search(c)==-1)
           {
               sc.deleteAction(c.getUserid());
           }
       else{
           if(sc.search(c)==1)
           {
               sc.deleteAction(c.getUserid());
                sc.updatenbl(-1);

           }
        try {
            sc.AddLike(c);
        table.setItems(data);
         
        } catch (SQLException ex) {
            Logger.getLogger(FXMLInteractionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        ServiceLike serr = new ServiceLike();
  int y=serr.countdislike();
       String p=String.valueOf(y);

 ldislike.setText(p);
  int x=serr.countlike();
       String s=String.valueOf(x);

 llike.setText(s);
}

    @FXML
    private void goback(ActionEvent event) throws IOException {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLPubAdmin.fxml"));
                                   interctadmin.getChildren().setAll(pane);  
        
    }

    @FXML
    private void gotostat(ActionEvent event) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("FXMLchart.fxml"));
        
        Scene scene = new Scene(root);
        
         Stage appstage = (Stage)((Node) event.getSource()).getScene().getWindow() ;
        appstage.setScene(scene);
        appstage.show();
    }
    
}
                        


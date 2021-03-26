/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugbusters_pidev;

import Entities.Publicite;
import Service.ServicePublicite;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.teknikindustries.bulksms.SMS;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author seif
 */
public class FXMLPubAdminController implements Initializable {

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
    private TableColumn<Publicite, String> colusername;

    @FXML
    private TextField tfpubnom;
    @FXML
    private TableColumn<Publicite, Integer> userid;
    
    public ObservableList<Publicite> data = FXCollections.observableArrayList();

    private TextField filterField;

    private ObservableList<Publicite> dataList = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Publicite, Void> supp;
    @FXML
    private TableColumn<Publicite, Void> interaction;
    @FXML
    private Button bsearch;
    @FXML
    private Button btriid;
    @FXML
    private Button btrinom;
    @FXML
    private Button btridate;
    @FXML
    private Button bpdf;
    @FXML
    private AnchorPane pubadmin;
   
    

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
    colusername.setCellValueFactory(new PropertyValueFactory<Publicite,String>("username"));
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
    private void AjouterPublicite(ActionEvent event) throws SQLException {
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
        c.setUserid(sc.getsessionid());
        c.setUsername(sc.getsessionname());



         Random rand = new Random(); 
     int rand_int1 = rand.nextInt(10000); 
      String str3 = String.valueOf(rand_int1); 
 
  
        // Print random integers 
        System.out.println("Random Integers: "+rand_int1);
        
        
        SMS sms=new SMS();
         String id ="1";
         
                String nt= "+216"+54630697;
            sms.SendSMS("seifoun123123","25718774aA", "pour valider votre demande saisir ce code "+rand_int1, nt ,"https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
   
       TextInputDialog dialog = new TextInputDialog("****");
dialog.setTitle("ajout reussi");
dialog.setHeaderText("publication ajouté, attante de confirmation");
dialog.setContentText("merci pour votre publicqtion Mr. seif en attend confirmation du code SMS\"");

Optional<String> result = dialog.showAndWait();
if (result.get().equals(str3)){
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
 
       alert.setTitle("ajout reussi");
       alert.setHeaderText(" code correct ");
       alert.setContentText("merci pour votre publication   Mr. seif" );
       alert.showAndWait();
       sc.AddPub(c);
        data = sc.indexAction();
        table.setItems(data);
}

else
{
 Alert alert = new Alert(Alert.AlertType.ERROR);
 
       alert.setTitle("ajout no reussi");
       alert.setHeaderText(" code incorrect ");
       alert.setContentText("merci de retapper le code  Mr. seif confirmation du code SMS" );
       alert.showAndWait();

}
        
    

    }
        // *********************
        
        
        
          }       
   
     
    
     @FXML
    private void editnom(TableColumn.CellEditEvent ec) {
        
                                
        Publicite c=table.getSelectionModel().getSelectedItem();
        c.setPubnom(ec.getNewValue().toString());
        ServicePublicite ser = new ServicePublicite();
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
                                    AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLInteractionAdmin.fxml"));
                                   pubadmin.getChildren().setAll(pane);                              } catch (IOException ex) {
                                  Logger.getLogger(FXMLPubController.class.getName()).log(Level.SEVERE, null, ex);
                              }
        
      
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
                final TableCell<Publicite, Void> cell;
                cell = new TableCell<Publicite, Void>() {
                    private final Button btn = new Button("supp");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Publicite selectedCat = getTableView().getItems().get(getIndex());
                           
                            ServicePublicite suppService = new ServicePublicite();
                               
                                suppService.deleteAction(selectedCat.getId());
                                ServicePublicite ser = new ServicePublicite();
                                data = ser.indexAction();
                                table.setItems(data);
                                
                               
                            
                        });
                    }
                    
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        String s;
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
    private void gotosearch(ActionEvent event) throws IOException {
   

 Parent root = FXMLLoader.load(getClass().getResource("FXMLSearch.fxml"));
        
        Scene scene = new Scene(root);
        
         Stage appstage = (Stage)((Node) event.getSource()).getScene().getWindow() ;
        appstage.setScene(scene);
        appstage.show();
     
 }

    @FXML
    private void triid(ActionEvent event) {
        
        ServicePublicite ser = new ServicePublicite();
         data = ser.indexAction();

       table.setItems(data);
       
    }

    @FXML
    private void trinom(ActionEvent event) {
        
        ServicePublicite ser = new ServicePublicite();
         data = ser.indexActionTri();

       table.setItems(data);
       
    }

    @FXML
    private void tridate(ActionEvent event) {
         ServicePublicite ser = new ServicePublicite();
         data = ser.indexActionTridate();

       table.setItems(data);
    }

    @FXML
    private void est(ActionEvent event) throws IOException, DocumentException {
       
       String path="Users\\seif\\NetBeansProjects\\Crud\\equipment.pdf";
     
         Document doc  =new Document(); 
     
       
         PdfWriter.getInstance(doc, new FileOutputStream(path));
         ServicePublicite e =new ServicePublicite();
         doc.open();
         PdfPTable table1=new PdfPTable(5);
       table1.setWidthPercentage(100);
       table1.getDefaultCell().setBorder(4);
       table1.addCell("nom");
       table1.addCell("date");
       table1.addCell("description");
       table1.addCell("userid");
       
        com.itextpdf.text.Paragraph p = new com.itextpdf.text.Paragraph();
            p.add("publicite List ");
                p.add("      ");
                p.add("      ");
            p.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            doc.add(p);
         System.out.println("test1");

          for (int i = 0; i < table.getItems().size(); i++)       
     { 
     String r=table.getItems().get(i).getPubnom() ;
         int a =e.indexAction().get(i).getId();
         String s=String.valueOf(a);
         table1.addCell(e.indexAction().get(i).getDescription());
     table1.addCell(s);
      table1.addCell(e.indexAction().get(i).getDate());
    
              doc.add(table1);
          System.out.println("test2");

          
       
        
            System.out.println("finish");
     
    }

   doc.close();
            Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Génération du PDF");
        a.setHeaderText("Liste des produits exportée");
        a.setContentText("Chemin du fichier : "+path);
        a.showAndWait();
                   TextArea textArea = new TextArea();
        textArea.setMinHeight(70);
        final FileChooser fileChooser = new FileChooser();
           textArea.clear();
        Window stage = null;
           
                File file = fileChooser.showOpenDialog(stage);
                 System.out.println(file);
                if (file != null) {
                    
                    openFile(file);
                    List<File> files = Arrays.asList(file);
                    printLog(textArea, files);
               
                
                 fileChooser.setTitle("Select Some Files");
 
           fileChooser.setInitialDirectory(new File(System.getProperty("user")));
            

       
            }



 
    
}

    private void openFile(File file) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void printLog(TextArea textArea, List<File> files) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

    




   
    
      
   



   
   

   


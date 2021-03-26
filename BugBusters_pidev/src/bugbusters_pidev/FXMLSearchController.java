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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author seif
 */
public class FXMLSearchController implements Initializable {

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
    private TableColumn<Publicite, Integer> coluserid;
    @FXML
    private TextField filterField;
        public ObservableList<Publicite> dataList = FXCollections.observableArrayList();
    @FXML
    private Button back;
    

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
     coluserid.setCellValueFactory(new PropertyValueFactory<Publicite,Integer>("userid"));

     
       
       ServicePublicite ser = new ServicePublicite();
         dataList = ser.indexAction();

       table.setItems(dataList);
       
               dataList = ser.indexAction();
               
               
               
                 FilteredList<Publicite> filteredData = new FilteredList<>(dataList, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(publicite -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (publicite.getPubnom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (publicite.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				else if (String.valueOf(publicite.getId()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Publicite> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(table.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		table.setItems(sortedData);
               
       
    }    

    @FXML
    private void goback(ActionEvent event) throws IOException {
        ServicePublicite ser = new ServicePublicite();
        int r = ser.getsessionrole();
        if(r==1){
         Parent root = FXMLLoader.load(getClass().getResource("FXMLPubAdmin.fxml"));
        
        Scene scene = new Scene(root);
        
         Stage appstage = (Stage)((Node) event.getSource()).getScene().getWindow() ;
        appstage.setScene(scene);
        appstage.show();
    
       }
        else{
         Parent root = FXMLLoader.load(getClass().getResource("FXMLPub.fxml"));
        
        Scene scene = new Scene(root);
        
         Stage appstage = (Stage)((Node) event.getSource()).getScene().getWindow() ;
        appstage.setScene(scene);
        appstage.show();
            }
        }

  
    
}

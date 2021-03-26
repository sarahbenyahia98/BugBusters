/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugbusters_pidev;

import Service.ServiceComment;
import Service.ServiceLike;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author seif
 */
public class FXMLchartController implements Initializable {

    @FXML
    private Pane paneview;
    @FXML
    private Button bach;
    @FXML
    private Label lcount;
    @FXML
    private Button btlike;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();    
        int x=0;
        ServiceComment ser = new ServiceComment();
       
        x=ser.countcomment();
       String s=String.valueOf(x);

 lcount.setText("This post has "+ s +" Comments");
 
    }    
    private void loadData() {
                ObservableList <PieChart.Data> list = FXCollections.observableArrayList();
                paneview.getChildren().clear();
                int x,y;
                       ServiceLike ser = new ServiceLike();
                        x=ser.countlike();
                        y=ser.countdislike();

                
                list.add(new PieChart.Data("Likes", x));
                 
               list.add( new PieChart.Data("Dislies", y));
               
               
               PieChart milkchart=new PieChart(list);
               milkchart.setTitle("Interactions");
               paneview.getChildren().add(milkchart);

    }

    @FXML
    private void goback(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("FXMLInteractionAdmin.fxml"));
        
        Scene scene = new Scene(root);
        
         Stage appstage = (Stage)((Node) event.getSource()).getScene().getWindow() ;
        appstage.setScene(scene);
        appstage.show();
    }

    @FXML
    private void toplike(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("FXMLToplike.fxml"));
        
        Scene scene = new Scene(root);
        
         Stage appstage = (Stage)((Node) event.getSource()).getScene().getWindow() ;
        appstage.setScene(scene);
        appstage.show();
    }
    
}

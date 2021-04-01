/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bugbusters_pidev;

import GUI.*;
import Entities.Publicite;
import Service.ServicePublicite;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author seif
 */
public class FXMLToplikeController implements Initializable {

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
    @FXML
    private Button bqr;

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

    @FXML
    private void goqr(ActionEvent event) throws IOException, WriterException {
         
        
        
         Stage primaryStage = new Stage();
        
         ServicePublicite ser = new ServicePublicite();
          int max= ser.topl();
        
         Publicite p =new Publicite();
          p=ser.showpub(max);
                  String g= String.valueOf(ser.countlike(max));
                              String f= String.valueOf(ser.countdislike(max));

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String myWeb = "Username : "+p.getUsername()+ System.lineSeparator()
              +"Pub Name : "+p.getPubnom() +System.lineSeparator()
               +"Description : "+p.getDescription()+System.lineSeparator()
                +"Date : "+p.getDate()+System.lineSeparator()
                +g+" Likes    "
                +f+" Dislikes"
                
                ;
        int width = 300;
        int height = 300;
        String fileType = "png";
        
        BufferedImage bufferedImage = null;
        
            BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();
            
            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);
            
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            
            System.out.println("Success...");
            
        
        
        ImageView qrView = new ImageView();
        qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
        
        StackPane root = new StackPane();
        root.getChildren().add(qrView);
        
        Scene scene = new Scene(root, 350, 350);
        
        primaryStage.setTitle("QR Code");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        
        
        
        
    }
    


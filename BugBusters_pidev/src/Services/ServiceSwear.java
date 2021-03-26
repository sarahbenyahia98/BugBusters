/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.swear;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Utils.DataBaseConnection;

/**
 *
 * @author seif
 */
public class ServiceSwear {
     Connection cnx;
    public ServiceSwear(){
        cnx=DataBaseConnection.getInstance().getConnection();
}
    
    public ObservableList<swear> swearAction()
             
     {  
         
        ObservableList<swear> mylist=FXCollections.observableArrayList();
        String req= " select word from swear";
        Statement st;
        try {
            st=cnx.createStatement();
            ResultSet res=st.executeQuery(req);
           while (res.next()){
            swear c =new swear();
            c.setWord(res.getString("word"));
                        mylist.add(c);

            
        }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          return mylist;
     }
 public void Addswear(swear s) throws SQLException {
     
        
        Statement stm=cnx.createStatement();
        String req="insert into swear (word) values ('"+s.getWord()+"')";
        Statement st;
        try {
            st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    
    }

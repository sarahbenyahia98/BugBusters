/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Publicite;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.connexion;

/**
 *
 * @author seif
 */
public class ServicePublicite {
    Connection cnx;
    public ServicePublicite(){
        cnx=connexion.getInstance().getConnection();
    
}   
    
     public void AddPub(Publicite p) throws SQLException {
       
        
      
        
        int q=1;
        String b="seif";
        Statement stm=cnx.createStatement();
        String req="insert into publicite (pubnom,description,date,userid) values ('"+p.getPubnom()+
                "','"+p.getDescription()+
                "','"+p.getDate()+
                "','"+q+

                "')";
        Statement st;
        try {
            st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
        
     public ObservableList<Publicite> indexAction()
             
     {  
        ObservableList<Publicite> mylist=FXCollections.observableArrayList();
        String req= " select * from publicite ";
        Statement st;
        try {
            st=cnx.createStatement();
            ResultSet res=st.executeQuery(req);
           while (res.next()){
            Publicite c =new Publicite();
            c.setId(res.getInt("id_pub"));
            c.setPubnom(res.getString("pubnom"));
            c.setDescription(res.getString("description"));
            c.setUserid(res.getInt("userid"));
            c.setDate(res.getString("date"));

                    
         
            mylist.add(c);
        }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print(mylist);
          return mylist;
     }
       public void deleteAction(int id) {
      //
      String req="delete from publicite where Id_pub= '"+id+"'";
        Statement st;
         try {
            st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
      //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
         public void updateAction(Publicite c){
       
         String req= " UPDATE publicite SET userid='"+c.getUserid()+"',description='"+c.getDescription()+"',pubnom='"
               +c.getPubnom()+"' where id_pub= '"+c.getId()+"' " ;
        Statement st;
        try {
             st = cnx.createStatement();
             st.executeUpdate(req);
                    }   
        catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         
          public void upadatepost(int id){
              String req= " UPDATE post SET num='"+id+"' " ;
               Statement st;
        try {
             st = cnx.createStatement();
             st.executeUpdate(req);
                    }   
        catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
              
          }


}

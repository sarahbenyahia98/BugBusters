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
import Utils.DataBaseConnection;

/**
 *
 * @author seif
 */
public class ServicePublicite {
    Connection cnx;
    public ServicePublicite(){
        cnx=DataBaseConnection.getInstance().getConnection();
    
}   
    
     public void AddPub(Publicite p) throws SQLException {
     
        
        Statement stm=cnx.createStatement();
        String req="insert into publicite (pubnom,description,date,userid,username) values ('"+p.getPubnom()+
                "','"+p.getDescription()+
                "','"+p.getDate()+
                "','"+p.getUserid()+
                "','"+p.getUsername()+

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
        String req= " select * from publicite ORDER BY id_pub";
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
            c.setUsername(res.getString("username"));


                    
         
            mylist.add(c);
        }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print(mylist);
          return mylist;
     }
      public ObservableList<Publicite> indexActionTri()
             
     {  
        ObservableList<Publicite> mylist=FXCollections.observableArrayList();
        String req= " select * from publicite ORDER BY userid";
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
            c.setUsername(res.getString("username"));


                    
         
            mylist.add(c);
        }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print(mylist);
          return mylist;
     }
        public ObservableList<Publicite> indexActionTridate()
             
     {  
        ObservableList<Publicite> mylist=FXCollections.observableArrayList();
        String req= " select * from publicite ORDER BY date";
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
            c.setUsername(res.getString("username"));

                    
         
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
            //delte comments and likes
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
         
          String req2="delete from comment where postid= '"+id+"'";
       
         try {
            st = cnx.createStatement();
            st.executeUpdate(req2);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         String req3="delete from likes where postid= '"+id+"'";
         try {
            st = cnx.createStatement();
            st.executeUpdate(req3);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
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
          
           public int getsessionid()
             
     {  
        String req= " select id from session";
        Statement st;
        int id = 0;
        try {
            st=cnx.createStatement();
            ResultSet res=st.executeQuery(req);
           while (res.next()){
              
           id = res.getInt("id");

        }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
          return id;
     }
            public String getsessionname()
             
     {  
        String req= " select nom from session";
        Statement st;
        String name = null;
        try {
            st=cnx.createStatement();
            ResultSet res=st.executeQuery(req);
           while (res.next()){
              
           name = res.getString("nom");

        }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
          return name;
     }

 public int getsessionrole()
             
     {  
        String req= " select role from session";
        Statement st;
        int role = 0;
        try {
            st=cnx.createStatement();
            ResultSet res=st.executeQuery(req);
           while (res.next()){
              
           role = res.getInt("role");

        }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
          return role;
     }
 public int topl()
             
     {  
        String req= " SELECT id_pub, MAX(nbl) FROM publicite;";
        Statement st;
        int id = 0;
        try {
            st=cnx.createStatement();
            ResultSet res=st.executeQuery(req);
           while (res.next()){
              
           id = res.getInt("id_pub");

        }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
          return id;
     }
 public Publicite showpub(int id){
     String req= " select * from publicite where id_pub = '"+id+"' ";
        Statement st;
        Publicite p =new Publicite();

        try {
            st=cnx.createStatement();
            ResultSet res=st.executeQuery(req);
           while (res.next()){
            p.setId(res.getInt("id_pub"));
            p.setPubnom(res.getString("pubnom"));
            p.setDescription(res.getString("description"));
            p.setUserid(res.getInt("userid"));
            p.setDate(res.getString("date"));
            p.setUsername(res.getString("username"));

        }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.print(p);
          return p;
     }
 
 
 public int countlike(int y){
         
         int t=1;
 String req= " SELECT COUNT(id) AS countl FROM Likes where postid = '"+y+"' and etat= '"+t+"'";
        Statement st;
        int x = 0;
        try {
            st=cnx.createStatement();
            ResultSet res=st.executeQuery(req);
           while (res.next()){
            x=(res.getInt("countl"));
            

                    }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
         
        return x;     }
     
     
      public int countdislike(int y){
         
         int t=-1;
 String req= " SELECT COUNT(id) AS countl FROM Likes where postid = '"+y+"' and etat= '"+t+"'";
        Statement st;
        int x = 0;
        try {
            st=cnx.createStatement();
            ResultSet res=st.executeQuery(req);
           while (res.next()){
            x=(res.getInt("countl"));
            

                    }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
         
        return x;     }
     
    

}

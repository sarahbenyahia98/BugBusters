/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Comment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Utils.DataBaseConnection;
/**
 *
 * @author seif
 */
public class ServiceComment {

    Connection cnx;
    public ServiceComment(){
        cnx=DataBaseConnection.getInstance().getConnection();
        
    }
         
    public int shownum(){
           String req= " select * from post ";
        Statement st;
        int x = 0;
        try {
            st=cnx.createStatement();
            ResultSet res=st.executeQuery(req);
           while (res.next()){
            x=(res.getInt("num"));
            

                    }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
         
        return x;
    }
    
   
    
    public void AddComment(Comment c) throws SQLException {
       
        
      int x=0;
        x=shownum(); 
        
        
        Statement stm=cnx.createStatement();
        String req="insert into comment (comment,userid,username,postid) values ('"+c.getComment()+
                "','"+c.getUserid()+
                "','"+c.getUsername()+
                "','"+x+

                "')"; 
        Statement st;
        try {
            st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
   
      
     public ObservableList<Comment> indexAction()
             
     {  int x=0;
        x=shownum(); 
         
        ObservableList<Comment> mylist=FXCollections.observableArrayList();
        String req= " select * from comment where postid = '"+x+"' ";
        Statement st;
        try {
            st=cnx.createStatement();
            ResultSet res=st.executeQuery(req);
           while (res.next()){
            Comment c =new Comment();
            c.setId(res.getInt("id"));
            c.setUserid(res.getInt("userid"));
            c.setComment(res.getString("comment"));
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
      String req="delete from comment where Id= '"+id+"'";
        Statement st;
         try {
            st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void updateAction(Comment c){
       
         String req= " UPDATE comment SET userid='"+c.getUserid()+"',username='"+c.getUsername()+"',comment='"
               +c.getComment()+"' where id= '"+c.getId()+"' " ;
        Statement st;
        try {
             st = cnx.createStatement();
             st.executeUpdate(req);
                    }   
        catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
      public int countcomment(){
         int y;
         y= shownum();
         int t=1;
 String req= " SELECT COUNT(id) AS countl FROM comment where postid = '"+y+"' ";
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

 public ObservableList<String> swearAction()
             
     {  
         
        ObservableList<String> mylist=FXCollections.observableArrayList();
        String req= " select word from swear";
        Statement st;
        try {
            st=cnx.createStatement();
            ResultSet res=st.executeQuery(req);
           while (res.next()){

            mylist.add(res.getString("word"));
        }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          return mylist;
     }

}

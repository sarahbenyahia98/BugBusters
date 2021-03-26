/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Like;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.DataBaseConnection;

/**
 *
 * @author seif
 */
public class ServiceLike {
      Connection cnx;
    public ServiceLike(){
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
     
     public int countlike(){
         int y;
         y= shownum();
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
     
     
      public int countdislike(){
         int y;
         y= shownum();
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
     
     
    public void AddLike(Like c) throws SQLException {
       
        int x=0;
        x=shownum(); 
      
        
        int q=1;
        int b=2;
        Statement stm=cnx.createStatement();
        String req="insert into likes (etat,userid,postid) values ('"+c.getEtat()+
                "','"+c.getUserid()+
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
     public void deleteAction(int userid) {
      //
      String req="delete from likes where userid= '"+userid+"'";
        Statement st;
         try {
            st = cnx.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceComment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
          public int search(Like l) throws SQLException{
               String req= " select * from likes where userid = 1 ";
        Statement st;
        int x=0;
            st=cnx.createStatement();
            ResultSet res=st.executeQuery(req);
           while (res.next()){
                          x=(res.getInt("etat"));

               return x;
           }
       
                              return 0;

                
        
        
          }
          
          
          public void updatenbl(int s){
       int x=0;
        x=shownum(); 
         String req= " UPDATE publicite SET nbl=nbl+'"+s+"'where id_pub ='"+x+"'" ;
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Gender;
import Entities.Type;
import Entities.User;
import IServices.IServiceUser;
import Utils.DataBaseConnection;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sarah
 */
public  class ServiceUser implements IServiceUser<User>  {
     private Connection connection;
    private PreparedStatement stat;
    private ResultSet rs;
    int i=0;

    public ServiceUser() {
        connection=DataBaseConnection.getInstance().getConnection();
    }
 
    
    

    
    public void insert(User u){
        try {
         String requete ="INSERT INTO User(email,password,nom,prenom,numero,adresse,BirthDate,sexe,type,enable) VALUES (?,?,?,?,?,?,?,?,?,?)";
         stat=connection.prepareStatement(requete);
         stat.setString(1,u.getEmail());
         stat.setString(2,u.getPassword());
         stat.setString(4,u.getNom());
         stat.setString(5, u.getPrenom());
         stat.setString(6, u.getNumero());
         stat.setString(7, u.getAdresse());
        stat.setDate(8, u.getBirthDate());
        stat.setString(9, u.getGender().name());
        stat.setString(10, u.getType().name());
         stat.setBoolean(11, u.isEnable());
         stat.execute();
         System.out.println("User added");
        } catch (SQLException ex) {
           System.out.println(ex);
        }
    }
        
        public void update(User u){
        try {
            stat=connection.prepareStatement("UPDATE user SET nom=?,prenom=?,numero=?,adresse=? WHERE userid=? ");
            stat.setString(1, u.getNom());
            stat.setString(2,u.getPrenom());
            stat.setString(3,u.getNumero());
            stat.setString(4, u.getAdresse());
            stat.setInt(5, u.getUserId());
            stat.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        public void updateU(User u, int id) {
        try {
            String requete = "UPDATE User SET nom=? WHERE id=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            stat.setString(1, u.getNom());
            stat.setInt(2, u.getUserId());
            pst.executeUpdate();
            System.out.println("modifié");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        
    /**
     *
     * @param u
     * @return
     */
    @Override
      public boolean delete(User u){
       boolean etat = false;
        try {
            String Req2 = "select id from User where nom='"+u.getNom()+"'and prenom= '"+u.getPrenom()+"'";
            Statement Ps2 = connection.createStatement();
            ResultSet Rs =  Ps2.executeQuery(Req2);
            String requete = "DELETE FROM User WHERE id=?";
            PreparedStatement pst = connection.prepareStatement(requete);
             while(Rs.next()){  
            pst.setInt(1,Rs.getInt(1));
            i= pst.executeUpdate();
             }
           if(i>0){
            System.out.println("user deleted ");
            etat=true;
           }else{System.out.println("Not deleted");}
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
        return etat;
     }
     @Override
       public ArrayList<User> GetAll(){
        ArrayList<User> list = new ArrayList<>();
        try {
           stat = connection.prepareStatement("SELECT * FROM User");
            rs= stat.executeQuery();
           
            while(rs.next()){
               User u = new User();
                u.setUserId(rs.getInt("userId"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setNom(rs.getString("nom"));
                u.setPrenom(rs.getString("prenom"));
                u.setNumero(rs.getString("numero"));
                 u.setAdresse(rs.getString("adresse"));
                 u.setBirthDate(rs.getDate("BirthDate"));
                 u.setEnable(rs.getBoolean("enable"));
                
                list.add(u);
            }
            rs.close();
            stat.close();
            
        } catch (Exception e) {
        }
        
        return list;
    }


}

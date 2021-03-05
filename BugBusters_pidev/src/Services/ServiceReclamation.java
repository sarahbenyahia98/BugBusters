/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Reclamation;
import Utils.DataBaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sarah
 */
public class ServiceReclamation {
     private Connection connection;
    private PreparedStatement stat;
    private ResultSet rs;
    int i=0;

    public ServiceReclamation() {
        connection=DataBaseConnection.getInstance().getConnection();
    }
    
      public void insert(Reclamation r) {
   
        try{
            String req="INSERT INTO reclamation(description,etat,Type) VALUES "
                    +"('" + r.getdescription() + "', '" + r.getetat() +"', '" +r.getType()+   "')";
       
             stat = (PreparedStatement) connection.createStatement();

            stat.executeUpdate(req);

            System.out.println("Insertion Reussie!");

        } catch (SQLException ex) {
            System.out.println(ex);
        }

      }
}

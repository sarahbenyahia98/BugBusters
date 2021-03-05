/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import Entities.Type;
import static jdk.nashorn.internal.objects.NativeJava.type;
import static org.eclipse.persistence.internal.sessions.coordination.corba.sun.CommandDataHelper.type;
import static org.eclipse.persistence.internal.sessions.coordination.corba.sun.SunCORBAConnectionHelper.type;
import static org.eclipse.persistence.sessions.remote.corba.sun.CORBARemoteSessionControllerHelper.type;
/**
 *
 * @author Sarah
 */
public class Reclamation {
     private int Id ;  
    private String description ; 
    private String etat ;
    private Type Type ; 
    
    public Reclamation(int Id,String description,String etat,Type type){
        this.Id=Id;
        this.description=description;
        this.etat=etat;
        this.Type=type;  
    }
    public Reclamation(){    
    }
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

   public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }
    public String getetat() {
        return etat;
    }

    public void setetat(String etat) {
        this.etat = etat;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type = Type;
    }
    
 @Override
    public String toString() {
        return "reclamation{" + "Id=" + Id + ",description=" + description+ ",etat=" +etat+ ",Type="+Type+'}';
         
    }
     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reclamation other = (Reclamation) obj;
        if (this.Id != other.Id) {
            return false;
        }
        return true;
    }
  
}

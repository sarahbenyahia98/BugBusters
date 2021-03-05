/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;


/**
 *
 * @author Sarah
 */
public class User {
    private int userId ; 
    private String nom ; 
    private String prenom ; 
    private String email ; 
    private String password ; 
    private Date birthDate ;
     private String adresse;
    private Gender Gender ; 
    private String numero ;
    private Type Type ; 
    private boolean enable;


    public User(int userId, String nom, String prenom, String email, String password, Date birthDate, Gender Gender, String numero, String adresse, Type Type, boolean enable) {
        this.userId = userId;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.Gender = Gender;
        this.numero = numero;
        this.adresse=adresse;
        this.Type = Type;
        this.enable = enable;

    }
     public User() {} 
   
 public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return Gender;
    }

    public void setGender(Gender Gender) {
        this.Gender = Gender;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
   
    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type = Type;
    }
    
    public boolean isEnable() {
        return enable;
    }
       public void setEnable(boolean enable) {
        this.enable = enable;
    }



    @Override
    public String toString() {
        return "User{"+ "userId=" + userId + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password + ", birthDate=" + birthDate + ", Gender=" + Gender + ", numero=" + numero +",adresse"+ adresse+", Type=" + Type  + ", enable=" + enable +'}';
    }

   
 @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.userId;
        return hash;
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
        final User other = (User) obj;
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

   
  
    



}

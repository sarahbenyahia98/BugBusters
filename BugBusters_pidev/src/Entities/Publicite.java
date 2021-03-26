/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author seif
 */
public class Publicite {
    private int id;
    private String pubnom;
    private int userid;
    private String date;
    private String description;
    private String username;


    @Override
    public String toString() {
        return "Publicite{" + "id=" + id + ", pubnom=" + pubnom + ", userid=" + userid + ", date=" + date + ", description=" + description + ", username=" + username + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPubnom() {
        return pubnom;
    }

    public void setPubnom(String pubnom) {
        this.pubnom = pubnom;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Publicite(int id, String pubnom, int userid, String date, String description, String username) {
        this.id = id;
        this.pubnom = pubnom;
        this.userid = userid;
        this.date = date;
        this.description = description;
        this.username = username;
    }

    public Publicite() {
    }


}
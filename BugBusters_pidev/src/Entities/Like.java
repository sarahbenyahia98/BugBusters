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
public class Like {
    private int id;
    private int userid;
    private int postid;
    private int etat;

    public Like() {
    }

    public Like(int id, int userid, int postid, int etat) {
        this.id = id;
        this.userid = userid;
        this.postid = postid;
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Like{" + "id=" + id + ", userid=" + userid + ", postid=" + postid + ", etat=" + etat + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
    
}

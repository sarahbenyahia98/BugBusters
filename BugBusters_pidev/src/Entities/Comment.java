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
public class Comment {
    private int id;
    private int userid;
    private int postid;
    private String comment;
    private String username;

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", userid=" + userid + ", postid=" + postid + ", comment=" + comment + ", username=" + username + '}';
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Comment(int id, int userid, int postid, String comment, String username) {
        this.id = id;
        this.userid = userid;
        this.postid = postid;
        this.comment = comment;
        this.username = username;
    }
    



    public Comment() {
    }

    
    
    
    
}

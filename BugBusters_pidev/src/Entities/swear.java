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
public class swear {
    private String word;

    @Override
    public String toString() {
        return "swear{" + "word=" + word + '}';
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public swear(String word) {
        this.word = word;
    }

    public swear() {
    }
    
}

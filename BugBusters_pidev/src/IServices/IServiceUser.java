/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import java.util.ArrayList;

/**
 *
 * @author Sarah
 * @param <User>
 */
public interface IServiceUser <U>{
      void insert(U u );
    boolean delete(U u) ; 
    void updateU(U u ,int a ) ; 
    void update(U u );
    
    ArrayList<U> GetAll() ;
}

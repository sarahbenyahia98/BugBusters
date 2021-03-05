/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import java.sql.SQLException;

/**
 *
 * @author Sarah
 */
public interface IserviceReclamation<R> {
    void insert(R r )throws SQLException;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2830482411004
 */
import java.util.List;

public interface GenericDAO<T> {
    void save(T entity);
    List<T> findAll();
    T findById(int id);
    void update(T entity);
    void delete(int id);
}
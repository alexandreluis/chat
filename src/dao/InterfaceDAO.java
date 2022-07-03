package dao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 180900411
 */
public interface InterfaceDAO<T> 
{
    public boolean add(T pVO) throws SQLException;
    public T getById(String idCliente) throws SQLException;
    public T getByDoc(String doc) throws SQLException;
    public ArrayList<T> getAll() throws SQLException;
    public boolean atualizar(T pVO) throws SQLException;
    public boolean deletar(T pVO) throws SQLException;
    public boolean deletarTodos() throws SQLException;
}
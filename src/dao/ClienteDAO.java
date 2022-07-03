package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import conexao.Conexao;
import model.Cliente;

/**
 *
 * @author 180900411
 */
public class ClienteDAO implements InterfaceDAO<Cliente>
{
    @Override
    public boolean add(Cliente pVO) throws SQLException
    {
        Connection conn = Conexao.getConexao();
        Statement statement = conn.createStatement();
        
        boolean executou = false;

        try
        {
            String sql;
            sql = "INSERT INTO cliente VALUES (null, '"
                    + pVO.getNome() + "', '"
                    + pVO.getEmail() + "', '"
                    + pVO.isTipoDeCliente() + ", "
                    + pVO.isSituacaoFinanceira() + ");";

            executou = statement.execute(sql);
            //falta: listaDeAmigos, listaDeGruposCriados
        } catch (SQLException e)
        {
            throw new SQLException("Erro ao inserir cliente.\n" + e.getMessage());
        } finally
        {
            statement.close();
            conn.close();
        }
        
        return executou;
    }

    @Override
    public Cliente getById(String idCliente) throws SQLException
    {
        Connection conn = Conexao.getConexao();
        Statement statement = conn.createStatement();

        Cliente c = new Cliente();

        try
        {
            String sql;
            sql = "SELECT * FROM cliente WHERE idCliente = " + idCliente;

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next())
            {
                c.setNome(rs.getString("nomeCliente"));
                c.setEmail(rs.getString("emailCliente"));
                c.setTipoDeCliente(rs.getBoolean("tipoDeCliente"));
                c.setSituacaoFinanceira(rs.getBoolean("situacaoDoCliente"));
            }
        } catch (SQLException e)
        {
            throw new SQLException("Este cliente não está cadastrado.\n" + e.getMessage());
        } finally
        {
            statement.close();
            conn.close();
        }

        return c;
    }

    @Override
    public Cliente getByDoc(String doc) throws SQLException
    {
        Connection conn = Conexao.getConexao();
        Statement statement = conn.createStatement();

        Cliente c = new Cliente();

        try
        {
            String sql;
            sql = "SELECT * FROM cliente WHERE cpf = " + doc;

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next())
            {
                c.setNome(rs.getString("nomeCliente"));
                c.setEmail(rs.getString("emailCliente"));
                c.setTipoDeCliente(rs.getBoolean("tipoDeCliente"));
                c.setSituacaoFinanceira(rs.getBoolean("situacaoDoCliente"));
            }
        } catch (SQLException e)
        {
            throw new SQLException("Este cliente não está cadastrado.\n" + e.getMessage());
        } finally
        {
            statement.close();
            conn.close();
        }

        return c;
    }

    @Override
    public ArrayList<Cliente> getAll() throws SQLException
    {
        Connection conn = Conexao.getConexao();
        Statement statement = conn.createStatement();

        try
        {
            String sql;
            sql = "SELECT * FROM cliente";

            ResultSet rs = statement.executeQuery(sql);

            ArrayList<Cliente> listaDeClientes = new ArrayList<>();

            while (rs.next())
            {
                Cliente c = new Cliente();

                c.setNome(rs.getString("nomeCliente"));
                c.setEmail(rs.getString("emailCliente"));
                c.setTipoDeCliente(rs.getBoolean("tipoDeCliente"));
                c.setSituacaoFinanceira(rs.getBoolean("situacaoDoCliente"));

                listaDeClientes.add(c);
            }

            return listaDeClientes;
        } catch (SQLException e)
        {
            throw new SQLException("Erro ao buscar todos clientes.\n" + e.getMessage());
        } finally
        {
            statement.close();
            conn.close();
        }
    }

    @Override
    public boolean atualizar(Cliente pVO) throws SQLException
    {
        Connection conn = Conexao.getConexao();
        Statement statement = conn.createStatement();
        
        boolean executou = false;
        
        try
        {
            String sql;
            sql = "UPDATE cliente SET "
                    + "nomeCliente = '" + pVO.getNome() + "', "
                    + "emailCliente = '" + pVO.getEmail() + "', "
                    + "tipoDeCliente = " + pVO.isTipoDeCliente() + ", "
                    + "situacaoDoCliente = " + pVO.isSituacaoFinanceira() + " "
                    + "WHERE idCliente = '" + pVO.getIdCliente();

            if(statement.executeUpdate(sql) > 1)
            {
                executou = true;
            }
        } catch (SQLException e)
        {
            throw new SQLException("Erro ao atualizar o cliente.\n" + e.getMessage());
        } finally
        {
            statement.close();
            conn.close();
        }
        
        return executou;
    }

    @Override
    public boolean deletar(Cliente pVO) throws SQLException
    {
        Connection conn = Conexao.getConexao();
        Statement statement = conn.createStatement();

        boolean executou = false;
        
        try
        {
            String sql;
            sql = "DELETE FROM cliente WHERE idCliente =" + pVO.getIdCliente();
            
            executou = statement.execute(sql);
        } catch (SQLException e)
        {
            throw new SQLException("Erro ao deletar cliente.\n" + e.getMessage());
        } finally
        {
            statement.close();
            conn.close();
        }
        
        return executou;
    }

    @Override
    public boolean deletarTodos() throws SQLException
    {
        Connection conn = Conexao.getConexao();
        Statement statement = conn.createStatement();

        boolean executou = false;
        
        try
        {
            String sql;
            sql = "DELETE FROM cliente";
            
            executou = statement.execute(sql);
        } catch (SQLException e)
        {
            throw new SQLException("Erro ao deletar cliente.\n" + e.getMessage());
        } finally
        {
            statement.close();
            conn.close();
        }
        
        return executou;
    }
}
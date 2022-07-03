package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexao.Conexao;
import java.util.ArrayList;
import model.Mensagem;

/**
 *
 * @author 180900411
 */
public class MensagemDAO implements InterfaceDAO<Mensagem>
{

    @Override
    public boolean add(Mensagem pVO) throws SQLException
    {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        boolean executou = false;

        try
        {
            String sql;
            sql = "INSERT INTO mensagem VALUES (null, '"
                    + pVO.getDataDaMensagem() + "', '"
                    + pVO.getTextoDaMensagem() + "';";

            executou = statement.execute(sql);
        } catch (SQLException e)
        {
            throw new SQLException("Erro ao inserir mensagem.\n" + e.getMessage());
        } finally
        {
            statement.close();
            connection.close();
        }

        return executou;
    }

    @Override
    public Mensagem getById(String id) throws SQLException
    {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        Mensagem m = new Mensagem();

        try
        {
            String sql;
            sql = "SELECT * FROM mensagem WHERE idMensagem = " + id;

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next())
            {
                m.setIdMensagem(rs.getInt("idMensagem"));
                m.setDataDaMensagem(rs.getDate("dataDaMensagem"));
                m.setTextoDaMensagem(rs.getString("textoDaMensagem"));
            }
        } catch (SQLException e)
        {
            throw new SQLException("Esta mensagem não existe.\n" + e.getMessage());
        } finally
        {
            statement.close();
            connection.close();
        }

        return m;
    }

    @Override
    public Mensagem getByDoc(String doc) throws SQLException
    {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        Mensagem m = new Mensagem();

        try
        {
            String sql;
            sql = "SELECT * FROM mensagem WHERE idMensagem = " + doc;

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next())
            {
                m.setIdMensagem(rs.getInt("idMensagem"));
                m.setDataDaMensagem(rs.getDate("dataDaMensagem"));
                m.setTextoDaMensagem(rs.getString("textoDaMensagem"));
            }
        } catch (SQLException e)
        {
            throw new SQLException("Esta mensagem não existe.\n" + e.getMessage());
        } finally
        {
            statement.close();
            connection.close();
        }

        return m;
    }

    @Override
    public ArrayList<Mensagem> getAll() throws SQLException
    {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        ArrayList<Mensagem> listaDeMensagem = new ArrayList<>();

        try
        {
            String sql;
            sql = "SELECT * FROM mensagem";

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next())
            {
                Mensagem m = new Mensagem();

                m.setIdMensagem(rs.getInt("idMensagem"));
                m.setDataDaMensagem(rs.getDate("dataDaMensagem"));
                m.setTextoDaMensagem(rs.getString("textoDaMensagem"));

                listaDeMensagem.add(m);
            }
        } catch (SQLException e)
        {
            throw new SQLException("Erro ao carregar mensagens.\n" + e.getMessage());
        } finally
        {
            statement.close();
            connection.close();
        }
        
        return listaDeMensagem;
    }

    @Override
    public boolean atualizar(Mensagem pVO) throws SQLException
    {
        Connection conn = Conexao.getConexao();
        Statement statement = conn.createStatement();
        
        boolean executou = false;
        
        try
        {
            String sql;
            sql = "UPDATE mensagem SET "
                    + "dataMensagem = '" + pVO.getDataDaMensagem()+ "', '"
                    + "textoDaMensagem = '" + pVO.getTextoDaMensagem()+ "', "
                    + "WHERE idMensagem = " + pVO.getIdMensagem();

            if(statement.executeUpdate(sql) > 1)
            {
                executou = true;
            }
        } catch (SQLException e)
        {
            throw new SQLException("Erro ao atualizar a mensagem.\n" + e.getMessage());
        } finally
        {
            statement.close();
            conn.close();
        }
        
        return executou;
    }

    @Override
    public boolean deletar(Mensagem pVO) throws SQLException
    {
        Connection conn = Conexao.getConexao();
        Statement statement = conn.createStatement();

        boolean executou = false;
        
        try
        {
            String sql;
            sql = "DELETE FROM mensagem WHERE idMensagem = " + pVO.getIdMensagem();
            
            executou = statement.execute(sql);
        } catch (SQLException e)
        {
            throw new SQLException("Erro ao deletar a mensagem.\n" + e.getMessage());
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
            sql = "DELETE FROM mensagem";
            
            executou = statement.execute(sql);
        } catch (SQLException e)
        {
            throw new SQLException("Erro ao deletar todas mensagens.\n" + e.getMessage());
        } finally
        {
            statement.close();
            conn.close();
        }
        
        return executou;
    }
}
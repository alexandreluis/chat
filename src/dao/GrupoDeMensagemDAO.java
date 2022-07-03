package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexao.Conexao;
import java.util.ArrayList;
import model.GrupoDeMensagem;
import model.Mensagem;

/**
 *
 * @author 180900411
 */
public class GrupoDeMensagemDAO implements InterfaceDAO<GrupoDeMensagem>
{

    @Override
    public boolean add(GrupoDeMensagem pVO) throws SQLException
    {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        boolean executou = false;

        try
        {
            String sql;
            sql = "INSERT INTO grupodemensagem VALUES (null, "
                    + pVO.getDataDeCriacaoDoGrupo() + ", '"
                    + pVO.getNomeDoGrupo() + "', '"
                    + pVO.getDescricaoDoGrupo() + "', '"
                    + pVO.getParticipantesDoGrupo() + "', '"
                    + pVO.getMensagensEnviadasNoGrupo() + ");";

            executou = statement.execute(sql);
        } catch (SQLException e)
        {
            throw new SQLException("Erro ao salvar mensagens.\n" + e.getMessage());
        } finally
        {
            statement.close();
            connection.close();
        }

        return executou;
    }

    @Override
    public GrupoDeMensagem getById(String id) throws SQLException
    {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        GrupoDeMensagem g = new GrupoDeMensagem();

        try
        {
            String sql;
            sql = "SELECT * FROM grupodemensagem WHERE idGrupoDeMensagem = " + id;

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next())
            {
                g.setIdDoGrupo(rs.getInt("idDoGrupo"));
                //g.setDataDeCriacaoDoGrupo(rs.getDate("dataDeCriacaoDoGrupo"));
                g.setNomeDoGrupo(rs.getString("nomeDoGrupo"));
                //g.setDataDeCriacaoDoGrupo(rs.getString("descricaoDoGrupo"));
                //g.setParticipantesDoGrupo(rs.getArray<Cliente>("participantesDoGrupo"));
                //g.setMensagensEnviadasNoGrupo(rs.getSQLXML(sql));
            }
        } catch (SQLException e)
        {
            throw new SQLException("Não foi possível carregar as mensagens.\n" + e.getMessage());
        } finally
        {
            statement.close();
            connection.close();
        }

        return g;
    }

    @Override
    public GrupoDeMensagem getByDoc(String doc) throws SQLException
    {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        GrupoDeMensagem g = new GrupoDeMensagem();

        try
        {
            String sql;
            sql = "SELECT * FROM grupodemensagem WHERE idGrupoDeMensagem = " + doc;

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next())
            {
                g.setIdDoGrupo(rs.getInt("idDoGrupo"));
                //g.setDataDeCriacaoDoGrupo(rs.getDate("dataDeCriacaoDoGrupo"));
                g.setNomeDoGrupo(rs.getString("nomeDoGrupo"));
                //g.setDataDeCriacaoDoGrupo(rs.getString("descricaoDoGrupo"));
                //g.setParticipantesDoGrupo(rs.getArray<Cliente>("participantesDoGrupo"));
                //g.setMensagensEnviadasNoGrupo(rs.getSQLXML(sql));
            }
        } catch (SQLException e)
        {
            throw new SQLException("Não foi possível carregar as mensagens.\n" + e.getMessage());
        } finally
        {
            statement.close();
            connection.close();
        }

        return g;
    }

    @Override
    public ArrayList<GrupoDeMensagem> getAll() throws SQLException
    {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();

        ArrayList<GrupoDeMensagem> grupoDeMensagem = new ArrayList<>();

        try
        {
            String sql;
            sql = "SELECT * FROM grupodemensagem";

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next())
            {
                GrupoDeMensagem g = new GrupoDeMensagem();

                g.setIdDoGrupo(rs.getInt("idDoGrupo"));
                //g.setDataDeCriacaoDoGrupo(rs.getDate("dataDeCriacaoDoGrupo"));
                g.setNomeDoGrupo(rs.getString("nomeDoGrupo"));
                //g.setDataDeCriacaoDoGrupo(rs.getString("descricaoDoGrupo"));
                //g.setParticipantesDoGrupo(rs.getArray<Cliente>("participantesDoGrupo"));
                //g.setMensagensEnviadasNoGrupo(rs.getSQLXML(sql));

                grupoDeMensagem.add(g);
            }
        } catch (SQLException e)
        {
            throw new SQLException("Erro ao carregar todos grupos.\n" + e.getMessage());
        } finally
        {
            statement.close();
            connection.close();
        }
        
        return grupoDeMensagem;
    }

    @Override
    public boolean atualizar(GrupoDeMensagem pVO) throws SQLException
    {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();
        
        boolean executou = false;
        
        try
        {
            String sql;
            sql = "UPDATE cliente SET "
                    + "dataDeCriacaoDoGrupo = '" + pVO.getDescricaoDoGrupo() + "', "
                    + "nomeDoGrupo = '" + pVO.getNomeDoGrupo() + "', "
                    + "descricaoDoGrupo = '" + pVO.getDescricaoDoGrupo() + "', "
                    + "paticipantesDoGrupo = '" + pVO.getParticipantesDoGrupo() + "', "
                    + "mensagensEnviadasNoGrupo = '" + pVO.getMensagensEnviadasNoGrupo() + "' "
                    + "WHERE idMensagem = " + pVO.getIdDoGrupo();
            
            if(statement.executeUpdate(sql) > 1)
            {
                executou = true;
            }
        } catch (SQLException e)
        {
            throw new SQLException("Erro ao atualizar os grupos.\n" + e.getMessage());
        } finally
        {
            statement.close();
            connection.close();
        }
        
        return executou;
    }

    @Override
    public boolean deletar(GrupoDeMensagem pVO) throws SQLException
    {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();
        
        boolean executou = false;
        
        try
        {
            String sql;
            sql = "DELETE FROM grupodemensagem WHERE idGrupoDeMensagem = " + pVO.getIdDoGrupo();
            
            executou = statement.execute(sql);
        } catch (SQLException e)
        {
            throw new SQLException("Não foi possível deletar grupo.\n" + e.getMessage());
        } finally
        {
            statement.close();
            connection.close();
        }
        
        return executou;
    }

    @Override
    public boolean deletarTodos() throws SQLException
    {
        Connection connection = Conexao.getConexao();
        Statement statement = connection.createStatement();
        
        boolean executou = false;
        
        try
        {
            String sql;
            sql = "DELETE FROM grupodemensagem";
            
            executou = statement.execute(sql);
        } catch (SQLException e)
        {
            throw new SQLException("Não foi possível deletar todos grupos.\n" + e.getMessage());
        } finally
        {
            statement.close();
            connection.close();
        }
        
        return executou;
    }
}
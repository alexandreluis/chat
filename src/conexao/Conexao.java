package conexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author alexandreluis
 */
public class Conexao
{
    private static String url = "jdbc:mysql://localhost:3306/chat";

    private static String user = "root";

    public static String password = "";

    public static Connection getConexao() throws SQLException
    {
        Connection connection = null;

        try
        {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e)
        {
            throw new SQLException("Erro ao conectar ao banco.\n" + e.getMessage());
        }

        return connection;
    }
}

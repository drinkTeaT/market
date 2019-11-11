package sql;

import com.tacbin.sql.DataBaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Description
 * Author liuweibin
 * Date 2019/11/11 11:21
 **/
public class ConnectionTest {
    public static void main(String[] args) {
        Connection connection = DataBaseConnection.getConnection();
        try {
            System.out.println(connection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

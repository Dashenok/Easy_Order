package models.oracle;

import models.dao.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDaoFactory implements DaoFactory {
    private String user = "EasyOrder";    //����� ������������
    private String password = "EasyOrder";    //������ ������������
    private String url = "jdbc:oracle:thin:@localhost:1521:XE";    //URL �����
    private String driver = "oracle.jdbc.driver.OracleDriver";    //��� ��������
    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    @Override
    public UserDao getUserDao(Connection connection) {

        return new OracleUserDao(connection);
    }
    public OracleDaoFactory() {
        try {
            Class.forName(driver);
    } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

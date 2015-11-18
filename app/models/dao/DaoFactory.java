package models.dao;

import java.sql.Connection;
import java.sql.SQLException;

 public interface DaoFactory {

    //���������� ����������� � ���� ������
     Connection getConnection() throws SQLException;

    /* ���������� ������ ��� ���������� ������������� ���������� ������� User */
     UserDao getUserDao(Connection connection);

}

package models.dao;

import models.User;

import java.sql.SQLException;
 import java.util.List;

 /** ������ ��� ���������� ������������� ���������� ������� User */

 public interface UserDao {

     /** ������� ����� ������ � ��������������� �� ������ */
     User create();

     /** ���������� ������ ��������������� ������ � ��������� ������ key ��� null */
     User read(int key) throws SQLException;

     /** ��������� ��������� ������� user � ���� ������ */
     void update(User user);

     /** ������� ������ �� ������� �� ���� ������ */
     void delete(User user);

     /** ���������� ������ �������� ��������������� ���� ������� � ���� ������ */
     public List<User> getAll() throws SQLException;

 }
package controllers;

import models.oracle.*;
import models.User;
import models.dao.*;
import play.mvc.*;
import sun.awt.Symbol;

import java.sql.Connection;
import java.sql.SQLException;


public class Users extends Controller{
    public static String getUserByID (String userId) throws SQLException {
        DaoFactory daoFactory = new OracleDaoFactory();
        User g;

        try (Connection con = daoFactory.getConnection())
        {
            UserDao dao = daoFactory.getUserDao(con);

            g = dao.read(Integer.parseInt(userId)); //read by id

        }

        StringBuilder stringBuilder = new StringBuilder("ID: ").append(g.getId())
                .append(", name: ").append(g.getFirstName()).append(" ").append(g.getLastName())
                .append(", phone: ").append(g.getPhone()).append(", role ").append(g.getRole());
        render(stringBuilder);
        return stringBuilder.toString();

    }

    public static void userId(){
        render();
    }
}

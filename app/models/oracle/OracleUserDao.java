package models.oracle;
import models.User;
import models.dao.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleUserDao implements UserDao {
    private final Connection connection;

    public OracleUserDao(Connection connection) {
        this.connection = connection;
    }
    @Override
    public User create() {
        return null;
    }

    @Override
    public User read(int key) throws SQLException {
        String sql = "SELECT OBJECTS.OBJECT_ID userId, afn.VALUE firstname, aln.VALUE lastname, aph.VALUE phone, arl.VALUE role "+
                "FROM OBJECTS, ATTRIBUTES afn, ATTRIBUTES aln,  ATTRIBUTES aph, ATTRIBUTES arl " +
                "WHERE OBJECTS.OBJECT_ID = ? AND OBJECTS.OBJECT_TYPE_ID = 1 " +
                "AND afn.ATTR_ID = 1 AND afn.OBJECT_ID = OBJECTS.OBJECT_ID " +
                "AND aln.ATTR_ID = 2 AND aln.OBJECT_ID = OBJECTS.OBJECT_ID " +
                "AND aph.ATTR_ID = 4 AND aph.OBJECT_ID = OBJECTS.OBJECT_ID " +
                "AND arl.ATTR_ID = 6 AND arl.OBJECT_ID = OBJECTS.OBJECT_ID ";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setInt(1, key);

        ResultSet rs = stm.executeQuery();
        User g = new User();
        if (rs.next()) {
            g.setId(rs.getInt("userId"));
            g.setFirstName(rs.getString("firstname"));
            g.setLastName(rs.getString("lastname"));
            g.setPhone(rs.getString("phone"));
            g.setRole(rs.getString("role"));
        }
        return g;
    }

    @Override
    public void update(User user) { }

    @Override
    public void delete(User user) { }

    @Override
    public List<User> getAll() throws SQLException {
        String sql = "SELECT * FROM Groupp";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<User> list = new ArrayList<User>();
        while (rs.next()) {
            User g = new User();
            g.setId(rs.getInt("id"));

            list.add(g);
        }
        return list;
    }


}

package v1.excutor;

import v1.mapper.User;

import java.sql.*;

/**
 * @Classname CustomDefaultExecutor
 * @Date 2019/5/20 15:59
 * @Autor lengzefu
 */
public class CustomDefaultExecutor implements CustomExcutor {
    @Override
    public <T> T query(String statement, String parameter) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        User user = null;

        try {
            conn = getConnection();
            //TODO ParameterHandler
            preparedStatement = conn.prepareStatement(String.format(statement, Integer.parseInt(parameter)));
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();

            //TODO ObjectFactory
            user = new User();

            //TODO ResultSetHandler
            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setBirthday(rs.getDate(3));
                user.setAddress(rs.getString(4));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return (T)user;
    }

    public Connection getConnection() throws SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mybatis?useUnicode=true&amp;characterEncoding=utf-8\n" +
                "jdbc.driver=com.mysql.jdbc.Driver";
        String username = "root";
        String password = "root";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}

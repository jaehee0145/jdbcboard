package my.examples.jdbcboard.dao;

import my.examples.jdbcboard.dto.User;
import my.examples.jdbcboard.util.ConnectionContextHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    private static UserDao instance = new UserDaoImpl();

    private UserDaoImpl() {
    }

    public static UserDao getInstance() {
        return instance;
    }

    @Override
    public void addUser(User user) {
        try {
            Connection conn = ConnectionContextHolder.getConnection();
            // name, nickname, email, passwd
            try (PreparedStatement ps = conn.prepareStatement(UserDaoSQL.INSERT);) {
                ps.setString(1, user.getName());
                ps.setString(2, user.getNickname());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getPasswd());
                ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public User getPasswdByEmail(String email) {
        User user = null; // return할 타입을 선언한다.

        Connection conn = ConnectionContextHolder.getConnection();
        try {
            try (PreparedStatement ps = conn.prepareStatement(UserDaoSQL.SELECT_BY_EMAIL);) {
                ps.setString(1, email);

                try (ResultSet rs = ps.executeQuery();) { // SELECT 문장을 실행, executeUpdate() - insert, update, delete

                    if (rs.next()) {
                        user = new User();
                        user.setId(rs.getLong(1));
                        user.setName(rs.getString(2));
                        user.setNickname(rs.getString(3));
                        user.setEmail(rs.getString(4));
                        user.setPasswd(rs.getString(5));
                        user.setRegdate(rs.getDate(6));
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return user;
    }
}

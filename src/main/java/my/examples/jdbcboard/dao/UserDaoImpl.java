package my.examples.jdbcboard.dao;

import my.examples.jdbcboard.dto.User;
import my.examples.jdbcboard.util.ConnectionContextHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDaoImpl implements UserDao {
    private static UserDao instance = new UserDaoImpl();

    private UserDaoImpl() {
    }

    public static UserDao getInstance() {
        return instance;
    }

    @Override
    public void addUser(User user) {
        try{
            Connection conn = ConnectionContextHolder.getConnection();
            // name, nickname, email, passwd
            try(PreparedStatement ps = conn.prepareStatement(UserDaoSQL.INSERT);) {
                ps.setString(1, user.getName());
                ps.setString(2, user.getNickname());
                ps.setString(3, user.getEmail());
                ps.setString(4, user.getPasswd());
                ps.executeUpdate(); // 입력,수정,삭제 건수 가 리턴된다.
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}

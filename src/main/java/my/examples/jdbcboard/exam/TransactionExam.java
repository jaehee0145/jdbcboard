package my.examples.jdbcboard.exam;

import my.examples.jdbcboard.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransactionExam {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DBUtil.getInstance().getConnection();
            conn.setAutoCommit(false);
            // 여러개의  sql 실행
            String sql = "insert into board (title, content, writer) values ('java', '화이팅', 'writer')";
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.clearParameters();

            conn.commit();

        }catch(Exception ex){
            try{ conn.rollback();} catch(Exception ignore){}
            ex.printStackTrace();

        }finally{
            DBUtil.close(ps);
        }
    }
}

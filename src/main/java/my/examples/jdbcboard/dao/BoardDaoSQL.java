package my.examples.jdbcboard.dao;

public class BoardDaoSQL {

    public static final String SELECT_BY_ID =
            "select id, title, user_id, nickname, regdate, read_count, group_no, group_seq, group_depth, content from board where id = ?";
    public static final String SELECT_BY_PAGING =
            "select id, title, user_id, nickname, regdate, read_count, group_no, group_seq, group_depth  from board b order by group_no desc, group_seq limit ?, ?";
    public static final String INSERT = "INSERT INTO board(title, user_id, nickname, content) VALUES(?, ?, ?, ?)";
    public static final String DELETE = "DELETE FROM board WHERE id = ?";
    public static final String UPDATE = "UPDATE board SET read_count = read_count + 1 WHERE id = ?";
    public static final String MODIFY = "UPDATE board SET title=?, content=? where id =?";
    public static final String UPDATE_LAST_INSERT_ID = "UPDATE board SET group_no = ? WHERE id = ?";
    public static final String SELECT_LAST_INSERT_ID = "select LAST_INSERT_ID()";
}

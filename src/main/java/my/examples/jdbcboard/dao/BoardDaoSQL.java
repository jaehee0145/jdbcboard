package my.examples.jdbcboard.dao;

public class BoardDaoSQL {

    public static final String SELECT_BY_ID = "SELECT id, title, content, nickname, regdate, read_count FROM board WHERE id =?";
    public static final String SELECT_BY_PAGING = "SELECT id, title, content, nickname, regdate, read_count FROM board ORDER BY id DESC LIMIT ?, ?";
    public static final String INSERT = "INSERT INTO board(title, nickname, content) VALUES(?, ?, ?)";
    public static final String DELETE = "DELETE FROM board WHERE id = ?";
    public static final String UPDATE = "UPDATE board SET read_count = read_count + 1 WHERE id = ?";
    public static final String MODIFY = "UPDATE board SET title=? content=? where id =? ";
}

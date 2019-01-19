package my.examples.jdbcboard.dao;

import my.examples.jdbcboard.dto.Board;

import java.util.List;

public interface BoardDao {
    public Board getBoard(Long id);
    public List<Board> getBoards(int start, int limit);

    void addBoard(Board board);
    void deleteBoard(Long id);
    void modifyBoard(Long id, String title, String content);
    void updateReadCount(long id);

    Long getLastInsertId();

    void updateLastInsertId(Long lastInsertId);
}

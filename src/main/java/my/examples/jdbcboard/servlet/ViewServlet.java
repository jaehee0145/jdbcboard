package my.examples.jdbcboard.servlet;

import my.examples.jdbcboard.dao.BoardDao;
import my.examples.jdbcboard.dao.BoardDaoImpl;
import my.examples.jdbcboard.dto.Board;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ViewServlet", urlPatterns = "/board/view")
public class ViewServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idStr = req.getParameter("id");
        Long id = 0L;
        try {
            id = Long.parseLong(idStr);
        } catch (Exception ex) {
            return;
        }
        BoardDao boardDao = new BoardDaoImpl();
        Board board = boardDao.getBoard(id);
        if(board == null){
            return;
        }

        boardDao.updateReadCount(id);
        req.setAttribute("board", board);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/view.jsp");
        requestDispatcher.forward(req, resp);


    }
}

package my.examples.jdbcboard.servlet;

import my.examples.jdbcboard.dao.BoardDao;
import my.examples.jdbcboard.dao.BoardDaoImpl;
import my.examples.jdbcboard.dto.Board;
import my.examples.jdbcboard.dto.User;
import my.examples.jdbcboard.service.BoardService;
import my.examples.jdbcboard.service.BoardServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "WriteServlet", urlPatterns = "/board/write")
public class WriteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//필터에서 확인
        //        HttpSession session = req.getSession();
//        String email = (String) session.getAttribute("logininfo");
//        if (email == null) {
//            resp.sendRedirect("/board");
//            return;
//        } else {
//            System.out.println("로그인 ok");
//        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/view/write.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String title = req.getParameter("title");
        String content = req.getParameter("content");

        User user = (User) req.getSession().getAttribute("logininfo");

        BoardService boardService = new BoardServiceImpl();
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setUserId(user.getId());
        board.setNickname(user.getNickname());

        boardService.addBoard(board);
        resp.sendRedirect("/board/list");
    }
}

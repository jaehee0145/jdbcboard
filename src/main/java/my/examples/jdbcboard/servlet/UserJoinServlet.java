package my.examples.jdbcboard.servlet;

import my.examples.jdbcboard.dto.Board;
import my.examples.jdbcboard.dto.User;
import my.examples.jdbcboard.service.BoardService;
import my.examples.jdbcboard.service.BoardServiceImpl;
import my.examples.jdbcboard.service.UserService;
import my.examples.jdbcboard.service.UserServiceImpl;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserJoinServlet", urlPatterns = "/board/join")
public class UserJoinServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String nickname = req.getParameter("nickname");
        String email = req.getParameter("email");
        String passwd1 = req.getParameter("passwd1");
        String passwd2 = req.getParameter("passwd2");

        // 실제 값을 검사
        if(name != null && name.length() < 2){
            resp.sendRedirect("/join?error=babo");
            return;
        }
        // 암호1과 암호2가 같으냐.

        PasswordEncoder passwordEncoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();

        // 암호화 하는 코드
        String encodePasswd = passwordEncoder.encode(passwd1);

        User user = new User(name, nickname, email, encodePasswd);
        UserService userService = UserServiceImpl.getInstance();
        userService.addUser(user);

        resp.sendRedirect("/board");
    }
}

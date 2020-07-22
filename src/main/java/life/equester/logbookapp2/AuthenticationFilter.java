package life.equester.logbookapp2;

import life.equester.logbookapp2.controllers.AuthenticationController;
import life.equester.logbookapp2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationFilter extends HandlerInterceptorAdapter {

   // @Autowired
    //UserRepository userRepository;

    //TODO: (explain in this comment the code below does)
    @Autowired
    AuthenticationController authenticationController;

    //TODO: (explain in this comment the code below does)
    private static final List<String> whitelist = Arrays.asList("/login", "/register", "/logout", "/css");

    //TODO: (explain in this comment the code below does)
    private static boolean isWhitelisted(String path) {
        for (String pathRoot : whitelist) {
            if (path.startsWith(pathRoot)) {
                return true;
            }
        }
        return false;
    }

    //TODO: (explain in this comment what the code below does)
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws IOException {

//TODO: (explain in this comment the code below does)
        if (isWhitelisted(request.getRequestURI())) {
            return true;
        }
//TODO: (explain in this comment the code below does)
        HttpSession session = request.getSession();
        User user = authenticationController.getUserFromSession(session);
//TODO: (explain in this comment the code below does)
        // The user is logged in
        if (user != null) {
            return true;
        }
//TODO: (explain in this comment the code below does)
        // The user is NOT logged in
        response.sendRedirect("/login");
        return false;
    }


}
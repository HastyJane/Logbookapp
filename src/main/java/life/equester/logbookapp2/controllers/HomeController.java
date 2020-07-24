package life.equester.logbookapp2.controllers;

import com.mysql.cj.Session;
import life.equester.logbookapp2.models.Snippet;
import life.equester.logbookapp2.models.User;
import life.equester.logbookapp2.models.data.SnippetRepository;
import life.equester.logbookapp2.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private SnippetRepository snippetRepository;

    @Autowired
    private UserRepository userRepository;

    private static final String userSessionKey = "user";

    @RequestMapping("")
    public String index(Model model, HttpServletRequest request) {
        Date today = new Date();
        Integer millisecondsInDay = 24 * 60 * 60 * 1000;
        Date yesterday = new Date(today.getTime() - millisecondsInDay);
        HttpSession session = request.getSession();
        User user = getUserFromSession(session);
        model.addAttribute("snippets", snippetRepository.findByTimeStampBetweenAndUserIdOrderByTimeStampDesc(yesterday, today, user.getId()));
        //model.addAttribute("snippets", snippetRepository.findAll());
        return "index";
    }

    public User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;
        }

        return user.get();
    }

    @RequestMapping("add")
    public String displayAddSnippetForm(Model model) {
        SnippetRepository snippets;
        model.addAttribute(new Snippet());


        return "add";
    }

    @PostMapping("add")
    public String processAddSnippetForm(@ModelAttribute @Valid Snippet newSnippet,
                                    Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            return "add";
        }
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        newSnippet.setTimeStamp(currentTime);

        HttpSession session = request.getSession();
        User user = getUserFromSession(session);
        newSnippet.setUser(user);
        snippetRepository.save(newSnippet);
        return "redirect:";
    }
}

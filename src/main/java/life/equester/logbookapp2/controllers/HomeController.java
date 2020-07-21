package life.equester.logbookapp2.controllers;

import life.equester.logbookapp2.models.Snippet;
import life.equester.logbookapp2.models.data.SnippetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;

@Controller
public class HomeController {

    @Autowired
    private SnippetRepository snippetRepository;

    @RequestMapping("")
    public String index(Model model) {

        return "index";
    }

    @RequestMapping("add")
    public String displayAddSnippetForm(Model model) {
        model.addAttribute(new Snippet());
        Date today = new Date();
        Integer millisecondsInDay = 24 * 60 * 60 * 1000;
        Date yesterday = new Date(today.getTime() - millisecondsInDay);
        model.addAttribute("snippets", snippetRepository.findByTimeStampBetween(yesterday, today));
        return "add";
    }

    @PostMapping("add")
    public String processAddSnippetForm(@ModelAttribute @Valid Snippet newSnippet,
                                    Errors errors) {

        if (errors.hasErrors()) {
            return "add";
        }
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        newSnippet.setTimeStamp(currentTime);
        snippetRepository.save(newSnippet);

        return "add";
    }
}

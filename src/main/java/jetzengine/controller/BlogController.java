package jetzengine.controller;

import java.security.Principal;
import jetzengine.entity.Blog;
import jetzengine.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping("/@{zname}")
    public String userBlog(@PathVariable String zname, Model model, Principal principal) {
        if (blogService.findBlog(zname) == null) {
            blogService.create(zname);
        }

        Blog blog = blogService.findBlog(zname);

        model.addAttribute("blog", blog);

        return "blog/main";
    }
}

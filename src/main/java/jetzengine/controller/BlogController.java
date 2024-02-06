package jetzengine.controller;

import java.security.Principal;
import jetzengine.entity.Blog;
import jetzengine.entity.Zuser;
import jetzengine.service.BlogService;
import jetzengine.service.ZuserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;
    private final ZuserService zuserService;

    @GetMapping("/@{zname}")
    public String userBlog(@PathVariable String zname, Model model, Principal principal) {
        if (blogService.findBlog(zname) == null) {
            blogService.create(zname);
        }

        if (principal != null) {
            Zuser zuser = zuserService.getZuser(principal.getName());
            model.addAttribute("zuser", zuser);
        }

        Blog blog = blogService.findBlog(zname);

        model.addAttribute("blog", blog);

        return "blog/main";
    }
}

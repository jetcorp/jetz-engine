package jetzengine.controller;

import java.security.Principal;
import jetzengine.entity.Zuser;
import jetzengine.service.ZuserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class JetzController {
    private final ZuserService zuserService;

    @GetMapping("/")
    public String index(Model model, Principal principal) {
        if (principal != null) {
            Zuser zuser = zuserService.getZuser(principal.getName());
            model.addAttribute("zuser", zuser);
        }

        return "index";
    }
}

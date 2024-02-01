package jetzengine.config;

import jakarta.validation.Valid;
import jetzengine.form.ZuserForm;
import jetzengine.service.ZuserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final ZuserService zuserService;

    @GetMapping("/signup")
    public String signup(ZuserForm zuserForm) {
        return "auth/signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid ZuserForm zuserForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "auth/signup";

        if (!zuserForm.getPassword1().equals(zuserForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordIncorrect", "비밀번호 확인이 일치하지 않습니다.");
            return "auth/signup";
        }

        try {
            zuserService.create(zuserForm.getEmail(), zuserForm.getPassword1(), zuserForm.getZname());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "auth/signup";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "auth/signup";
        }

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
}

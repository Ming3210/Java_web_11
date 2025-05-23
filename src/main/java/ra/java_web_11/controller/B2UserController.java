package ra.java_web_11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ra.java_web_11.model.B2_User;

import javax.validation.Valid;

@Controller
public class B2UserController {
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("registerUser", new B2_User());
        return "register-form";
    }

    @PostMapping("/register")
    public String processRegister(
            @Valid @ModelAttribute("registerUser") B2_User registerUser,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "register-form";
        }


        model.addAttribute("message", "Đăng ký thành công!");
        return "register-success";
    }
}

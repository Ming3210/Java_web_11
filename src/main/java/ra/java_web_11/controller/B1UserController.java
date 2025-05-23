package ra.java_web_11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ra.java_web_11.model.B1_User;

import javax.validation.Valid;

@Controller
public class B1UserController {

    @GetMapping("/user/form")
    public String showForm(Model model) {
        model.addAttribute("user", new B1_User());
        return "user-form";
    }

    @PostMapping("/user/save")
    public String saveUser(@Valid @ModelAttribute("user") B1_User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user-form";
        }
        model.addAttribute("message", "Đăng ký thành công!");
        return "user-success";
    }
}

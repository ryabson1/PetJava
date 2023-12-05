package ru.ryabson.Processing.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ryabson.Processing.entity.LoginAudit;
import ru.ryabson.Processing.entity.User;
import ru.ryabson.Processing.service.LoginAuditService;
import ru.ryabson.Processing.service.UserService;

@Controller
@AllArgsConstructor
public class LoginController {

    private final UserService userService;
    private final LoginAuditService auditService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(User loginUser, Model model, HttpServletRequest request) {
        User existingUser = userService.findUserByName(loginUser.getUserName());
        if (existingUser != null && existingUser.getUserPassword()
                .equals(loginUser.getUserPassword())) {
            LoginAudit loginAudit = new LoginAudit();
            loginAudit.setUserName(loginUser.getUserName());
            loginAudit.setIpAddress(request.getRemoteAddr());
            loginAudit.setLoginTime(LocalDateTime.now());
            auditService.createAudit(loginAudit);
            return "redirect:/mainForm";
        } else {
            model.addAttribute("error", true);
            return "login";
        }
    }



    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String processRegistration(User user, Model model) {
        if (userService.checkLoginAvailable(user.getUserName())) {
            model.addAttribute("error", true);
            return "registration";
        }
        userService.createUser(user);
        return "redirect:/login";
    }

}

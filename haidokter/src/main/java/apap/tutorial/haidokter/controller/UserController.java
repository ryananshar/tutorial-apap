package apap.tutorial.haidokter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.haidokter.model.UserModel;
import apap.tutorial.haidokter.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUserSubmit(@ModelAttribute UserModel user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @RequestMapping(value= "/updatePassword", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public String updatePassword(
        @RequestParam("newPassword") String newPassword, 
        @RequestParam("confirmPassword") String confirmPassword, 
        @RequestParam("oldPassword") String oldPassword, 
        Model model
    ) throws Exception {
        String check = "false";
        UserModel user = userService.getUserByName(
            SecurityContextHolder.getContext().getAuthentication().getName());

        // String pass = user.getPassword();
        String validate = Boolean.toString(userService.checkIfValidOldPassword(user, oldPassword));

        if (!userService.checkIfValidOldPassword(user, oldPassword)) {
            throw new Exception();
        }

        if (newPassword.equals(confirmPassword)) {
            check = "true";
        } else {
            String msg = "Pastikan Pasword Baru dan Konfirmasi Pasword sama";
            model.addAttribute("msg", msg);
            return "form-update-password";
        }
        
        userService.changePassword(user, newPassword);        

        model.addAttribute("username", user.getUsername());
        model.addAttribute("validate", validate);
        model.addAttribute("check", check);
        model.addAttribute("newPassword", newPassword);
        model.addAttribute("oldPassword", oldPassword);
        return "update-password";
    }
}

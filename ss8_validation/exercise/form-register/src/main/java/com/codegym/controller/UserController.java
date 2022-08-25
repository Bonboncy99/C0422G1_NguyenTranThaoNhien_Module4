package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/")
    public String goToList(Model model){
        model.addAttribute("userList",this.iUserService.findAll());
        return "list";
    }
    @GetMapping("/add")
    public String goToAdd(Model model){
        model.addAttribute("userDto",new UserDto());
        return "add";
    }
    @PostMapping("/add")
    public String addUser(@ModelAttribute @Valid UserDto userDto,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes, Model model) {

        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()){
            return "add";
        }

        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        this.iUserService.add(user);
        redirectAttributes.addFlashAttribute("messCreate", "Add success");
        return "redirect:/";
    }

}

package com.example.ecomigo.controller;

import com.example.ecomigo.model.PessoaFisica;
import com.example.ecomigo.model.Usuario;
import com.example.ecomigo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



    @PostMapping("/Salvar")
    public String saveUser(@Valid PessoaFisica pessoaFisica, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "user/index";
        }

        pessoaFisica.setTipoCadastro(Usuario.TipoCadastro.PF);
        userService.saveUser(pessoaFisica);

        return "redirect:/login";
    }


}
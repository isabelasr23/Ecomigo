package com.example.ecomigo.controller;


import com.example.ecomigo.model.PessoaFisica;
import com.example.ecomigo.model.Usuario;
import com.example.ecomigo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String senha,
                        SecurityContext currentContext,
                        HttpServletRequest request,
                        HttpServletResponse response) {

        Usuario usuario = userService.loadUserByEmail(email);

        if (usuario == null || !userService.verifyPassword(senha, usuario.getSenha())){
            return "redirect:/login?error=true";
        }

        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(usuario, null, authorities);

        currentContext.setAuthentication(authentication);

        SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();
        securityContextRepository.saveContext(currentContext, request, response);

        return "redirect:/login/inicio-pf";
    }


    @GetMapping("/login/inicio-pf")
    public String inicioPf(Model model, Principal principal){

        String nomeUsuario = principal.getName();

        Optional<Usuario> usuarioOpt = userService.findByUsername(nomeUsuario);
        if (usuarioOpt.isPresent()){
            Usuario usuario = usuarioOpt.get();
            if (usuario instanceof PessoaFisica){
                PessoaFisica pessoaFisica = (PessoaFisica) usuario;
                model.addAttribute("usuarioLogado", pessoaFisica);
                return "telaInicialPf";
            } else {
                System.out.println("Usuário logado não é PessoaFisica.");
                return "redirect:/login";
            }
        }else {
            return "redirect:/login";
        }
    }

}

package com.example.ecomigo.service;

import com.example.ecomigo.model.PessoaFisica;
import com.example.ecomigo.model.PontuacaoPF;
import com.example.ecomigo.model.Usuario;
import com.example.ecomigo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(PessoaFisica pessoaFisica){
        PontuacaoPF pontuacao = new PontuacaoPF();
        pessoaFisica.setPontuacao(pontuacao);
        pontuacao.setPessoaFisica(pessoaFisica);

        String senhaCriptografada = passwordEncoder.encode(pessoaFisica.getSenha());
        pessoaFisica.setSenha(senhaCriptografada);

        userRepository.save(pessoaFisica);
    }
    public Optional<Usuario> findByUsername(String nomeUsuario){return userRepository.findByNomeUsuario(nomeUsuario);}

    public Usuario loadUserByEmail(String email){ return userRepository.findByEmail(email).orElse(null);}

    public boolean verifyPassword(String senhaDigitada, String senhaCriptografada){
        return passwordEncoder.matches(senhaDigitada, senhaCriptografada);
    }

}

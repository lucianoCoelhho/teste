package com.entra21.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.backend.dto.PessoaClienteRequestDTO;
import com.entra21.backend.entity.Pessoa;
import com.entra21.backend.repository.PessoaClienteRepository;

@Service
public class PessoaClienteService {

    @Autowired
    private PessoaClienteRepository pessoaClienteRepository;

    @Autowired
    private EmailService emailService;

   

    public Pessoa registrar(PessoaClienteRequestDTO pessoaClienteRequestDTO) {
        Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);// foi convertido

        Pessoa pessoaNova = pessoaClienteRepository.saveAndFlush(pessoa);

        emailService.enviarEmailTexto(pessoaNova.getEmail(), "cadastro no AlugaAi", "O registro foi feito com sucesso. em breve voce recebera a senha de acesso por e-mail!! ");
         return pessoaNova;
    }// ira salvar a pessoa

}

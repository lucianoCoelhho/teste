package com.entra21.backend.entity;
//O primeiro pois nao depende de outras

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pessoa")
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String endereço;
    private String cep;

    
    
}

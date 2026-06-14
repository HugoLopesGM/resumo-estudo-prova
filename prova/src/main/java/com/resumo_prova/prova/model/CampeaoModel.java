package com.resumo_prova.prova.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Entity
@Table
@Data
public class CampeaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull(message = "Nome não pode ser nulo")
    private String nome;

    private String funcao;

    private String elo;
}

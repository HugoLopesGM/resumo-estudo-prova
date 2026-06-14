package com.resumo_prova.prova.repository;

import com.resumo_prova.prova.model.CampeaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CampeaoRepository extends JpaRepository<CampeaoModel, UUID> {
    List<CampeaoModel>findByNome(String nome);
}

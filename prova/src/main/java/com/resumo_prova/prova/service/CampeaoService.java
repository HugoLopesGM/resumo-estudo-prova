package com.resumo_prova.prova.service;

import com.resumo_prova.prova.model.CampeaoModel;
import com.resumo_prova.prova.repository.CampeaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CampeaoService {
    @Autowired
    private CampeaoRepository repository;

    public CampeaoModel save(CampeaoModel campeaoModel){
        return repository.save(campeaoModel);
    }

    public List<CampeaoModel>listar(){
        return repository.findAll();
    }

    public Optional<CampeaoModel>buscaPorId(UUID id){
        return repository.findById(id);
    }

    public List<CampeaoModel>buscaPorNome(String nome){
        return repository.findByNome(nome);
    }

    public void deletar(UUID id){
        repository.deleteById(id);
    }

    public CampeaoModel atualizar(UUID id, CampeaoModel campeaoModel){
        campeaoModel.setId(id);
        return repository.save(campeaoModel);
    }
}

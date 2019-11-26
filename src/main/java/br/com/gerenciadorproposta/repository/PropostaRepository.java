package br.com.gerenciadorproposta.repository;

import br.com.gerenciadorproposta.model.Proposta;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {
    
}
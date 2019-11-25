package br.com.gerenciadorproposta.repository;

import br.com.gerenciadorproposta.model.Proposta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {
}
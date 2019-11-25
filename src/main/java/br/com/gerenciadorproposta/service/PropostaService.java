package br.com.gerenciadorproposta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciadorproposta.exception.BusinessException;
import br.com.gerenciadorproposta.exception.EntityNotFoundException;
import br.com.gerenciadorproposta.model.Proposta;
import br.com.gerenciadorproposta.repository.PropostaRepository;

@Service
public class PropostaService implements CrudService<Proposta, Long> {

    @Autowired
    private PropostaRepository repository;

    @Override
    public List<Proposta> findAll() {
        return repository.findAll();
    }

    @Override
    public Proposta findOne(Long id) throws EntityNotFoundException {
        return repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Registro não encontrado."));
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException, BusinessException {
        repository.deleteById(id);
    }

    @Override
    public Proposta update(Proposta proposta) throws EntityNotFoundException, BusinessException {
        try {
            Proposta propostaAtualizada = repository.getOne(proposta.getId());
            return repository.save(propostaAtualizada);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Registro não encontrado.", e);
        }
    }

    @Override
    public Proposta save(Proposta proposta) throws EntityNotFoundException, BusinessException {
        return repository.save(proposta);
    }

}

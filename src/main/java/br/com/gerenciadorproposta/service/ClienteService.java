package br.com.gerenciadorproposta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciadorproposta.exception.BusinessException;
import br.com.gerenciadorproposta.exception.EntityNotFoundException;
import br.com.gerenciadorproposta.model.Cliente;
import br.com.gerenciadorproposta.repository.ClienteRepository;

@Service
public class ClienteService implements CrudService<Cliente, Long> {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @Override
    public Cliente findOne(Long id) throws EntityNotFoundException {
        return repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Registro não encontrado."));
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException, BusinessException {
        repository.deleteById(id);
    }

    @Override
    public Cliente update(Long id, Cliente cliente) throws EntityNotFoundException, BusinessException {
        try {
            Cliente clienteAtualizado = repository.getOne(id);
            clienteAtualizado.setCnpj(cliente.getCnpj());
            clienteAtualizado.setEmail(cliente.getEmail());
            clienteAtualizado.setRazaoSocial(cliente.getRazaoSocial());
            clienteAtualizado.setTelefone(cliente.getTelefone());
            return repository.save(clienteAtualizado);
        } catch (javax.persistence.EntityNotFoundException e) {
            throw new EntityNotFoundException("Registro não encontrado.", e);
        }
    }

    @Override
    public Cliente save(Cliente cliente) throws EntityNotFoundException, BusinessException {
        return repository.save(cliente);
    }
}

package br.com.gerenciadorproposta.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gerenciadorproposta.exception.BusinessException;
import br.com.gerenciadorproposta.exception.EntityNotFoundException;
import br.com.gerenciadorproposta.model.Cliente;

@Service
public class ClienteService implements CrudService<Cliente, Long> {

    @Override
    public List<Cliente> findAll() {
        return Arrays.asList(new Cliente(1l, "cnpj1", "razao1", "telefone1", "email1"),
                new Cliente(1l, "cnpj2", "razao2", "telefone2", "email2"));
    }

    @Override
    public Cliente findOne(Long id) throws EntityNotFoundException {
        return new Cliente(1l, "cnpj1", "razao2", "telefone3", "email4");
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException, BusinessException {
        // TODO Auto-generated method stub
    }

    @Override
    public Cliente update(Cliente cliente) throws EntityNotFoundException, BusinessException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Cliente save(Cliente cliente) throws EntityNotFoundException, BusinessException {
        // TODO Auto-generated method stub
        return null;
    }
}

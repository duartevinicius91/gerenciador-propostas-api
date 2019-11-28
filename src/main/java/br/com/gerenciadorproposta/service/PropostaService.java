package br.com.gerenciadorproposta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciadorproposta.exception.BusinessException;
import br.com.gerenciadorproposta.exception.EntityNotFoundException;
import br.com.gerenciadorproposta.model.Cliente;
import br.com.gerenciadorproposta.model.Proposta;
import br.com.gerenciadorproposta.repository.ClienteRepository;
import br.com.gerenciadorproposta.repository.PropostaRepository;

@Service
public class PropostaService { // está desrespeitando a interface CrudService

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Proposta> findByCliente(Long idCliente) {
        return propostaRepository.findByClienteId(idCliente);
    }

    public List<Proposta> findAll() {
        return propostaRepository.findAll();
    }

    public Proposta findOne(Long idCliente, Long idProposta) throws EntityNotFoundException, BusinessException {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("Registro não encontrado."));
        List<Proposta> propostas = cliente.getPropostas();
        Proposta proposta = propostas.stream().filter(p -> p.getId() == idProposta).findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Registro não encontrado."));
        return proposta;
    }

    public void delete(Long idCliente, Long idProposta) throws EntityNotFoundException, BusinessException {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("Registro não encontrado."));
        List<Proposta> propostas = cliente.getPropostas();
        Proposta proposta = propostas.stream().filter(p -> p.getId() == idProposta).findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Registro não encontrado."));
        propostaRepository.delete(proposta);
    }

    public Proposta update(Long idCliente, Long idProposta, Proposta proposta)
            throws EntityNotFoundException, BusinessException {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("Registro não encontrado."));
        List<Proposta> propostas = cliente.getPropostas();

        return propostas.stream().filter(p -> p.getId() == idProposta).findFirst().map(p -> {
            p.setData(proposta.getData());
            p.setDescricao(proposta.getDescricao());
            p.setStatus(proposta.getStatus());
            p.setValor(proposta.getValor());
            return propostaRepository.save(p);
        }).orElseThrow(() -> new EntityNotFoundException("Registro não encontrado."));
    }

    public Proposta save(Long idCliente, Proposta proposta) throws EntityNotFoundException, BusinessException {
        Cliente cliente = clienteRepository.getOne(idCliente);
        proposta.setCliente(cliente);
        return propostaRepository.save(proposta);
    }

}
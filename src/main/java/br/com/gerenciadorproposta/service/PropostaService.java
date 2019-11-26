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
public class PropostaService {

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Proposta> findAll(Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new EntityNotFoundException("Registro não encontrado."));
        List<Proposta> propostas = cliente.getPropostas();
        return propostas;
    }

    public Proposta findOne(Long idCliente, Long idProposta) {
        List<Proposta> propostas = new PropostaService().findAll(idCliente);
        try {
            for (Proposta proposta : propostas) {
                if (proposta.getId() == idProposta) {
                    return proposta;
                }
            }
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Registro não encontrado.", e);
        }
        return null;
    }

    public void delete(Long idCliente, Long idProposta) {
        List<Proposta> propostas = new PropostaService().findAll(idCliente);
        for (Proposta proposta : propostas) {
            if (proposta.getId() == idProposta) {
                propostaRepository.delete(proposta);
                break;
            }
        }
    }

    public Proposta update(Long idCliente, Long idProposta, Proposta proposta)
            throws EntityNotFoundException, BusinessException {
        List<Proposta> propostas = new PropostaService().findAll(idCliente);
        try {
            for (Proposta p : propostas) {
                if (p.getId() == idProposta) {
                    Proposta propostaAtualizada = propostaRepository.getOne(idProposta);
                    propostaAtualizada.setData(proposta.getData());
                    propostaAtualizada.setDescricao(proposta.getDescricao());
                    propostaAtualizada.setStatus(proposta.getStatus());
                    propostaAtualizada.setValor(proposta.getValor());
                    propostaAtualizada.setCliente(proposta.getCliente());
                    return propostaRepository.save(propostaAtualizada);
                }
            }
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Registro não encontrado.", e);
        }
        return null;
    }

    public Proposta save(Long idCliente, Proposta proposta) throws EntityNotFoundException, BusinessException {
        Cliente cliente = clienteRepository.getOne(idCliente);
        proposta.setCliente(cliente);
        clienteRepository.save(cliente);
        return propostaRepository.save(proposta);
    }

}
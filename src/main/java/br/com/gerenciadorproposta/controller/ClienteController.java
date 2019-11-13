package br.com.gerenciadorproposta.controller;

import br.com.gerenciadorproposta.model.Cliente;
import br.com.gerenciadorproposta.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getAll() {
        return Arrays.asList(new Cliente(1l, "cnpj1", "razao1", "telefone1", "email1")
                ,new Cliente(1l, "cnpj2", "razao2", "telefone2", "email2")
        );
    }
    @GetMapping("/{id}")
    public Cliente findOne(@PathVariable("id") int id){
        Cliente c = new Cliente();
        return new Cliente(1l, "cnpj1", "razao2", "telefone3", "email4");
    }
}

package farm.Controllers;

import farm.repositories.ClienteRepository;
import farm.models.*;

public class ClienteController {
    private ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    public void removeCliente(Cliente cliente){
        this.repository.removeCliente(cliente);
    }

    public void addCliente(Cliente cliente) {
        this.repository.addCliente(cliente);
    }

    public Cliente buscarCliente(String cpf) {
        return this.repository.buscarCliente(cpf);
    }

    public void addCarrinho(Produto produto, Cliente cliente){
        this.repository.addCarrinho(cliente, produto);
    }

    public void removeCarrinho(Produto produto, Cliente cliente){
        this.repository.removeCarrinho(cliente, produto);
    }

    public void mostrarCarrinho(Cliente cliente){
        this.repository.mostrarCarrinho(cliente);
    }

    public void desconto(Cliente cliente){
        this.repository.desconto(cliente);
    }

    public void concluirCompra(Cliente cliente) {
        this.repository.concluirCompra(cliente);
    }

    public void limparCarrinho(Cliente cliente) {
        this.repository.limparCarrinho(cliente);
    }
}

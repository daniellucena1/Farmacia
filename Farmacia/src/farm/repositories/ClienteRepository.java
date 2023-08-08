package farm.repositories;

import farm.models.*;

import java.util.List;
import java.util.ArrayList;

public class ClienteRepository {
    public List<Cliente> clientes = new ArrayList<>();

    public int getPosicaoCliente(String cpf){
        for(int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).getCpf().equals(cpf)){
                return i;
            }
        }
        return -1;
    }

    public Cliente buscarCliente(String cpf) {
        int posicao = getPosicaoCliente(cpf);
        if(posicao != -1){
            return clientes.get(posicao);
        }
        return null;
    }

    public void addCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void removeCliente(Cliente cliente){
        int posicao = getPosicaoCliente(cliente.getCpf());
        if(posicao != -1){
            clientes.remove(posicao);
        } else System.out.println(">> Cliente não existe");
    }

    public void addCarrinho(Cliente cliente, Produto produto){
        int posicao = getPosicaoCliente(cliente.getCpf());
        if(posicao != -1){
            clientes.get(posicao).getCarrinho().addCarrinho(produto);
        }
    }

    public void removeCarrinho(Cliente cliente, Produto produto){
        int posicao = getPosicaoCliente(cliente.getCpf());
        if(posicao != -1){
            clientes.get(posicao).getCarrinho().removeCarrinho(produto);
        }
    }

    public void mostrarCarrinho(Cliente cliente) {
        int posicao = getPosicaoCliente(cliente.getCpf());
        if(posicao != -1){
            clientes.get(posicao).getCarrinho().mostrarCarrinho();
        }
    }

    public void desconto(Cliente cliente) {
        int posicao = getPosicaoCliente(cliente.getCpf());
        if(posicao != -1){
            clientes.get(posicao).getCarrinho().desconto();
        }
    }

    public void concluirCompra(Cliente cliente){
        int posicao = getPosicaoCliente(cliente.getCpf());
        if(posicao != -1){
            clientes.get(posicao).getCarrinho().concluirCompra(cliente);
        }
    }

    public void limparCarrinho(Cliente cliente){
        int posicao = getPosicaoCliente(cliente.getCpf());
        if(posicao != -1) {
            clientes.get(posicao).getCarrinho().limparCarrinho();
        }
    }
}

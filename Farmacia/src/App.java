import farm.models.*;
import farm.repositories.*;
import farm.Controllers.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ClienteController clienteController = new ClienteController(new ClienteRepository());
        ProdutoController produtoController = new ProdutoController(new ProdutoRepository());

        Medicamento ibuprofeno = new Medicamento(10.2, "Ibuprofeno", 2, "12/12/12", new Fornecedor("Genérico"));
        Medicamento dipirona = new Medicamento(13.2, "Dipirona", 2, "12/12/12", new Fornecedor("Genérico"));
        Medicamento alivio = new Medicamento(15.2, "Alívio", 2, "12/12/12", new Fornecedor("Genérico"));
        Medicamento rosuvastatina = new Medicamento(30.2, "Rosuvastatina", 2, "12/12/12", new Fornecedor("Genérico"));
        Medicamento vitaminaA = new Medicamento(9.2, "Vitamina A", 2, "12/12/12", new Fornecedor("Genérico"));

        Cosmeticos shampoo = new Cosmeticos(6.5, "Shampoo", 2, "12/12/12", new Fornecedor("L'Oréal Paris"));
        Cosmeticos fralda = new Cosmeticos(15.5, "Fralda", 6, "12/12/12", new Fornecedor("Pampers"));
        Cosmeticos pomada = new Cosmeticos(3.0, "Pomada", 4, "12/12/12", new Fornecedor("Matte"));
        Cosmeticos desodorante = new Cosmeticos(15.6, "Desodorante", 2, "12/12/12", new Fornecedor("Rexona"));
        Cosmeticos condicionador = new Cosmeticos(5.5, "Condicionador", 5, "12/12/12", new Fornecedor("Eudora"));

        produtoController.addProduto(condicionador);
        produtoController.addProduto(desodorante);
        produtoController.addProduto(pomada);
        produtoController.addProduto(fralda);
        produtoController.addProduto(shampoo);
        produtoController.addProduto(vitaminaA);
        produtoController.addProduto(rosuvastatina);
        produtoController.addProduto(alivio);
        produtoController.addProduto(dipirona);
        produtoController.addProduto(ibuprofeno);

        Scanner sc = new Scanner(System.in);

        int opcao = -1;

        while (opcao != 0) {

            menu();
            System.out.print(">> ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Cpf do cliente: ");
                    String cpf = sc.nextLine();
                    Carrinho novoCarrinho = new Carrinho();
                    Cliente novoCliente = new Cliente(cpf, novoCarrinho);
                    clienteController.addCliente(novoCliente);
                    break;
                case 2:
                    System.out.println(">> Nome do produto");
                    String descricao = sc.nextLine();
                    System.out.println(">> Preço do produto");
                    double preco = Double.parseDouble(sc.nextLine());
                    System.out.println(">> Quantidade de estoque");
                    int estoque = Integer.parseInt(sc.nextLine());
                    System.out.println(">> Forncedor do produto");
                    String fornecedor = sc.nextLine();
                    System.out.println(">> Validade do produto");
                    String validade = sc.nextLine();
                    System.out.println(">> O que você quer cadastrar?");
                    System.out.println(">> 1 - Cosmético");
                    System.out.println(">> 2 - Medicamento");
                    int escolha = Integer.parseInt(sc.nextLine());
                    if (escolha == 1) {
                        Cosmeticos novoProduto = new Cosmeticos(preco, descricao, estoque, validade, new Fornecedor(fornecedor));
                        produtoController.addProduto(novoProduto);
                    } else {
                        Medicamento novoProduto = new Medicamento(preco, descricao, estoque, validade, new Fornecedor(fornecedor));
                        produtoController.addProduto(novoProduto);
                    }
                    break;
                case 3:
                    System.out.print(">> Cpf do cliente: ");
                    String newCpf = sc.nextLine();
                    Cliente cliente = clienteController.buscarCliente(newCpf);

                    if (cliente != null) {
                        System.out.print(">> Produto que o cliente deseja: ");
                        String novaDescricao = sc.nextLine();
                        Produto produto = produtoController.buscarProdutoPorDescricao(novaDescricao);

                        if (produto != null) {
                            clienteController.addCarrinho(produto, cliente);
                        } else
                            System.out.println(">> Produto inexistente");

                    } else
                        System.out.println(">> Cliente inexistente");
                    break;
                case 4:
                    System.out.print(">> Cpf do cliente: ");
                    String Cpf = sc.nextLine();
                    Cliente cCliente = clienteController.buscarCliente(Cpf);

                    if (cCliente != null) {
                        System.out.print(">> Produto que o cliente deseja remover do carrinho: ");
                        String novaDescricao = sc.nextLine();
                        Produto produto = produtoController.buscarProdutoPorDescricao(novaDescricao);

                        if (produto != null) {
                            clienteController.removeCarrinho(produto, cCliente);
                        } else
                            System.out.println(">> Produto inexistente");

                    } else
                        System.out.println(">> Cliente inexistente");
                    break;
                case 5:
                    System.out.print(">> Cpf do cliente: ");
                    String novoCpf = sc.nextLine();
                    Cliente clienteAtual = clienteController.buscarCliente(novoCpf);

                    if(clienteAtual != null) {
                        clienteController.mostrarCarrinho(clienteAtual);
                    } else 
                        System.out.println(">> Cliente inexistente");
                    break;
                case 6:
                    System.out.print(">> Cpf do cliente: ");
                    String cpfAtual = sc.nextLine();
                    Cliente definirCliente = clienteController.buscarCliente(cpfAtual);

                    if(definirCliente != null) {
                        clienteController.concluirCompra(definirCliente);;
                    } else 
                        System.out.println(">> Cliente inexistente");
                    break;
                case 0:
                    sc.close();
                    break;
            }
        }
    }

    public static void menu() {
        System.out.println(">> Escolha uma opcao: \n");
        System.out.println(">> 1 - Cadastrar cliente");
        System.out.println(">> 2 - Cadastrar produto");
        System.out.println(">> 3 - Adicionar produto ao carrinho");
        System.out.println(">> 4 - Remover produto do carrinho");
        System.out.println(">> 5 - Listar carrinho");
        System.out.println(">> 6 - Concluir compra");
        System.out.println(">> 0 - Encerrar");
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarConta {
    private List<Conta> produtos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciarConta ge = new GerenciarConta();
        int opcao = 0;
        do {
            opcao = getMenuPrincipal(scanner, ge);
        } while (opcao != 9);
    }

    private static int getMenuPrincipal(Scanner scanner, GerenciarConta ge) {
        int opcao;
        System.out.println("||  Controle de Contas ||");
        System.out.println("==========================");
        System.out.println("1. Registrar novo Conta");
        System.out.println("2. Depositar ");
        System.out.println("3. Sacar");
        System.out.println("4. Listar Todas as Contas");
        System.out.println("9. Sair");
        System.out.println("Escolha sua opcao: ");
        opcao = Integer.parseInt(scanner.nextLine());
        switch (opcao) {
            case 1:
                ge.cadastrarNovoProduto(scanner);
                break;
            case 2:
                ge.entradaDeProduto(scanner);
                break;
            case 3:
                ge.saidaDeProduto(scanner);
                break;
            case 4:
                ge.listarTodosProdutos();
                break;
            case 9:
                System.out.println("Fim");
                break;
            default:
                System.out.println("Opcao invalida");
        }
        return opcao;
    }

    public void cadastrarNovoProduto(Scanner scanner) {
        Conta produto = new Conta();
        System.out.println("Digite o Numero da conta");
        produto.setIdProd(Integer.parseInt(scanner.nextLine()));
        System.out.println("Digite o nome do titular");
        produto.setNome(scanner.nextLine());
        System.out.println("Conta cadastrada com sucesso");
        produtos.add(produto);
    }

    public void entradaDeProduto(Scanner scanner) {
        System.out.println("Digite  o Numero da conta que deseja Depositar: ");
        int codigo = Integer.parseInt(scanner.nextLine());
        //varrer a lista a procura do produto
        Conta produtoEncontrado = null;
        produtoEncontrado = procurarNaLista(codigo);
        if (produtoEncontrado != null) {
            System.out.println("Digite a quantidade a ser depositada : ");
            int entrada = Integer.parseInt(scanner.nextLine());
            boolean ok = produtoEncontrado.registrarEntrada(entrada);
            if (ok) {
                System.out.println("Deposito efetuado com sucesso");
            } else {
                System.out.println("Valor invalido para Deposito");
            }
            return;
        } else {
            System.out.println("Conta não encontrada ");
        }
    }


    private Conta procurarNaLista(int codigo) {
        for (Conta p : produtos) {
            if (codigo == p.getIdProd()) return p;
        }
        return null;
    }

    public void saidaDeProduto(Scanner scanner) {
        System.out.println("Digite o Numero da Conta ");
        int codigo = Integer.parseInt(scanner.nextLine());
        Conta produtoEncontrado = procurarNaLista(codigo);
        if (produtoEncontrado != null) {
            System.out.println("Digite a quantidade de Saque: ");
            int saida = Integer.parseInt(scanner.nextLine());
            boolean ok = produtoEncontrado.registrarSaida(saida);
            if (ok) {
                System.out.println("Saque efetuado com sucesso");
            } else {

                System.out.println("Quantidade indisponivel");
            }
        } else {
            System.out.println("Conta não encontrada ");
        }
    }

    public void listarTodosProdutos() {
        for (Conta p : produtos) {
            System.out.println(p.toString());
        }
    }

}
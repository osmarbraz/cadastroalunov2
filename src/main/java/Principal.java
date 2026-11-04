
import java.util.Scanner;

public class Principal {

    //Variáveis
    static Scanner leitor = new Scanner(System.in);
    static String nomes[] = new String[100];
    static int idades[] = new int[100];
    static int N = 0;

    public static void menu() {
        System.out.println(">>>>>>>>>>>>>Cadastro de aluno<<<<<<<<<<<");
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Listar alunos");
        System.out.println("3 - Consultar alunos");
        System.out.println("4 - Apagar alunos");
        System.out.println("5 - Alterar alunos");
        System.out.println("9 - Sair");
        System.out.println("Digite um opcao:");
    }

    public static void cadastrar() {
        System.out.println("Cadastrar aluno");
        if (N < 100) {
            System.out.println("Digite o nome do aluno:");
            String nome = leitor.nextLine();
            System.out.println("Digite a idade do aluno:");
            int idade = Integer.parseInt(leitor.nextLine());
            nomes[N] = nome;
            idades[N] = idade;
            N = N + 1;
            System.out.println("Aluno cadastrado com sucesso!");
        } else {
            System.out.println("Cadastro cheio!");
        }
    }

    public static void listarAlunos() {
        System.out.println("Listar aluno");
        for (int i = 0; i < N; i++) {
            System.out.println("Nome:" + nomes[i] + " Idades:" + idades[i]);
        }
    }

    public static void consultarAlunoPorNome() {
        System.out.println("Consultar por nome");
        System.out.println("Digite o nome do aluno a ser pesquisado:");
        String nomePesquisa = leitor.nextLine();
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            if ((nomes[i].equalsIgnoreCase(nomePesquisa)) == true) {
                System.out.println("Achei o aluno com o nome:" + nomes[i] + " e idade " + idades[i]);
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Nenhum aluno encontrado com o nome " + nomePesquisa);
        }
    }

    public static void consultarAlunoPorIdade() {
        System.out.println("Consultar por idade");
        System.out.println("Digite a idade do aluno a ser pesquisado:");
        int idadePesquisa = Integer.parseInt(leitor.nextLine());
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            if ((idades[i] == idadePesquisa) == true) {
                System.out.println("Achei o aluno com o nome:" + nomes[i] + " e idade " + idades[i]);
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Nenhum aluno encontrado com a idade " + idadePesquisa);
        }
    }

    public static void consultarAlunos() {
        //Inicio do submenu 3
        System.out.println("########3 - Consultar aluno########");
        int opcao2;
        do {
            System.out.println("1 - Por nome");
            System.out.println("2 - Por Idade");
            System.out.println("9 - Voltar ao menu principal");
            System.out.println("Digite um opcao:");
            opcao2 = Integer.parseInt(leitor.nextLine());
            switch (opcao2) {
                case 1:
                    consultarAlunoPorNome();
                    break;
                case 2:
                    consultarAlunoPorIdade();
                    break;
                case 9:
                    System.out.println("Saindo da consulta");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao2 != 9);
        //Fim do submenu 3
    }

    public static void excluirAlunos() {
        System.out.println("Excluindo Aluno");
        System.out.println("Digite o nome do aluno a ser pesquisado para excluir:");
        String nomePesquisa = leitor.nextLine();
        int posicaoExcluir = -1;
        for (int i = 0; i < N; i++) {
            if ((nomes[i].equalsIgnoreCase(nomePesquisa)) == true) {
                posicaoExcluir = i;
            }
        }
        if (posicaoExcluir != -1) {
            //Preenche a posição a ser excluida com o o próximo do vetor
            for (int i = posicaoExcluir; i < N - 1; i++) {
                nomes[i] = nomes[i + 1];
                idades[i] = idades[i + 1];
            }
            //]decrementa a quantidade de alunos no vetor
            N = N - 1;
            System.out.println("Exclusao de aluno realizada com sucesso.");
        } else {
            System.out.println("Nenhum aluno encontrado com o nome " + nomePesquisa + " para excluir");
        }
    }

    public static void alterarAlunos() {
        System.out.println("Alterando aluno");
        System.out.println("Digite o nome do aluno a ser pesquisado para alterar:");
        String nomePesquisa = leitor.nextLine();
        int posicaoAlterar = -1;
        for (int i = 0; i < N; i++) {
            if ((nomes[i].equalsIgnoreCase(nomePesquisa)) == true) {
                posicaoAlterar = i;
            }
        }
        if (posicaoAlterar != -1) {
            System.out.println("Digite o nome do aluno para alterar:");
            String nome = leitor.nextLine();
            System.out.println("Digite a idade do aluno para alterar:");
            int idade = Integer.parseInt(leitor.nextLine());
            nomes[posicaoAlterar] = nome;
            idades[posicaoAlterar] = idade;
            System.out.println("Alteracao de aluno realizada com sucesso.");
        } else {
            System.out.println("Nenhum aluno encontrado com o nome " + nomePesquisa + " para alterar");
        }
    }

    public static void main(String[] args) {
        //Menu
        int opcao1;
        do {
            menu();
            opcao1 = Integer.parseInt(leitor.nextLine());
            switch (opcao1) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 3:
                    consultarAlunos();
                    break;
                case 4:
                    excluirAlunos();
                    break;
                case 5:
                    alterarAlunos();
                    break;
                case 9:
                    System.out.println("Saindo do programa");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao1 != 9);
    }
}

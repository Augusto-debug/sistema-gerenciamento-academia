package prova01_AugustoCesarRezende.Aplicacao;

import prova01_AugustoCesarRezende.Academia.Academia;
import prova01_AugustoCesarRezende.Academia.Utilitaria;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();
        List<String[]> funcionarios = List.of(
                new String[]{"user1", "pass1"},
                new String[]{"user2", "pass2"},
                new String[]{"user3", "pass3"}
        );
        Academia academia = new Academia();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("M E N U\n1- ACADEMIA\n2- PERSONAL\n3- SAIR\nDIGITE A OPÇÃO: ___");
            opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao == 1) {
                if (validaFuncionario(scanner, funcionarios)) {
                    exibeSubMenu(scanner, alunos, academia);
                }
            } else if (opcao == 2) {
                if (validaFuncionario(scanner, funcionarios)) {
                    System.out.println("Digite o código do aluno:");
                    String codigo = scanner.nextLine();
                    Aluno aluno = alunos.stream().filter(a -> a.getCodigo().equals(codigo)).findFirst().orElse(null);
                    if (aluno == null) {
                        System.out.println("Aluno não cadastrado.");
                    } else if (aluno.getAcessos() >= aluno.getCategoria() * 2) {
                        System.out.println("Limite de acessos atingido.");
                    } else {
                        aluno.incrementaAcessos();
                        Academia.incrementaAcessos(aluno.getCategoria());
                        System.out.println("Acesso contabilizado.");
                    }
                }
            } else if (opcao != 3) {
                System.out.println("Opção inválida.");
            }
        } while (opcao != 3);
        System.out.println("Saindo...");
    }

    private static boolean validaFuncionario(Scanner scanner, List<String[]> funcionarios) {
        for (int i = 0; i < 3; i++) {
            System.out.println("Digite o usuário:");
            String usuario = scanner.nextLine();
            System.out.println("Digite a senha:");
            String senha = scanner.nextLine();
            if (funcionarios.stream().anyMatch(f -> f[0].equals(usuario) && f[1].equals(senha))) {
                return true;
            }
            System.out.println("Usuário ou senha inválidos. Tentativas restantes: " + (2 - i));
        }
        System.out.println("Número de tentativas esgotou. Encerrando...");
        return false;
    }

    private static void exibeSubMenu(Scanner scanner, List<Aluno> alunos, Academia academia) {
        int subOpcao;
        do {
            System.out.println("S u b M E N U\n1- CADASTRO\n2- RELATÓRIO\n3- VOLTAR\nDIGITE A OPÇÃO: ___");
            subOpcao = scanner.nextInt();
            scanner.nextLine();
            if (subOpcao == 1) {
                System.out.println("Digite o nome do aluno:");
                String nome = scanner.nextLine();
                System.out.println("Digite o telefone do aluno:");
                String telefone = scanner.nextLine();
                System.out.println("Digite a categoria do aluno (1, 2, 3):");
                int categoria = scanner.nextInt();
                scanner.nextLine();
                if (categoria == 2 || categoria == 3) {
                    Academia.incrementaAcessos(categoria);
                } else if (!Utilitaria.validaTel(telefone)) {
                    System.out.println("Telefone inválido.");
                } else if (categoria < 1 || categoria > 3) {
                    System.out.println("Categoria inválida.");
                } else if (alunos.stream().anyMatch(a -> a.getNome().equals(nome))) {
                    System.out.println("Aluno já cadastrado.");
                } else {
                    String codigo = Utilitaria.geraCodigo();
                    Aluno aluno = new Aluno(codigo, nome, telefone, categoria);
                    alunos.add(aluno);
                    System.out.println("Aluno cadastrado com sucesso!");
                }
            } else if (subOpcao == 2) {
                System.out.println("RELATÓRIO");
                for (Aluno aluno : alunos) {
                    System.out.println("Código: " + aluno.getCodigo());
                    System.out.println("Nome: " + aluno.getNome());
                    System.out.println("Telefone: " + aluno.getTelefone());
                    System.out.println("Categoria: " + aluno.getCategoria());
                    System.out.println("Acessos: " + aluno.getAcessos());
                }
                System.out.println("TOTAL DE ALUNOS = " + alunos.size());
                System.out.println("ACESSOS = " + Academia.getAcessos());
            }
        } while (subOpcao != 3);
    }
    }

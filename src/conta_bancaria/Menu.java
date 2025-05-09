package conta_bancaria;

import java.util.Scanner;
import conta_bancaria.util.*;
import conta_bancaria.controller.contaController;
import conta_bancaria.model.contaCorrente;
import conta_bancaria.model.contaPoupanca;
import conta_bancaria.util.BancoExceptions;

public class Menu {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        contaController contas = new contaController();
        
        int opcao, numero, agencia, tipo, aniversario, numeroDestino;
        String titular;
        float saldo, limite, valor;
        
        // Contas de teste
        contaCorrente cc1 = new contaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);
        contas.cadastrar(cc1);
        contaPoupanca cp1 = new contaPoupanca(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);
        contas.cadastrar(cp1);
        
        while(true) {
            exibirCabecalho();
            exibirMenuPrincipal();
            
            opcao = BancoExceptions.lerInteiro(leia);
            
            if (opcao == 10) {
                System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco Beth 82 - O seu Futuro começa aqui!");
                sobre();
                leia.close();
                System.exit(0);
            }
            
            processarOpcao(opcao, contas, leia);
        }
    }

    private static void exibirCabecalho() {
        System.out.println(Cores.TEXT_YELLOW_BRIGHT + Cores.ANSI_CYAN_BACKGROUND);
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║                                                  ║");
        System.out.println("║           $$$ BANCO Turma Java 82 $$$            ║");
        System.out.println("║                                                  ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        System.out.println(Cores.TEXT_RESET);
    }

    private static void exibirMenuPrincipal() {
        System.out.println(Cores.TEXT_PURPLE_BOLD + "╔══════════════════════════════════════════════════╗");
        System.out.println("║               MENU PRINCIPAL                     ║");
        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.println("║ " + Cores.TEXT_YELLOW + "1. " + Cores.TEXT_RESET + "Criar Conta                                   ║");
        System.out.println("║ " + Cores.TEXT_YELLOW + "2. " + Cores.TEXT_RESET + "Listar todas as Contas                        ║");
        System.out.println("║ " + Cores.TEXT_YELLOW + "3. " + Cores.TEXT_RESET + "Buscar Conta por Número                       ║");
        System.out.println("║ " + Cores.TEXT_YELLOW + "4. " + Cores.TEXT_RESET + "Atualizar Dados da Conta                      ║");
        System.out.println("║ " + Cores.TEXT_YELLOW + "5. " + Cores.TEXT_RESET + "Apagar Conta                                  ║");
        System.out.println("║ " + Cores.TEXT_YELLOW + "6. " + Cores.TEXT_RESET + "Sacar                                         ║");
        System.out.println("║ " + Cores.TEXT_YELLOW + "7. " + Cores.TEXT_RESET + "Depositar                                     ║");
        System.out.println("║ " + Cores.TEXT_YELLOW + "8. " + Cores.TEXT_RESET + "Transferir entre Contas                       ║");
        System.out.println("║ " + Cores.TEXT_YELLOW + "9. " + Cores.TEXT_RESET + "Buscar por Nome                               ║");
        System.out.println("║ " + Cores.TEXT_RED + "10. " + Cores.TEXT_RESET + "Sair                                         ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        System.out.print(Cores.TEXT_YELLOW + "\nDigite uma opção: " + Cores.TEXT_RESET);
    }

    private static void processarOpcao(int opcao, contaController contas, Scanner leia) {
        switch (opcao) {
            case 1:
                criarConta(contas, leia);
                break;
            case 2:
                listarContas(contas);
                break;
            case 3:
                buscarPorNumero(contas, leia);
                break;
            case 4:
                atualizarConta(contas, leia);
                break;
            case 5:
                apagarConta(contas, leia);
                break;
            case 6:
                sacar(contas, leia);
                break;
            case 7:
                depositar(contas, leia);
                break;
            case 8:
                transferir(contas, leia);
                break;
            case 9:
                buscarPorNome(contas, leia);
                break;
            default:
                System.out.println(Cores.TEXT_RED_BACKGROUND + Cores.TEXT_WHITE_BOLD + "\nOpção Inválida! Por favor, escolha uma opção entre 1 e 10." + Cores.TEXT_RESET);
                BancoExceptions.keyPress();
                break;
        }
    }

    private static void criarConta(contaController contas, Scanner leia) {
        System.out.println(Cores.TEXT_GREEN_BOLD + "\n╔══════════════════════════════════════════════════╗");
        System.out.println("║                CRIAR NOVA CONTA                ║");
        System.out.println("╚══════════════════════════════════════════════════╝" + Cores.TEXT_RESET);
        
        System.out.print("Digite o número da agência: ");
        int agencia = BancoExceptions.lerInteiro(leia);
        
        System.out.print("Digite o nome do titular: ");
        leia.skip("\\R");
        String titular = leia.nextLine();
        
        System.out.print("Digite o tipo da conta (1 - CC | 2 - CP): ");
        int tipo = BancoExceptions.lerInteiro(leia);
        
        System.out.print("Digite o saldo inicial da conta: ");
        float saldo = BancoExceptions.lerFloat(leia);
        
        if (tipo == 1) {
            System.out.print("Digite o limite da conta corrente: ");
            float limite = BancoExceptions.lerFloat(leia);
            contas.cadastrar(new contaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
        } else {
            System.out.print("Digite o dia do aniversário da poupança: ");
            int aniversario = BancoExceptions.lerInteiro(leia);
            contas.cadastrar(new contaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
        }
        
        System.out.println(Cores.TEXT_GREEN_BACKGROUND + Cores.TEXT_BLACK_BOLD + "\nConta criada com sucesso!" + Cores.TEXT_RESET);
        BancoExceptions.keyPress();
    }

    private static void listarContas(contaController contas) {
        System.out.println(Cores.TEXT_BLUE_BOLD + "\n╔══════════════════════════════════════════════════╗");
        System.out.println("║             LISTA DE TODAS AS CONTAS             ║");
        System.out.println("╚══════════════════════════════════════════════════╝" + Cores.TEXT_RESET);
        contas.listarTodas();
        BancoExceptions.keyPress();
    }

    private static void buscarPorNumero(contaController contas, Scanner leia) {
        System.out.println(Cores.TEXT_BLUE_BOLD + "\n╔══════════════════════════════════════════════════╗");
        System.out.println("║             BUSCAR CONTA POR NÚMERO             ║");
        System.out.println("╚══════════════════════════════════════════════════╝" + Cores.TEXT_RESET);
        
        System.out.print("Digite o número da conta: ");
        int numero = BancoExceptions.lerInteiro(leia);
        contas.procurarPorNumero(numero);
        BancoExceptions.keyPress();
    }

    private static void atualizarConta(contaController contas, Scanner leia) {
        System.out.println(Cores.TEXT_PURPLE_BOLD + "\n╔══════════════════════════════════════════════════╗");
        System.out.println("║             ATUALIZAR DADOS DA CONTA            ║");
        System.out.println("╚══════════════════════════════════════════════════╝" + Cores.TEXT_RESET);
        
        System.out.print("Digite o número da conta: ");
        int numero = BancoExceptions.lerInteiro(leia);
        contas.procurarPorNumero(numero);
        
        System.out.print("\nDeseja atualizar essa conta? (s/n): ");
        String atualizarSim = leia.next();
        
        if (atualizarSim.equalsIgnoreCase("s")) {
            System.out.print("Digite o número da agência: ");
            int agencia = BancoExceptions.lerInteiro(leia);
            
            System.out.print("Digite o nome do titular: ");
            leia.skip("\\R");
            String titular = leia.nextLine();
            
            System.out.print("Digite o tipo da conta (1 - CC | 2 - CP): ");
            int tipo = BancoExceptions.lerInteiro(leia);
            
            System.out.print("Digite o saldo da conta: ");
            float saldo = BancoExceptions.lerFloat(leia);
            
            if (tipo == 1) {
                System.out.print("Digite o limite da conta corrente: ");
                float limite = BancoExceptions.lerFloat(leia);
                contas.atualizar(new contaCorrente(numero, agencia, tipo, titular, saldo, limite));
            } else {
                System.out.print("Digite o dia do aniversário da poupança: ");
                int aniversario = BancoExceptions.lerInteiro(leia);
                contas.atualizar(new contaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
            }
            
            System.out.println(Cores.TEXT_GREEN_BACKGROUND + Cores.TEXT_BLACK_BOLD + "\nConta atualizada com sucesso!" + Cores.TEXT_RESET);
        } else {
            System.out.println(Cores.TEXT_YELLOW_BACKGROUND + Cores.TEXT_BLACK_BOLD + "\nOperação cancelada." + Cores.TEXT_RESET);
        }
        BancoExceptions.keyPress();
    }

    private static void apagarConta(contaController contas, Scanner leia) {
        System.out.println(Cores.TEXT_RED_BOLD + "\n╔══════════════════════════════════════════════════╗");
        System.out.println("║                 APAGAR CONTA                  ║");
        System.out.println("╚══════════════════════════════════════════════════╝" + Cores.TEXT_RESET);
        
        System.out.print("Digite o número da conta que deseja apagar: ");
        int numero = BancoExceptions.lerInteiro(leia);
        contas.deletar(numero);
        BancoExceptions.keyPress();
    }

    private static void sacar(contaController contas, Scanner leia) {
        System.out.println(Cores.TEXT_ORANGE_BOLD + "\n╔══════════════════════════════════════════════════╗");
        System.out.println("║                     SACAR                     ║");
        System.out.println("╚══════════════════════════════════════════════════╝" + Cores.TEXT_RESET);
        
        System.out.print("Digite o número da conta: ");
        int numero = BancoExceptions.lerInteiro(leia);
        
        System.out.print("Digite o valor que deseja sacar: ");
        float valor = BancoExceptions.lerFloat(leia);
        
        if (valor >= 0) {
            contas.sacar(numero, valor);
        } else {
            System.out.println(Cores.TEXT_RED_BACKGROUND + Cores.TEXT_WHITE_BOLD + "\nValor inválido para saque!" + Cores.TEXT_RESET);
        }
        BancoExceptions.keyPress();
    }

    private static void depositar(contaController contas, Scanner leia) {
        System.out.println(Cores.TEXT_GREEN_BOLD + "\n╔══════════════════════════════════════════════════╗");
        System.out.println("║                   DEPOSITAR                   ║");
        System.out.println("╚══════════════════════════════════════════════════╝" + Cores.TEXT_RESET);
        
        System.out.print("Digite o número da conta: ");
        int numero = BancoExceptions.lerInteiro(leia);
        
        float valor;
        do {
            System.out.print("Digite o valor do depósito: ");
            valor = BancoExceptions.lerFloat(leia);
        } while (valor <= 0);
        
        contas.depositar(numero, valor);
        BancoExceptions.keyPress();
    }

    private static void transferir(contaController contas, Scanner leia) {
        System.out.println(Cores.TEXT_CYAN_BOLD + "\n╔══════════════════════════════════════════════════╗");
        System.out.println("║                  TRANSFERIR                   ║");
        System.out.println("╚══════════════════════════════════════════════════╝" + Cores.TEXT_RESET);
        
        System.out.print("Digite o número da conta origem: ");
        int numero = BancoExceptions.lerInteiro(leia);
        
        System.out.print("Digite o número da conta destino: ");
        int numeroDestino = BancoExceptions.lerInteiro(leia);
        
        float valor;
        do {
            System.out.print("Digite o valor da transferência: ");
            valor = BancoExceptions.lerFloat(leia);
        } while (valor <= 0);
        
        contas.transferir(numero, numeroDestino, valor);
        BancoExceptions.keyPress();
    }

    private static void buscarPorNome(contaController contas, Scanner leia) {
        System.out.println(Cores.TEXT_BLUE_BOLD + "\n╔══════════════════════════════════════════════════╗");
        System.out.println("║             BUSCAR CONTA POR NOME              ║");
        System.out.println("╚══════════════════════════════════════════════════╝" + Cores.TEXT_RESET);
        
        System.out.print("Digite o nome do titular: ");
        leia.skip("\\R");
        String titular = leia.nextLine();
        
        contas.listarPortitular(titular);
        BancoExceptions.keyPress();
    }

    public static void sobre() {
        System.out.println(Cores.TEXT_CYAN_BACKGROUND + Cores.TEXT_BLACK_BOLD);
        System.out.println("\n*****************************************************");
        System.out.println("*               BANCO BETH 82                       *");
        System.out.println("*                                                   *");
        System.out.println("*    Projeto Desenvolvido por:                      *");
        System.out.println("*    Carlos Moroni Garcia                           *");
        System.out.println("*    carlosmoronisud@gmail.com                     *");
        System.out.println("*    https://github.com/carlosmoronisud            *");
        System.out.println("*                                                   *");
        System.out.println("*****************************************************");
        System.out.println(Cores.TEXT_RESET);
    }
}
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
		
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
		
		//Contas de teste
		contaCorrente cc1 = new contaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);
		contas.cadastrar(cc1);
		contaPoupanca cp1 = new contaPoupanca(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);
		contas.cadastrar(cp1);
		
		
				
		while(true) {

			System.out.println(Cores.TEXT_YELLOW_BRIGHT+ Cores.ANSI_CYAN_BACKGROUND
					+ "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("$                                                   $" + Cores.TEXT_YELLOW_BRIGHT + Cores.ANSI_CYAN_BACKGROUND);
			System.out.println("$                $$$ Banco Beth 82 $$$              $");  
			System.out.println("$                                                   $");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" + Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND);
			System.out.println("                                                     ");
			System.out.println("===========[   ** Menu Interativo **     ]===========");  
			System.out.println("                                                     ");
			System.out.println("            1 -> Criar Conta                         ");
			System.out.println("            2 -> Listar todas as Contas              ");
			System.out.println("            3 -> Buscar Conta por Numero             ");
			System.out.println("            4 -> Atualizar Dados da Conta            ");
			System.out.println("            5 -> Apagar Conta                        ");
			System.out.println("            6 -> Sacar                               ");
			System.out.println("            7 -> Depositar                           ");
			System.out.println("            8 -> Transferir valores entre Cntas      ");
			System.out.println("            9 -> Sair                                ");
			System.out.println("                                                     ");
			System.out.println("=========[                                       ]===");
			System.out.println("                                                     ");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");
			System.out.println("=====================================================" + Cores.TEXT_RESET);
			
			
			opcao = BancoExceptions.lerInteiro(leia);
			
			
				
			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco Beth 82 - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}
				
			switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_WHITE + " 1 -> Criar Conta \n\n");
					
					System.out.println("Digite o número da agência: ");
					agencia = BancoExceptions.lerInteiro(leia);
					
					System.out.println("Digite o nome do titular:  ");
					leia.skip("\\R");
					titular = leia.nextLine();
					
					System.out.println("Digite o tipo da conta (1 - cc | 2 - CP:: ");
					tipo = BancoExceptions.lerInteiro(leia);
					
					System.out.println("Digite o saldo inicial da conta: ");
					saldo = BancoExceptions.lerInteiro(leia);
					
					switch(tipo) {
						case 1 ->{
									System.out.println("Digite o limite da conta: ");
									limite = BancoExceptions.lerFloat(leia);
									contas.cadastrar(new contaCorrente(contas.gerarNumero(),agencia, tipo, titular, saldo, limite));
								}
						case 2 ->{
									System.out.println("Digite o dia do aniversário da conta: ");
									aniversario =  BancoExceptions.lerInteiro(leia);
									contas.cadastrar(new contaCorrente(contas.gerarNumero(),agencia, tipo, titular, saldo, aniversario));
						}
					}						
					BancoExceptions.keyPress();               		
					break;
				case 2:
					System.out.println(Cores.TEXT_WHITE + "2 -> Listar todas as Contas \n\n");
					contas.listarTodas();
					BancoExceptions.keyPress();
                    		break;
				case 3:
					System.out.println(Cores.TEXT_WHITE + "3 -> Buscar Conta por Numero\n\n");
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
					
					contas.procurarPorNumero(numero);
					
					BancoExceptions.keyPress();
                    		break;
				case 4:
					System.out.println(Cores.TEXT_WHITE + "4 -> Atualizar Dados da Conta\n\n");
					BancoExceptions.keyPress();
                    		break;
				case 5:
					System.out.println(Cores.TEXT_WHITE + "5 -> Apagar Conta\n\n");
					BancoExceptions.keyPress(); 
                   	 	break;
				case 6:
					System.out.println(Cores.TEXT_WHITE + "6 -> Sacar\n\n");
					BancoExceptions.keyPress();
                   	 	break;
				case 7:
					System.out.println(Cores.TEXT_WHITE + "7 -> Depositar\n\n");
					BancoExceptions.keyPress(); 
                    		break;
				case 8:
					System.out.println(Cores.TEXT_WHITE + "8 -> Transferir valores entre Contas \n\n");
					BancoExceptions.keyPress();
                    		break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
					BancoExceptions.keyPress(); 
                    		break;
			}
		}	
    }

    public static void sobre() {
	System.out.println("\n*********************************************************");
	System.out.println("Projeto Desenvolvido por: ");
	System.out.println("Carlos Moroni Garcia - carlosmoronisud@gmail.com");
	System.out.println("https://github.com/carlosmoronisud");
	System.out.println("*********************************************************");
   }
   
}

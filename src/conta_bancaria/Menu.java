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
			System.out.println("            9 -> Buscar por nome                     ");
			System.out.println("            10 -> Sair                               ");
			System.out.println("                                                     ");
			System.out.println("=========[                                       ]===");
			System.out.println("                                                     ");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");
			System.out.println("=====================================================" + Cores.TEXT_RESET);
			
			
			opcao = BancoExceptions.lerInteiro(leia);
			
			
				
			if (opcao == 10) {
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
					//Buscar a conta
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
					contas.procurarPorNumero(numero);
					System.out.println("Deseja atualizar essa conta? (s/n)");
					String atualizarSim = leia.next();
					if (atualizarSim.equalsIgnoreCase("s")) {						
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
										contas.atualizar(new contaCorrente(numero, agencia, tipo, titular, saldo, limite));
									}
							case 2 ->{
										System.out.println("Digite o dia do aniversário da conta: ");
										aniversario =  BancoExceptions.lerInteiro(leia);
										contas.atualizar(new contaCorrente(numero, agencia, tipo, titular, saldo, aniversario));
							}						
						}						
					}
					
					
					BancoExceptions.keyPress();
                    		break;
				case 5:
					System.out.println(Cores.TEXT_WHITE + "5 -> Apagar Conta\n\n");
					System.out.println("Digite o número da conta que deseja apagar: ");
					numero = leia.nextInt();					
					contas.deletar(numero);
					
					
					BancoExceptions.keyPress(); 
                   	 	break;
				case 6:
					System.out.println(Cores.TEXT_WHITE + "6 -> Sacar\n\n");
					
					System.out.println("Digite o valor que deseja sacar: ");
					valor = leia.nextFloat();
					
					System.out.println(Cores.TEXT_WHITE + "Digite o número da conta\n\n");					
					numero = leia.nextInt();		
					
					if( valor >= 0) {						
						contas.sacar(numero, valor);
						
					}				
					
					
					BancoExceptions.keyPress();
                   	 	break;
				case 7:
					System.out.println(Cores.TEXT_WHITE + "7 -> Depositar\n\n");
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
					do{
						System.out.println("Digite o valor do depósito: ");
						valor = leia.nextFloat();
					}while(valor <= 0);
					
					contas.depositar(numero, valor);
					
					
					BancoExceptions.keyPress(); 
                    		break;
				case 8:
					System.out.println(Cores.TEXT_WHITE + "8 -> Transferir valores entre Contas \n\n");
					System.out.println("Digite o número da conta origem:");
					numero = leia.nextInt();
					System.out.println("Digite o numero da conta destino:  ");
					numeroDestino = leia.nextInt();
					
					do {
						System.out.println("Digite o valor da transferência: ");
						valor = leia.nextFloat();
					}while(valor<=0);
					
					contas.transferir(numero, numeroDestino, valor);
					
					
					BancoExceptions.keyPress();
                    		break;
				case 9:
					System.out.println(Cores.TEXT_WHITE + "9 -> Consultar por nome \n\n");
					System.out.println(Cores.TEXT_WHITE + " Digite o nome do titular \n\n");
					leia.skip("//R");
					titular = leia.nextLine();
					
					contas.listarPortitular(titular);
					
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

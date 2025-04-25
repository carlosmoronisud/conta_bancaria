package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.util.Cores;

public class Menu {
    public static void main(String[] args) {
        
        Scanner leia = new Scanner(System.in);
		
		int opcao;
		
		Conta c1 = new Conta(1, 123, 1, " Aylla", 500000);
		
		c1.sacar(100);
		c1.depositar(1000);
		c1.setTitular("Carlos Moroni");
		c1.visualizar();
		
				
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
			
			opcao = leia.nextInt();
				
			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco Beth 82 - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}
				
			switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_WHITE + " 1 -> Criar Conta \n\n");
				
                    		break;
				case 2:
					System.out.println(Cores.TEXT_WHITE + "2 -> Listar todas as Contas \n\n");
					
                    		break;
				case 3:
					System.out.println(Cores.TEXT_WHITE + "3 -> Buscar Conta por Numero\n\n");
	
                    		break;
				case 4:
					System.out.println(Cores.TEXT_WHITE + "4 -> Atualizar Dados da Conta\n\n");
					
                    		break;
				case 5:
					System.out.println(Cores.TEXT_WHITE + "5 -> Apagar Conta\n\n");
		
                   	 	break;
				case 6:
					System.out.println(Cores.TEXT_WHITE + "6 -> Sacar\n\n");

                   	 	break;
				case 7:
					System.out.println(Cores.TEXT_WHITE + "7 -> Depositar\n\n");
					
                    		break;
				case 8:
					System.out.println(Cores.TEXT_WHITE + "8 -> Transferir valores entre Contas \n\n");
					
                    		break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
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

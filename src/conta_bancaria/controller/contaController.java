package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;


import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;


public class contaController  implements ContaRepository{
	
	 Scanner leia = new Scanner(System.in);

	// Criar  a colection array list
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	
	//Variável de controle dos números de conta
	int numero = 0;
	
	
	@Override
	public void procurarPorNumero(int numero) {
		Optional <Conta> conta = buscarNaCollection(numero);		
		if(conta.isPresent())
			conta.get().visualizar();
		else
			System.out.printf("\nA conta %d não foi encontrada", numero );
		
	}
	@Override
	public void listarPortitular(String titular) {
		// TODO Auto-generated method stub
		List<Conta> listaTitulares = listaContas.stream()
				.filter(c -> c.getTitular().contains(titular.toUpperCase())).collect(Collectors.toList());
		
		if(listaTitulares.isEmpty()) {
			System.out.println("Nenhuma conta foi encontrada com base no criterio:"+ titular);
		}
		listaTitulares.forEach(conta -> conta.visualizar());
		
	}
	
	
	@Override
	public void listarTodas() {
		// TODO Auto-generated method stub
		for(var conta : listaContas) {
			conta.visualizar();
		}
		
	}
	@Override
	public void cadastrar(Conta conta) {
		// TODO Auto-generated method stub
		listaContas.add(conta);
		System.out.println("A conta foi criada!");
	}
	@Override
	public void atualizar(Conta conta) {
		Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());
		
		if(buscaConta.isPresent()) {
			listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
			System.out.println("Conta atualizada com sucesso!");
		}
	}

	@Override
	public void deletar(int numero) {
		Optional <Conta> conta = buscarNaCollection(numero);
		if(conta.isPresent()) {
			conta.get().visualizar();
			System.out.println("Deseja apagar essa conta? (s/n)");
			String deletaSim = leia.next();
			if(deletaSim.equalsIgnoreCase("s") && conta.isPresent()) {
				listaContas.remove(conta.get());
				System.out.println("Conta apagada com sucesso!");
			}
		}else {
			System.out.printf("\nA conta %d não foi encontrada", numero );			
		}
		
	}

	@Override
	public void sacar(int numero, float valor) {
		Optional <Conta> conta = buscarNaCollection(numero);
		conta.get().visualizar();
			if(conta.isPresent()) {
				if(conta.get().sacar(valor)){
					System.out.println("Saque realizado com sucesso");
				}else {
					System.out.printf("\nA conta %d não foi encontrada", numero );
			}							
		}		
	}

	@Override
	public void depositar(int depositar, int numeroDestino, int numero, float valor) {
		Optional <Conta> conta = buscarNaCollection(numero);
		if (conta.isPresent()) {
			conta.get().depositar(valor);
			System.out.println("O depósito foi realizado com sucesso!");
			
		}else {
			System.out.println("Conta não encontrado");
		}
		
		
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		Optional <Conta> contaOrigem = buscarNaCollection(numeroOrigem);
		Optional <Conta> contaDestino = buscarNaCollection(numeroDestino);
		
		if (contaOrigem.isPresent() && contaDestino.isPresent()){
			contaDestino.get().depositar(valor);
			System.out.println("Tranferência efetuada com sucesso!");
		}else {
			System.out.println("Conta não encontrada!");
		}
		
	}
	
	// Métodos Auxiliares
	
	public int gerarNumero() {
		return ++ numero;
	}
	public Optional <Conta> buscarNaCollection(int numero) {
		for(var conta : listaContas) {
			if(conta.getNumero() == numero)
				return Optional.of(conta);
		}
		return Optional.empty();
	}
	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}
	

	

}

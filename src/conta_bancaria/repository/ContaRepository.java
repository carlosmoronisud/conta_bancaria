package conta_bancaria.repository;

import conta_bancaria.model.Conta;

public interface ContaRepository {
	
	//Métodos do CRUD (Create, Read, Update e Delete)
	
	public void procurarPorNumero(int numero);
	public void listarTodas();
	public void cadastrar(Conta conta);
	public void atualizar(Conta conta);
	public void deletar(int numero);
	
	// Métodos Bancários
	public void sacar(int numero, float valor);
	public void depositar(int numero, float valor);
	void transferir(int numeroOrigem, int numeroDestino, float valor);
	void depositar(int numeroOrigem, int numeroDestino, int numero, float valor);
	void listarPortitular(String titular);
}
package conta_bancaria.model;

import java.text.NumberFormat;

public class contaCorrente extends Conta {
	
	
	private float limite;

	public contaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	@Override
	//Sacar
	public boolean sacar(float valor) {
		if (this.getSaldo() + limite <  valor) {
			System.out.println("\n Saldo insuficiente!");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	@Override
	public void visualizar() {
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		super.visualizar();
		System.out.println("Limite da conta:  " + nfMoeda.format(this.limite));
	}
}

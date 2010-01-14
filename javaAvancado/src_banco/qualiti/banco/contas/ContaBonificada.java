package qualiti.banco.contas;

import qualiti.banco.clientes.Cliente;

/**
 * Classe b�sica que representa uma entidade conta bonificada, com seus dados, valida��es
 * dos mesmos e suas opera��es relacionadas. A super-classe cont�m muitos dos atributos
 * e opera��es de uma conta. A conta bonificada se caracteriza por ter um b�nus
 * a ela associado, calculado em fun��o dos valores creditados. Atrav�s de uma opera��o
 * espec�fica, � poss�vel incorporar o b�nus acumulado ao saldo atual da conta. 
 * 
 * @author Qualiti <a href="mailto:qualiti@qualiti.com.br">qualiti@qualiti.com.br</a>
 *
 * @version 1.0 
 *
 * @see qualiti.banco.conta.Conta
 */
public class ContaBonificada extends Conta {

	/**
	 * O valor do b�nus.
	 */
	private double bonus;

	/**
	 * O construtor da classe. Inicializa os atributos com os valores passados como
	 * par�metro chamando o construtor da super-classe.
	 * 
	 * @param num o n�mero da conta.
	 * @param cli o cliente da conta.  
	 */
	public ContaBonificada(String numeroConta, Cliente c) {
		super(numeroConta, c);
	}
	/**
	 * O construtor da classe. Inicializa os atributos com os valores passados como
	 * par�metro chamando o construtor da super-classe.
	 * 
	 * @param num o n�mero da conta.
	 * @param sld o saldo inicial da conta. 
	 * @param cli o cliente da conta.  
	 */
	public ContaBonificada(String numeroConta, double saldo, Cliente c) {
		super(numeroConta, saldo, c);
	}

	/**
	 * Sobrescrita do m�todo creditar() da super-classe. Credita 1% do valor
	 * a ser creditado ao b�nus e chama o m�todo creditar() da super-classe.
	 * 
	 * @param valor o valor a ser creditado.
	 */
	public void creditar(double valor) {

		bonus = bonus + valor * 0.01;
		super.creditar(valor);
	}
	/**
	 * Incorpora o valor atual do b�nus ao saldo da conta. Usa o m�todo creditar()
	 * da super-classe para realizar o cr�dito do b�nus e zera o valor do b�nus.
	 */
	public void renderBonus() {
		super.creditar(bonus);
		bonus = 0;
	}
	/**
	 * Retorna o valor do b�nus.
	 * 
	 * @return double o valor do b�nus.
	 */
	public double getBonus() {

		return bonus;
	}
}
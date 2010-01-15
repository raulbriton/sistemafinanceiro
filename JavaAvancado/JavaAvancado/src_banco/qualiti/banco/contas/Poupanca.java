package qualiti.banco.contas;

import qualiti.banco.clientes.Cliente;

/**
 * Classe b�sica que representa uma entidade poupan�a, com seus dados, valida��es
 * dos mesmos e suas opera��es relacionadas. A super-classe cont�m muitos dos atributos
 * e opera��es de uma conta. A poupan�a se caracteriza por ter uma opera��o de render
 * juros, calculados em cima de uma dada taxa informada no ato desta opera��o.
 * 
 * @author Qualiti <a href="mailto:qualiti@qualiti.com.br">qualiti@qualiti.com.br</a>
 *
 * @version 1.0
 *
 * @see qualiti.banco.conta.Conta
 */
public class Poupanca extends Conta {

	/**
	 * O construtor da classe. Inicializa os atributos com os valores passados como
	 * par�metro chamando o construtor da super-classe.
	 * 
	 * @param num o n�mero da conta.
	 * @param cli o cliente da conta.  
	 */
	public Poupanca(String num, Cliente cli) {

		super(num, cli);
	}
	/**
	 * O construtor da classe. Inicializa os atributos com os valores passados como
	 * par�metro chamando o construtor da super-classe.
	 * 
	 * @param num o n�mero da conta.
	 * @param sld o saldo inicial da conta. 
	 * @param cli o cliente da conta.  
	 */
	public Poupanca(String num, double s, Cliente c) {
		super(num, s, c);
	}

	/**
	 * Credita ao saldo da conta os juros, rendidos a partir da taxa passada como
	 * par�metro. 
	 * 
	 * @param taxa a taxa sobre a qual os juros ser�o rendidos.
	 */
	public void renderJuros(double taxa) {

		double saldo = this.getSaldo();
		this.creditar(saldo * taxa);
	}
}

package qualiti.banco.contas;

import qualiti.banco.clientes.Cliente;

/**
 * Classe b�sica que representa uma entidade de conta imposto, com seus dados, valida��es
 * dos mesmos e suas opera��es relacionadas. A super-classe cont�m muitos dos atributos
 * e opera��es de uma conta simples. A conta imposto tem a ela associada uma taxa, que
 * � aplicada �s opera��es de d�bito. 
 * 
 * @author Qualiti <a href="mailto:qualiti@qualiti.com.br">qualiti@qualiti.com.br</a>
 *
 * @version 1.0 
 *
 * @see qualiti.banco.conta.ContaAbstrata
 */
public class ContaImposto extends ContaAbstrata {

	/**
	 * Constante que define o valor da taxa a ser aplicada �s opera��es de d�bito.
	 */
	public final static double TAXA = 0.001;

	/**
	 * O construtor da classe. Inicializa os atributos com os valores passados como
	 * par�metro chamando o construtor da super-classe.
	 * 
	 * @param num o n�mero da conta.
	 * @param cli o cliente da conta.  
	 */
	public ContaImposto(String n, Cliente c) {

		super(n, c);
	}

	/**
	 * O construtor da classe. Inicializa os atributos com os valores passados como
	 * par�metro chamando o construtor da super-classe.
	 * 
	 * @param num o n�mero da conta.
	 * @param sld o saldo inicial da conta. 
	 * @param cli o cliente da conta.  
	 */
	public ContaImposto(String n, double s, Cliente c) {

		super(n, s, c);
	}

	/**
	 * Debita um dado valor mais imposto do saldo atual da conta, caso o valor mais o 
	 * imposto seja menor que o saldo da conta. O imposto � calculado aplicando-se
	 * a taxa ao valor a ser debitado. 
	 * 
	 * @param valor o valor a ser debitado.
	 *
	 * @exception SaldoInsuficienteException lan�ada quando o valor passado como
	 *            par�metro mais o imposto � maior que o saldo da conta. 
	 */
	public void debitar(double valor) throws SaldoInsuficienteException {

		double imposto = valor * TAXA;
		double saldo = this.getSaldo();
		if (valor + TAXA <= saldo) {
			setSaldo(saldo - (valor + imposto));
		} else {
			throw new SaldoInsuficienteException(getNumero(), getSaldo());
		}
	}
}
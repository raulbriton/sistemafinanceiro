package qualiti.banco.contas;

import qualiti.banco.clientes.Cliente;

/**
 * Classe b�sica que representa uma entidade conta, com seus dados, valida��es
 * dos mesmos e suas opera��es relacionadas. A super-classe cont�m muitos dos atributos
 * e opera��es de uma conta simples. 
 * 
 * @author Qualiti <a href="mailto:qualiti@qualiti.com.br">qualiti@qualiti.com.br</a>
 *
 * @version 1.0 
 *
 * @see qualiti.banco.conta.ContaAbstrata
 */
public class Conta extends ContaAbstrata {
	/**
	 * O construtor da classe. Inicializa os atributos com os valores passados como
	 * par�metro chamando o construtor da super-classe.
	 * 
	 * @param num o n�mero da conta.
	 * @param cli o cliente da conta.  
	 */
	public Conta(String num, Cliente cli) {

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
	public Conta(String num, double sld, Cliente cli) {

		super(num, sld, cli);
	}
	/**
	 * Debita um dado valor do saldo atual da conta, caso este seja maior que o valor
	 * a ser debitado. 
	 * 
	 * @param valor o valor a ser debitado.
	 *
	 * @exception SaldoInsuficienteException lan�ada quando o valor passado como
	 *            par�metro � maior que o saldo da conta. 
	 */
	public void debitar(double valor) throws SaldoInsuficienteException {

		double saldo = getSaldo();
		if (valor <= saldo) {
			setSaldo(saldo - valor);
		} else {
			throw new SaldoInsuficienteException(getNumero(), getSaldo());
		}
	}
}

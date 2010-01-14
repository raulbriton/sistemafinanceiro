package qualiti.banco.contas;

/**
 * Exce��o lan�ada quando uma conta n�o existe no cadastro de contas. 
 *
 * @author Qualiti <a href="mailto:qualiti@qualiti.com.br">qualiti@qualiti.com.br</a>
 *
 * @version 1.0 
 *
 * @see qualiti.banco.conta.RepositorioContas
 */
public class ContaInexistenteException extends Exception {

	/**
	 * O n�mero da conta n�o existente no cadastro.
	 */
	public String numero;
	/**
	 * O construtor da classe. Inicializa a mensagem da super-classe com uma mensagem
	 * padr�o de conta n�o cadastrada e inicializa o n�mero cuja conta n�o existe no cadastro.
	 *
	 * @param num o n�mero da conta n�o existente no cadastro.
	 */
	public ContaInexistenteException(String num) {

		super(MSG_CTA_INEXISTENTE);
		this.numero = num;
	}
	/**
	 * Retorna o n�mero da conta n�o existente no cadastro.
	 *
	 * @return String o n�mero da conta n�o existente no cadastro.
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * Constante com a mensagem de conta n�o cadastrada.
	 */
	private static final String MSG_CTA_INEXISTENTE = "Conta n�o cadastrada !!";
}

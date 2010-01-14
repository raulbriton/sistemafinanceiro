package qualiti.banco.contas;

/**
 * Exce��o lan�ada quando uma conta j� existe no cadastro de contas. 
 *
 * @author Qualiti <a href="mailto:qualiti@qualiti.com.br">qualiti@qualiti.com.br</a>
 *
 * @version 1.0 
 *
 * @see qualiti.banco.conta.RepositorioContas
 */
public class ContaExistenteException extends Exception {

	/**
	 * O n�mero da conta j� existente no cadastro.
	 */
	public String numero;
	/**
	 * O construtor da classe. Inicializa a mensagem da super-classe com uma mensagem
	 * padr�o de conta j� cadastrada e inicializa o n�mero cuja conta j� existe no cadastro.
	 *
	 * @param num o n�mero da conta j� existente no cadastro.
	 */
	public ContaExistenteException(String num) {

		super(MSG_CTA_JA_EXISTENTE);
		this.numero = num;
	}
	/**
	 * Retorna o n�mero da conta j� existente no cadastro.
	 *
	 * @return String o n�mero da conta j� existente no cadastro.
	 */
	public String getNumero() {

		return numero;
	}
	/**
	 * Constante com a mensagem de conta j� cadastrada.
	 */
	private static final String MSG_CTA_JA_EXISTENTE = "Conta ja cadastrada !!";
}
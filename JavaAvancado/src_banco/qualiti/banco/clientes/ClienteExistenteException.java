package qualiti.banco.clientes;

/**
 * Exce��o lan�ada quando um cliente j� existe no cadastro de clientes.
 *
 * @author Qualiti <a href="mailto:qualiti@qualiti.com.br">qualiti@qualiti.com.br</a>
 *
 * @version 1.0
 *
 * @see qualiti.banco.cliente.RepositorioClientes
 */
public class ClienteExistenteException extends Exception {

	/**
	 * O CPF do cliente j� existente no cadastro.
	 */
	private String cpf;
	/**
	 * O construtor da classe. Inicializa a mensagem da super-classe com uma mensagem
	 * padr�o de cliente j� cadastrado e inicializa o cpf cujo cliente j� existe no cadastro.
	 *
	 * @param cpf o CPF do cliente j� existente no cadastro.
	 */
	public ClienteExistenteException(String cpf) {

		super(MSG_CLI_JA_EXISTENTE);
		this.cpf = cpf;
	}

	/**
	 * Retorna o CPF do cliente j� existente no cadastro.
	 *
	 * @return String o CPF do cliente j� existente no cadastro.
	 */
	public String getCpf() {

		return cpf;
	}
	/**
	 * Constante com a mensagem de cliente j� cadastrado.
	 */
	private static final String MSG_CLI_JA_EXISTENTE =
		"Cliente ja cadastrado !!";
}
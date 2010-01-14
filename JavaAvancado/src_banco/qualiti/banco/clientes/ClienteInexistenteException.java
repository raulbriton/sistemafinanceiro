package qualiti.banco.clientes;

/**
 * Exce��o lan�ada quando um cliente n�o existe no cadastro de clientes.
 *
 * @author Qualiti <a href="mailto:qualiti@qualiti.com.br">qualiti@qualiti.com.br</a>
 *
 * @version 1.0
 *
 * @see qualiti.banco.cliente.RepositorioClientes
 */
public class ClienteInexistenteException extends Exception {

	/**
	 * O CPF do cliente n�o existente no cadastro.
	 */
	private String cpf;

	/**
	 * O construtor da classe. Inicializa a mensagem da super-classe com uma mensagem
	 * padr�o de cliente n�o cadastrado e inicializa o cpf cujo cliente n�o existe no cadastro.
	 *
	 * @param cpf o CPF do cliente n�o existente no cadastro.
	 */
	public ClienteInexistenteException(String cpf) {

		super(MSG_CLI_INEXISTENTE);
		this.cpf = cpf;
	}

	/**
	 * Retorna o CPF do cliente n�o existente no cadastro.
	 *
	 * @return String o CPF do cliente n�o existente no cadastro.
	 */
	public String getCpf() {

		return cpf;
	}
	/**
	 * Constante com a mensagem de cliente n�o cadastrado.
	 */
	private static final String MSG_CLI_INEXISTENTE =
		"Cliente n�o cadastrado !!";
}
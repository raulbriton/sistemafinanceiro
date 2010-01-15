package qualiti.banco.clientes;

import java.util.HashMap;

/**
 * Implementa��o da interface que define os m�todos de acesso aos dados de cliente
 * em um mecanismo de armazenamento de dados. Esta implementa��o � realizada atrav�s
 * do armazenamento de objetos do tipo cliente em um HashMap interno de clientes existente
 * em mem�ria.
 *
 * @author Qualiti <a href="mailto:qualiti@qualiti.com.br">qualiti@qualiti.com.br</a>
 *
 * @version 1.0
 *
 * @see qualiti.banco.cliente.Cliente
 * @see qualiti.banco.cliente.RepositorioClientes
 */
public class RepositorioClientesMap implements RepositorioClientes {

	/**
	 * Map interno de clientes.
	 * A chave de indice do map � o CPF do cliente.
	 */
	private HashMap<String,Cliente> clientes;
	 
	/**
	 * O construtor da classe. IInicializa o HashMap.
	 */
	public RepositorioClientesMap() {
		clientes = new HashMap<String,Cliente>();
	}

	/**
	 * Atualiza os dados de um cliente no Hasmap.
	 *
	 * @param c o cliente com os dados a serem atualizados.
	 *
	 * @exception ClienteInexistenteException lan�ada quando o cliente a ter seus dados
	 *            atualizados n�o existe no Map. A procura � feita pelo CPF.
	 */
	public void atualizar(Cliente c) throws ClienteInexistenteException {
		if (existe(c.getCpf())) {
			clientes.put(c.getCpf(), c);
		} else {
			throw new ClienteInexistenteException(c.getCpf());
		}
	}

	/**
	 * Verifica se um cliente existe armazenado no Map.
	 *
	 * @param cpf o CPF do cliente cuja exist�ncia no Map
	 *        ser� verificada.
	 *
	 * @return boolean true se o cliente existir no Map e
	 *         false caso contr�rio.
	 */
	public boolean existe(String cpf) {
		return clientes.containsKey(cpf);
	}

	/**
	 * Cadastra os dados de um cliente no Map, inserindo o objeto recebido
	 * como par�metro.
	 *
	 * @param c o cliente com os dados a serem cadastrados.
	 *
	 * @see Q1 Por que este m�todo n�o lan�a a exce��o de cliente j� existente ??
	 *
	 * @see Q2 Por que este m�todo n�o testa a exist�ncia de um cliente com mesmo
	 *         CPF do cliente passado no Map ??
	 */
	public void inserir(Cliente c) {
		clientes.put(c.getCpf(),c);
	}

	/**
	 * Retorna um cliente armazenado no Map.
	 *
	 * @param cpf o CPF do cliente que ser� procurado no Map.
	 *
	 * @return Cliente o cliente com seus dados lidos a partir do Map.
	 *
	 * @exception ClienteInexistenteException lan�ada quando o cliente a ter seus dados
	 *            lidos n�o existe no Map. A procura � feita pelo CPF.
	 */
	public Cliente procurar(String cpf) throws ClienteInexistenteException {
		if (existe(cpf)) {
			return  clientes.get(cpf);
		} else {
			throw new ClienteInexistenteException(cpf);
		}

	}


	/**
	 * Exclui um cliente armazenado no Map. 
	 *
	 * @param cpf o CPF do cliente que ser� exclu�do do Map.
	 *
	 * @exception ClienteInexistenteException lan�ada quando o cliente a ser exclu�do
	 *            n�o existe no Map. A procura � feita por CPF.
	 */
	public void remover(String cpf) throws ClienteInexistenteException {
		if (existe(cpf)) {
			clientes.remove(cpf);
		} else {
			throw new ClienteInexistenteException(cpf);
		}
	}
}

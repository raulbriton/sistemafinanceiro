package qualiti.banco.clientes;

import java.util.Vector;

import qualiti.banco.geral.ErroAcessoRepositorioException;
/**
 * Classe que realiza valida��es referentes �s opera��es de atualiza��o de dados
 * no mecanismo de armazenamento de dados de clientes e usa o reposit�rio de clientes
 * para aualizar e buscar os dados dos mesmos.
 *
 * @author Qualiti <a href="mailto:qualiti@qualiti.com.br">qualiti@qualiti.com.br</a>
 *
 * @version 1.0
 *
 * @see qualiti.banco.cliente.Cliente
 * @see qualiti.banco.cliente.ReposiorioClientes
 */
public class CadastroClientes {

	/**
	 * Refer�ncia para a implementa��o do reposit�rio de clientes.
	 */
	private RepositorioClientes clientes;

	/**
	 * O construtor da classe. Inicializa a refer�ncia para o reposit�rio
	 * de clientes com o valor passado como par�metro.
	 *
	 * @param l a refer�ncia para o reposit�rio de clientes.
	 */
	public CadastroClientes(RepositorioClientes l) {

		this.clientes = l;
	}

	/**
	 * Atualiza os dados de um cliente no reposit�rio de clientes.
	 *
	 * @param c o cliente com os dados a serem atualizados.
	 *
	 * @exception ClienteInexistenteException lan�ada quando o cliente a ter seus dados
	 *            atualizados n�o existe no reposit�rio de clientes.Esta exce��o vem da
	 *            chamada ao reposit�rio de clientes e � repassada diretamente por este
	 *            m�todo ao seu m�todo chamador.
	 */
	public void atualizar(Cliente c)
		throws ClienteInexistenteException, ErroAcessoRepositorioException {

		clientes.atualizar(c);
	}

	/**
	 * Cadastra os dados de um cliente no reposit�rio de clientes. Antes disso,
	 * checa se o CPF do cliente a ser cadastrado j� existe no reposit�rio de clientes.
	 *
	 * @param c o cliente com os dados a serem cadastrados.
	 *
	 * @exception ClienteExistenteException se o CPF do cliente a ser cadastrado j�
	 *            existir no reposit�rio de clientes. Esta exce��o � instanciada e
	 *            lan�ada por este m�todo, caso a consulta ao CPF feita no reposit�rio
	 *            retorne true.
	 */
	public void cadastrar(Cliente c)
		throws ClienteExistenteException, ErroAcessoRepositorioException {

		String cpf = c.getCpf();
		if (!clientes.existe(cpf)) {
			clientes.inserir(c);
		} else {
			throw new ClienteExistenteException(c.getCpf());
		}
	}

	/**
	 * Exclui um cliente armazenado no reposit�rio de clientes.
	 *
	 * @param cpf o CPF do cliente que ser� exclu�do do reposit�rio de clientes.
	 *
	 * @exception ClienteInexistenteException lan�ada quando o cliente a ser exclu�do
	 *            n�o existe no reposit�rio de clientes. Esta exce��o vem da chamada ao
	 *            reposit�rio de clientes e � repassada diretamente por este m�todo
	 *            ao seu m�todo chamador.
	 */
	public void descadastrar(String cpf)
		throws ClienteInexistenteException, ErroAcessoRepositorioException {

		clientes.remover(cpf);
	}

	/**
	 * Retorna um cliente armazenado no reposit�rio de clientes.
	 *
	 * @param cpf o CPF do cliente que ser� procurado no reposit�rio de clientes.
	 *
	 * @return Cliente o cliente com seus dados lidos a partir do reposit�rio
	 *         de clientes.
	 *
	 * @exception ClienteInexistenteException lan�ada quando o cliente a ter seus dados
	 *            lidos n�o existe no reposit�rio de clientes. Esta exce��o vem da chamada
	 *            ao reposit�rio de clientes e � repassada diretamente por este m�todo ao
	 *            seu m�todo chamador.
	 */
	public Cliente procurar(String cpf)
		throws ClienteInexistenteException, ErroAcessoRepositorioException {

		return clientes.procurar(cpf);
	}

	public Vector<Cliente> listar()throws ErroAcessoRepositorioException {
		return clientes.listar();
	}
}

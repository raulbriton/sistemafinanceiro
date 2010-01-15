package qualiti.banco.clientes;

/**
 * Interface que define os m�todos de acesso aos dados de cliente em um
 * mecanismo de armazenamento de dados.
 *
 * @author Qualiti <a href="mailto:qualiti@qualiti.com.br">qualiti@qualiti.com.br</a>
 *
 * @version 1.0
 *
 * @see qualiti.banco.cliente.Cliente
 */
public interface RepositorioClientes {
	/**
	 * Atualiza os dados de um cliente EM UM MECANISMO DE ARMAZENAMENTO DE DADOS.
	 *
	 * @param c o cliente com os dados a serem atualizados.
	 *
	 * @exception ClienteInexistenteException lan�ada quando o cliente a ter seus dados
	 *            atualizados n�o existe no MECANISMO DE ARMAZENAMENTO DE DADOS.
	 *
	 * @see Q1 Al�m das exce��es definidas, os m�todos do reposit�rio n�o deveriam
	 *         lan�ar outra exce��o para indicar problemas no mecanismo de acesso ??
	 */
	public void atualizar(Cliente c) throws ClienteInexistenteException;
	/**
	 * Verifica se um cliente existe armazenado EM UM MECANISMO DE ARMAZENAMENTO DE DADOS.
	 *
	 * @param cpf o CPF do cliente cuja exist�ncia EM UM MECANISMO DE ARMAZENAMENTO DE DADOS
	 *        ser� verificada.
	 *
	 * @return boolean true se o cliente existir EM UM MECANISMO DE ARMAZENAMENTO DE DADOS e
	 *         false caso contr�rio.
	 *
	 * @see Q1 Al�m das exce��es definidas, os m�todos do reposit�rio n�o deveriam
	 *         lan�ar outra exce��o para indicar problemas no mecanismo de acesso ??
	 */
	public boolean existe(String cpf);
	/**
	 * Cadastra os dados de um cliente EM UM MECANISMO DE ARMAZENAMENTO DE DADOS.
	 *
	 * @param c o cliente com os dados a serem cadastrados.
	 *
	 * @see Q1 Por que este m�todo n�o lan�a a exce��o de cliente j� existente ??
	 *
	 * @see Q2 Al�m das exce��es definidas, os m�todos do reposit�rio n�o deveriam
	 *         lan�ar outra exce��o para indicar problemas no mecanismo de acesso ??
	 */
	public void inserir(Cliente c);
	/**
	 * Retorna um cliente armazenado EM UM MECANISMO DE ARMAZENAMENTO DE DADOS.
	 *
	 * @param cpf o CPF do cliente que ser� procurado EM UM MECANISMO DE ARMAZENAMENTO
	 *        DE DADOS.
	 *
	 * @return Cliente o cliente com seus dados lidos a partir DE UM MECANISMO DE
	 *         ARMAZENAMENTO DE DADOS.
	 *
	 * @exception ClienteInexistenteException lan�ada quando o cliente a ter seus dados
	 *            lidos n�o existe no MECANISMO DE ARMAZENAMENTO DE DADOS.
	 *
	 * @see Q1 Al�m das exce��es definidas, os m�todos do reposit�rio n�o deveriam
	 *         lan�ar outra exce��o para indicar problemas no mecanismo de acesso ??
	 */
	public Cliente procurar(String cpf) throws ClienteInexistenteException;
	/**
	 * Exclui um cliente armazenado EM UM MECANISMO DE ARMAZENAMENTO DE DADOS.
	 *
	 * @param cpf o CPF do cliente que ser� exclu�do EM UM MECANISMO DE ARMAZENAMENTO
	 *        DE DADOS.
	 *
	 * @exception ClienteInexistenteException lan�ada quando o cliente a ser exclu�do
	 *            n�o existe no MECANISMO DE ARMAZENAMENTO DE DADOS.
	 *
	 * @see Q1 Al�m das exce��es definidas, os m�todos do reposit�rio n�o deveriam
	 *         lan�ar outra exce��o para indicar problemas no mecanismo de acesso ??
	 */
	public void remover(String cpf) throws ClienteInexistenteException;
}
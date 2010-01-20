package qualiti.banco.clientes;

import java.util.Vector;

import qualiti.banco.geral.ErroAcessoRepositorioException;
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
	 * @exception ErroAcessoRepositorioException lan�ada quando ocorrer erro de acesso
	 *            no EM UM MECANISMO DE ARMAZENAMENTO DE DADOS. 
	 */
	public void atualizar(Cliente c)
		throws ClienteInexistenteException, ErroAcessoRepositorioException;
	/**
	 * Verifica se um cliente existe armazenado EM UM MECANISMO DE ARMAZENAMENTO DE DADOS.
	 * 
	 * @param cpf o CPF do cliente cuja exist�ncia EM UM MECANISMO DE ARMAZENAMENTO DE DADOS 
	 *        ser� verificada.
	 * 
	 * @return boolean true se o cliente existir EM UM MECANISMO DE ARMAZENAMENTO DE DADOS e
	 *         false caso contr�rio.
	 * 
	 * @exception ErroAcessoRepositorioException lan�ada quando ocorrer erro de acesso
	 *            no EM UM MECANISMO DE ARMAZENAMENTO DE DADOS. 
	 */
	public boolean existe(String cpf) throws ErroAcessoRepositorioException;
	/**
	 * Cadastra os dados de um cliente EM UM MECANISMO DE ARMAZENAMENTO DE DADOS.
	 * 
	 * @param c o cliente com os dados a serem cadastrados. 
	 *
	 * @see Q1 Por que este m�todo n�o lan�a a exce��o de cliente j� existente ??
	 *
	 * @exception ErroAcessoRepositorioException lan�ada quando ocorrer erro de acesso
	 *            no EM UM MECANISMO DE ARMAZENAMENTO DE DADOS. 
	 */
	public void inserir(Cliente c) throws ErroAcessoRepositorioException;
	
	/**
	 * lista todos os clientes EM UM MECANISMO DE ARMAZENAMENTO DE DADOS.
	 * 
	 * @exception ErroAcessoRepositorioException lan�ada quando ocorrer erro de acesso
	 *            no EM UM MECANISMO DE ARMAZENAMENTO DE DADOS. 
	 */
	public Vector<Cliente> listar() throws ErroAcessoRepositorioException;
	
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
	 * @exception ErroAcessoRepositorioException lan�ada quando ocorrer erro de acesso
	 *            no EM UM MECANISMO DE ARMAZENAMENTO DE DADOS. 
	 */
	public Cliente procurar(String cpf)
		throws ClienteInexistenteException, ErroAcessoRepositorioException;
	/**
	 * Exclui um cliente armazenado EM UM MECANISMO DE ARMAZENAMENTO DE DADOS.
	 * 
	 * @param cpf o CPF do cliente que ser� exclu�do EM UM MECANISMO DE ARMAZENAMENTO 
	 *        DE DADOS.
	 *
	 * @exception ClienteInexistenteException lan�ada quando o cliente a ser exclu�do 
	 *            n�o existe no MECANISMO DE ARMAZENAMENTO DE DADOS.
	 * @exception ErroAcessoRepositorioException lan�ada quando ocorrer erro de acesso
	 *            no EM UM MECANISMO DE ARMAZENAMENTO DE DADOS. 
	 */
	public void remover(String cpf)
		throws ClienteInexistenteException, ErroAcessoRepositorioException;
}

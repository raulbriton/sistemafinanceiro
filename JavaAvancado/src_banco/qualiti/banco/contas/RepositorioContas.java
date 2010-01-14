package qualiti.banco.contas;

/**
 * Interface que define os m�todos de acesso aos dados de conta em um
 * mecanismo de armazenamento de dados. 
 *
 * @author Qualiti <a href="mailto:qualiti@qualiti.com.br">qualiti@qualiti.com.br</a>
 *
 * @version 1.0 
 *
 * @see qualiti.banco.conta.ContaAbstrata
 */
public interface RepositorioContas {
	/**
	 * Cadastra os dados de uma conta EM UM MECANISMO DE ARMAZENAMENTO DE DADOS.
	 * 
	 * @param c a conta com os dados a serem cadastrados. 
	 *
	 * @see Q1 Por que este m�todo n�o lan�a a exce��o de conta j� existente ??
	 *
	 * @see Q2 Al�m das exce��es definidas, os m�todos do reposit�rio n�o deveriam
	 *         lan�ar outra exce��o para indicar problemas no mecanismo de acesso ??  
	 */
	public void inserir(ContaAbstrata c);
	/**
	 * Verifica se uma conta existe armazenada EM UM MECANISMO DE ARMAZENAMENTO DE DADOS.
	 * 
	 * @param num o n�mero da conta cuja exist�ncia EM UM MECANISMO DE ARMAZENAMENTO DE DADOS 
	 *        ser� verificada.
	 * 
	 * @return boolean true se a conta existir EM UM MECANISMO DE ARMAZENAMENTO DE DADOS e
	 *         false caso contr�rio.
	 *
	 * @see Q1 Al�m das exce��es definidas, os m�todos do reposit�rio n�o deveriam
	 *         lan�ar outra exce��o para indicar problemas no mecanismo de acesso ??  
	 */
	public boolean existe(String num);
	/**
	 * Atualiza os dados de uma conta EM UM MECANISMO DE ARMAZENAMENTO DE DADOS.
	 * 
	 * @param c a conta com os dados a serem atualizados. 
	 * 
	 * @exception ContaInexistenteException lan�ada quando a conta a ter seus dados 
	 *            atualizados n�o existe no MECANISMO DE ARMAZENAMENTO DE DADOS.
	 *
	 * @see Q1 Al�m das exce��es definidas, os m�todos do reposit�rio n�o deveriam
	 *         lan�ar outra exce��o para indicar problemas no mecanismo de acesso ??  
	 */
	public void atualizar(ContaAbstrata c) throws ContaInexistenteException;
	/**
	 * Retorna uma conta armazenada EM UM MECANISMO DE ARMAZENAMENTO DE DADOS.
	 * 
	 * @param num o n�mero da conta que ser� procurado EM UM MECANISMO DE ARMAZENAMENTO 
	 *        DE DADOS.
	 *        
	 * @return ContaAbstrata a conta com seus dados lidos a partir DE UM MECANISMO DE 
	 *         ARMAZENAMENTO DE DADOS.
	 *
	 * @exception ContaInexistenteException lan�ada quando a conta a ter seus dados 
	 *            lidos n�o existe no MECANISMO DE ARMAZENAMENTO DE DADOS.
	 * 
	 * @see Q1 Al�m das exce��es definidas, os m�todos do reposit�rio n�o deveriam
	 *         lan�ar outra exce��o para indicar problemas no mecanismo de acesso ??   
	 */
	public ContaAbstrata procurar(String num) throws ContaInexistenteException;
	/**
	 * Exclui uma conta armazenada EM UM MECANISMO DE ARMAZENAMENTO DE DADOS.
	 * 
	 * @param num o n�mero da conta que ser� exclu�da EM UM MECANISMO DE ARMAZENAMENTO 
	 *        DE DADOS.
	 *
	 * @exception ContaInexistenteException lan�ada quando a conta a ser exclu�da 
	 *            n�o existe no MECANISMO DE ARMAZENAMENTO DE DADOS.
	 *
	 * @see Q1 Al�m das exce��es definidas, os m�todos do reposit�rio n�o deveriam
	 *         lan�ar outra exce��o para indicar problemas no mecanismo de acesso ??  
	 */
	public void remover(String num) throws ContaInexistenteException;
}

package qualiti.banco.contas;

/**
 * Classe que realiza valida��es referentes �s opera��es de atualiza��o de dados
 * no mecanismo de armazenamento de dados de contas e usa o reposit�rio de contas
 * para aualizar e buscar os dados das mesmas. Realiza tamb�m opera��es de cr�dito,
 * de d�bito e de transfer�ncia entre contas.
 *
 * @author Qualiti <a href="mailto:qualiti@qualiti.com.br">qualiti@qualiti.com.br</a>
 *
 * @version 1.0 
 *
 * @see qualiti.banco.cliente.Cliente
 * @see qualiti.banco.cliente.ReposiorioClientes
 */
public class CadastroContas {

	/**
	 * Refer�ncia para a implementa��o do reposit�rio de contas.
	 */
	private RepositorioContas contas;

	/**
	 * O construtor da classe. Inicializa a refer�ncia para o reposit�rio
	 * de contas com o valor passado como par�metro. 
	 * 
	 * @param r a refer�ncia para o reposit�rio de contas.
	 */
	public CadastroContas(RepositorioContas r) {

		this.contas = r;
	}

	/**
	 * Atualiza os dados de uma conta no reposit�rio de contas.
	 * 
	 * @param c a conta com os dados a serem atualizados. 
	 * 
	 * @exception ContaInexistenteException lan�ada quando a conta a ter seus dados 
	 *            atualizados n�o existe no reposit�rio de contas.Esta exce��o vem da 
	 *            chamada ao reposit�rio de contas e � repassada diretamente por este 
	 *            m�todo ao seu m�todo chamador. 
	 */
	public void atualizar(ContaAbstrata c) throws ContaInexistenteException {

		contas.atualizar(c);
	}

	/**
	 * Cadastra os dados de uma conta no reposit�rio de contas. Antes disso, 
	 * checa se o n�mero da conta a ser cadastrada j� existe no reposit�rio  
	 * de contas.
	 * 
	 * @param c a conta com os dados a serem cadastrados.
	 *
	 * @exception ContaExistenteException se o n�mero da conta a ser cadastrada j� 
	 *            existir no reposit�rio de contas. Esta exce��o � instanciada e
	 *            lan�ada por este m�todo, caso a consulta ao n�mero feita no 
	 *            reposit�rio retorne true. 
	 */
	public void cadastrar(ContaAbstrata c) throws ContaExistenteException {

		if (!contas.existe(c.getNumero())) {
			contas.inserir(c);
		} else {
			throw new ContaExistenteException(c.getNumero());
		}
	}

	/**
	 * Realiza uma opera��o de cr�dito de um dado valor em uma conta no reposit�rio de contas. 
	 * 
	 * @param n o n�mero da conta a ser creditada.
	 * @param v o valor a ser creditado.
	 * 
	 * @exception ContaInexistenteException lan�ada quando a conta a ser creditada
	 *            n�o existe no reposit�rio de contas.Esta exce��o vem da chamada 
	 *            ao reposit�rio de contas e � repassada diretamente por este 
	 *            m�todo ao seu m�todo chamador.
	 *
	 * @see Q1 Por que este m�todo, ap�s realizar a opera��o de creditar na
	 *         conta, n�o atualiza os dados da mesma usando o reposit�rio ??
	 *         Ser� que esta forma de implementa��o ir� funcionar quando a 
	 *         implementa��o do reposit�rio for trocada por uma classe que 
	 *         acessa um banco SQL ??   
	 */
	public void creditar(String n, double v) throws ContaInexistenteException {

		// lan�a ContaInexistenteException  
		ContaAbstrata c = contas.procurar(n);
		c.creditar(v);
	}

	/**
	 * Realiza uma opera��o de d�bito de um dado valor em uma conta no reposit�rio de contas. 
	 * 
	 * @param n o n�mero da conta a ser debitada.
	 * @param v o valor a ser debitado.
	 * 
	 * @exception ContaInexistenteException lan�ada quando a conta a ser debitada
	 *            n�o existe no reposit�rio de contas.Esta exce��o vem da chamada 
	 *            ao reposit�rio de contas e � repassada diretamente por este 
	 *            m�todo ao seu m�todo chamador.
	 * @exception SaldoInsuficienteException lan�ada quando o saldo da conta a
	 *            ser debitada � menor que o valor a ser debitado. Esta exce��o 
	 *            vem da chamada ao m�todo debitar() de contas e � repassada 
	 *            diretamente por este m�todo em quest�o ao seu m�todo chamador.
	 *
	 * @see Q1 Por que este m�todo, ap�s realizar a opera��o de debitar na
	 *         conta, n�o atualiza os dados da mesma usando o reposit�rio ??
	 *         Ser� que esta forma de implementa��o ir� funcionar quando a 
	 *         implementa��o do reposit�rio for trocada por uma classe que 
	 *         acessa um banco SQL ??   
	 */
	public void debitar(String n, double v)
		throws ContaInexistenteException, SaldoInsuficienteException {

		// lan�a ContaInexistenteException  
		ContaAbstrata c = contas.procurar(n);
		// lan�a SaldoInsuficienteException
		c.debitar(v);
	}

	/**
	 * Exclui uma conta armazenada no reposit�rio de contas.
	 * 
	 * @param n o n�mero da conta que ser� exclu�da do reposit�rio de contas.
	 *
	 * @exception ContaInexistenteException lan�ada quando a conta a ser exclu�da 
	 *            n�o existe no reposit�rio de contas. Esta exce��o vem da chamada ao 
	 *            reposit�rio de contas e � repassada diretamente por este m�todo 
	 *            ao seu m�todo chamador.  
	 */
	public void remover(String n) throws ContaInexistenteException {

		contas.remover(n);
	}

	/**
	 * Retorna uma conta armazenada no reposit�rio de contas.
	 * 
	 * @param n o n�mero da conta que ser� procurada no reposit�rio de contas.
	 *        
	 * @return ContaAbstrata a conta com seus dados lidos a partir do reposit�rio
	 *         de contas. Pode ser qualquer sub-tipo de conta abstrata. 
	 *
	 * @exception ContaInexistenteException lan�ada quando a conta a ter seus dados 
	 *            lidos n�o existe no reposit�rio de contas. Esta exce��o vem da chamada 
	 *            ao reposit�rio de contas e � repassada diretamente por este m�todo ao 
	 *            seu m�todo chamador. 
	 */
	public ContaAbstrata procurar(String n) throws ContaInexistenteException {

		return contas.procurar(n);
	}

	/**
	 * Realiza uma opera��o de transfer�ncia de um dado valor de uma conta 
	 * para outra conta.
	 * 
	 * @param origem o n�mero da conta a ser debitada.
	 * @param destino o n�mero da conta a ser creditada.
	 * @param val o valor a ser transferido.
	 * 
	 * @exception ContaInexistenteException lan�ada quando a conta a ser debitada ou 
	 *            a conta a ser creditada n�o existe no reposit�rio de contas.Esta 
	 *            exce��o vem da chamada  ao reposit�rio de contas e � repassada 
	 *            diretamente por este m�todo ao seu m�todo chamador.
	 * @exception SaldoInsuficienteException lan�ada quando o saldo da conta a
	 *            ser debitada � menor que o valor a ser transferido. Esta exce��o 
	 *            vem da chamada ao m�todo debitar() de contas e � repassada 
	 *            diretamente por este m�todo em quest�o ao seu m�todo chamador.
	 *
	 * @see Q1 Por que este m�todo, ap�s realizar a opera��o de transferir na
	 *         conta, n�o atualiza os dados da mesma usando o reposit�rio ??
	 *         Ser� que esta forma de implementa��o ir� funcionar quando a 
	 *         implementa��o do reposit�rio for trocada por uma classe que 
	 *         acessa um banco SQL ??   
	 */
	public void transferir(String origem, String destino, double val)
		throws ContaInexistenteException, SaldoInsuficienteException {

		// lan�a ContaInexistenteException  
		ContaAbstrata o = contas.procurar(origem);
		// lan�a ContaInexistenteException  
		ContaAbstrata d = contas.procurar(destino);
		// lan�a SaldoInsuficienteException 
		o.transferir(d, val);
	}
}
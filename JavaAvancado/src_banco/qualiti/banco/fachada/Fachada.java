package qualiti.banco.fachada;

import java.util.Vector;

import qualiti.banco.clientes.CadastroClientes;
import qualiti.banco.clientes.Cliente;
import qualiti.banco.clientes.ClienteExistenteException;
import qualiti.banco.clientes.ClienteInexistenteException;
import qualiti.banco.clientes.ClienteInvalidoException;
import qualiti.banco.clientes.RepositorioClientes;
import qualiti.banco.clientes.RepositorioClientesHibernate;
import qualiti.banco.contas.CadastroContas;
import qualiti.banco.contas.ContaAbstrata;
import qualiti.banco.contas.ContaExistenteException;
import qualiti.banco.contas.ContaInexistenteException;
import qualiti.banco.contas.RepositorioContas;
import qualiti.banco.contas.RepositorioContasBDR;
import qualiti.banco.contas.SaldoInsuficienteException;
import qualiti.banco.geral.ErroAcessoRepositorioException;

/**
 * Classe que representa a fachada do sistema. Interage com o meio externo para atender ou encaminhar
 * solicita��es de processamento. Esta classe � um Singleton, padr�o de projeto que garante a exist�ncia
 * de uma �nica inst�ncia desta classe em um programa JAVA. 
 *
 * @author Qualiti <a href="mailto:qualiti@qualiti.com.br">qualiti@qualiti.com.br</a>
 *
 * @version 1.0 
 *
 * @see qualiti.banco.cliente.CadastroClientes
 * @see qualiti.banco.conta.CadastroContas
 */
public class Fachada {

	/**
	 * Refer�ncia est�tica do Singleton. Guarda o endere�o do objeto que representa a �nica
	 * inst�ncia desta classe em um programa JAVA. 
	 */
	private static Fachada instancia;
	/**
	 * Refer�ncia para o cadastro de contas. 
	 */
	private CadastroContas contas;
	/**
	 * Refer�ncia para o cadastro de clientes. 
	 */
	private CadastroClientes clientes;

	/**
	 * Construtor privado da classe. Ele � assim definido para que o padr�o de implementa��o
	 * do Singleton possa garantir que uma �nica inst�ncia desta classe exista em um programa
	 * JAVA. Para que isto ocorra, uma das premissas � restringir a responsabilidade de criar
	 * objetos do tipo desta classe a ela pr�pria. Isto se faz colocando o construtor com
	 * acesso privado. Este construtor chama o m�todo que inicializa os cadastros de contas e
	 * de clientes.
	 */
	private Fachada() {

		initCadastros();
	}

	/**
	 * Inicializa os cadastros de contas e de clientes, passando para estes as implementa��es dos reposit�rios
	 * de contas e de clientes a serem usadas pelos cadastros inicializados. � interessante notar que os
	 * reposit�rios inicializados s�o interfaces, que recebem refer�ncias de implementa��es usando arrays em
	 * mem�ria. Uma sofistica��o maior do sistema permitir� a implementa��o de reposit�rios que utilizam acesso
	 * a bancos de dados SQL. Para mudar a forma de implementa��o dos reposit�rios, basta alterar a 1a e a 3a 
	 * linhas deste m�todo, inicializando os reposit�rios de clientes e de contas com as implementa��es que usam
	 * acesso a bancos de dados SQL. 
	 */
	private void initCadastros() {

		RepositorioContas rep = new RepositorioContasBDR();
		contas = new CadastroContas(rep);
		RepositorioClientes repClientes = new RepositorioClientesHibernate();
		clientes = new CadastroClientes(repClientes);
	}

	/**
	 * M�todo respons�vel por retornar a refer�ncia da �nica inst�ncia desta classe
	 * no programa JAVA e por criar esta �nica inst�ncia, caso ela n�o exista. 
	 * 
	 * @return Fachada refer�ncia para a �nica inst�ncia desta classe. 
	 */
	public static Fachada obterInstancia() {

		// Na primeira vez que este m�todo for chamado, instancia == null
		// Assim, o teste retorna true, a inst�ncia � criada e sua refer�ncia
		// � atribu�da ao atributo instancia. Nas pr�ximas chamadas, o teste
		// retorna false e a refer�ncia criada na primeira chamada sempre �
		// retornada.
		if (instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
	}

	/**
	 * Atualiza os dados de um cliente. A fachada, neste caso, delega esta responsabilidade ao
	 * cadastro de clientes.
	 * 
	 * @param c o cliente com os dados a serem atualizados. 
	 * 
	 * @exception ClienteInexistenteException lan�ada quando o cliente a ter seus dados 
	 *            atualizados n�o existe no cadastro. Esta exce��o vem da chamada ao
	 *            cadastro de clientes e � repassada diretamente por este m�todo ao
	 *            seu m�todo chamador. 
	 * @throws ErroAcessoRepositorioException 
	 */
	public void atualizar(Cliente c) throws ClienteInexistenteException, ErroAcessoRepositorioException {

		clientes.atualizar(c);
	}

	/**
	 * Busca um cliente do cadastro de clientes. A fachada, neste caso, delega esta responsabilidade ao
	 * cadastro de clientes.
	 * 
	 * @param cpf o CPF do cliente a ser buscado.
	 *
	 * @return Cliente o cliente com os dados reucperados do cadastro.
	 * 
	 * @exception ClienteInexistenteException lan�ada quando o cliente a ser buscado n�o 
	 *            existe no cadastro. Esta exce��o vem da chamada ao cadastro de clientes 
	 *            e � repassada diretamente por este m�todo ao seu m�todo chamador. 
	 * @throws ErroAcessoRepositorioException 
	 */
	public Cliente procurarCliente(String cpf)
		throws ClienteInexistenteException, ErroAcessoRepositorioException {

		return clientes.procurar(cpf);
	}

	/**
	 * Cadastra os dados de um cliente. A fachada, neste caso, delega esta responsabilidade ao
	 * cadastro de clientes.
	 * 
	 * @param c o cliente com os dados a serem cadastrados. 
	 * 
	 * @exception ClienteExistenteException lan�ada quando o cliente a ter seus dados 
	 *            cadastrados j� existe no cadastro. Esta exce��o vem da chamada ao
	 *            cadastro de clientes e � repassada diretamente por este m�todo ao
	 *            seu m�todo chamador. 
	 * @throws ErroAcessoRepositorioException 
	 */
	public void cadastrar(Cliente c) throws ClienteExistenteException, ErroAcessoRepositorioException {

		clientes.cadastrar(c);
	}

	/**
	 * Exclui um cliente do cadastro de clientes. A fachada, neste caso, delega esta responsabilidade ao
	 * cadastro de clientes.
	 * 
	 * @param cpf o CPF do cliente a ser exclu�do.
	 * 
	 * @exception ClienteInexistenteException lan�ada quando o cliente a ser exclu�do n�o 
	 *            existe no cadastro. Esta exce��o vem da chamada ao cadastro de clientes 
	 *            e � repassada diretamente por este m�todo ao seu m�todo chamador. 
	 * @throws ErroAcessoRepositorioException 
	 */
	public void descadastrarCliente(String cpf)
		throws ClienteInexistenteException, ErroAcessoRepositorioException {

		clientes.descadastrar(cpf);
	}

	/**
	 * Atualiza os dados de uma conta. A fachada, neste caso, delega esta responsabilidade ao
	 * cadastro de contas. � interessante notar que este m�todo suporta atualiza��o dos dados
	 * de QUALQUER TIPO DE CONTA, pois recebe como par�metro uma conta abstrata.
	 * 
	 * @param c a conta com os dados a serem atualizados. 
	 * 
	 * @exception ContaInexistenteException lan�ada quando a conta a ter seus dados 
	 *            atualizados n�o existe no cadastro. Esta exce��o vem da chamada ao
	 *            cadastro de contas e � repassada diretamente por este m�todo ao
	 *            seu m�todo chamador. 
	 */
	public void atualizar(ContaAbstrata c) throws ContaInexistenteException {

		contas.atualizar(c);
	}

	/**
	 * Busca QUALQUER TIPO DE CONTA do cadastro de contas. A fachada, neste caso, delega esta responsabilidade ao
	 * cadastro de contas. � interessante notar que este m�todo suporta busca dos dados de QUALQUER TIPO DE CONTA, 
	 * pois retorna uma conta abstrata.
	 * 
	 * @param n o n�mero da conta a ser buscada.
	 *
	 * @return ContaAbstrata a conta com os dados recuperados do cadastro.
	 * 
	 * @exception ContaInexistenteException lan�ada quando a conta a ser buscada n�o 
	 *            existe no cadastro. Esta exce��o vem da chamada ao cadastro de contas 
	 *            e � repassada diretamente por este m�todo ao seu m�todo chamador. 
	 */
	public ContaAbstrata procurarConta(String n)
		throws ContaInexistenteException {

		return contas.procurar(n);
	}

	/**
	 * Cadastra os dados de uma conta. A fachada, neste caso, delega esta responsabilidade ao
	 * cadastro de contas. � interessante notar que este m�todo suporta cadastramento dos dados
	 * de QUALQUER TIPO DE CONTA, pois recebe como par�metro uma conta abstrata.
	 * 
	 * @param c a conta com os dados a serem cadastrados. 
	 * 
	 * @exception ContaExistenteException lan�ada quando a conta a ter seus dados 
	 *            cadastrados j� existe no cadastro. Esta exce��o vem da chamada ao
	 *            cadastro de contas e � repassada diretamente por este m�todo ao
	 *            seu m�todo chamador.
	 * @exception ClienteInexistenteException lan�ada quando o cliente a ser associado 
	 *            � conta a ser cadastrada n�o existe no cadastro de clientes. Esta exce��o
	 *            vem da chamada ao cadastro de clientes e � repassada diretamente por este
	 *            m�todo ao seu m�todo chamador. 
	 * @exception ClienteInvalidoException se o objeto cliente associado ao objeto conta for nulo. 
	 *            Esta exce��o � instanciada e lan�ada por este m�todo.
	 * @throws ErroAcessoRepositorioException 
	 *
	 * @see Q1 Este m�todo realiza uma valida��o que � pr�-condi��o para o cadastramento de uma
	 *         conta no cadastro de contas. Conceitualmente, este tipo de processamento � de 
	 *         responsabilidade do CADASTRO DE CONTAS. Um bom exerc�cio adicional � passar esta 
	 *         implementa��o de consistir o cliente da conta para o cadastro de contas. O que o 
	 *         cadastro de contas precisa usar para realizar esta valida��o ??  
	 */
	public void cadastrar(ContaAbstrata c)
		throws
			ContaExistenteException,
			ClienteInexistenteException,
			ClienteInvalidoException, ErroAcessoRepositorioException {

		Cliente cli = c.getCliente();
		if (cli != null) {
			// "procurar()" lan�a ClienteInexistenteException
			clientes.procurar(cli.getCpf());
			// "cadastrar()" lan�a ContaExistenteException
			contas.cadastrar(c);
		} else {
			// O pr�rpio m�todo lan�a ClienteInvalidoException se o cliente associado � conta for nulo
			throw new ClienteInvalidoException();
		}
	}

	/**
	 * Exclui uma conta do cadastro de contas. A fachada, neste caso, delega esta responsabilidade ao
	 * cadastro de contas.
	 * 
	 * @param n o n�mero da conta a ser exclu�da.
	 * 
	 * @exception ContaInexistenteException lan�ada quando a conta a ser exclu�da n�o 
	 *            existe no cadastro. Esta exce��o vem da chamada ao cadastro de contas 
	 *            e � repassada diretamente por este m�todo ao seu m�todo chamador. 
	 */
	public void descadastrarConta(String n) throws ContaInexistenteException {

		contas.remover(n);
	}

	/**
	 * Credita um valor em uma conta, usando o cadastro de contas. 
	 * 
	 * @param n o n�mero da conta a ser creditada.
	 * @param v o valor a ser creditado. 
	 * 
	 * @exception ContaInexistenteException lan�ada quando a conta cujo n�mero passado como par�metro
	 *            n�o existir no cadastro de contas. Esta exce��o � lan�ada pelo cadastro e � repassada
	 *            ao m�todo chamador por este m�todo. 
	 *
	 * @see Q1 Este m�todo repassa a responsabilidade de controlar o fluxo de processamento de uma
	 *         opera��o de cr�dito ao cadastro de contas, quando esta responsabilidade � de uma classe
	 *         controladora, que, em opera��es simples, � tamb�m a classe Fachada. Um bom exerc�cio 
	 *         adicional � passar este controle do fluxo de processamento de uma opera��o de cr�dito 
	 *         para este m�todo.
	 * 
	 * @see Q2 Que outras valida��es precisariam ser feitas em um processo de cr�dito ??  
	 */
	public void creditar(String n, double v) throws ContaInexistenteException {

		contas.creditar(n, v);
	}

	/**
	 * Debita um valor em uma conta, usando o cadastro de contas. 
	 * 
	 * @param n o n�mero da conta a ser debitada.
	 * @param v o valor a ser debitado. 
	 * 
	 * @exception ContaInexistenteException lan�ada quando a conta cujo n�mero passado como par�metro
	 *            n�o existir no cadastro de contas. Esta exce��o � lan�ada pelo cadastro e � repassada
	 *            ao m�todo chamador por este m�todo.
	 * @exception SaldoInsuficienteException lan�ada quando o saldo da conta a ser debitada � menor que o
	 *            valor passado como par�metro. Esta exce��o � lan�ada pelo cadastro e � repassada
	 *            ao m�todo chamador por este m�todo.
	 *
	 * @see Q1 Este m�todo repassa a responsabilidade de controlar o fluxo de processamento de uma
	 *         opera��o de d�bito ao cadastro de contas, quando esta responsabilidade � de uma classe
	 *         controladora, que, em opera��es simples, � tamb�m a classe Fachada. Um bom exerc�cio 
	 *         adicional � passar este controle do fluxo de processamento de uma opera��o de d�bito 
	 *         para este m�todo.
	 * 
	 * @see Q2 Que outras valida��es precisariam ser feitas em um processo de d�bito ??  
	 */
	public void debitar(String n, double v)
		throws ContaInexistenteException, SaldoInsuficienteException {

		contas.debitar(n, v);
	}

	/**
	 * Transfere um valor de uma conta para outra conta. 
	 * 
	 * @param origem o n�mero da conta a ser debitada.
	 * @param destino o n�mero da conta a ser creditada.
	 * @param val o valor a ser transferido. 
	 * 
	 * @exception ContaInexistenteException lan�ada quando a conta de origem cujo n�mero passado como par�metro
	 *            n�o existir no cadastro de contas ou quando a conta de destino cujo n�mero passado como 
	 *            par�metro n�o existir no cadastro de contas. Esta exce��o � lan�ada pelo cadastro e � repassada
	 *            ao m�todo chamador por este m�todo.
	 * @exception SaldoInsuficienteException lan�ada quando o saldo da conta de origem a ser debitada 
	 *            � menor que o valor passado como par�metro. Esta exce��o � lan�ada pelo cadastro e � 
	 *            repassada ao m�todo chamador por este m�todo.
	 *
	 * @see Q1 Este m�todo repassa a responsabilidade de controlar o fluxo de processamento de uma
	 *         opera��o de transfer�ncia ao cadastro de contas, quando esta responsabilidade � de uma classe
	 *         controladora, que, em opera��es simples, � tamb�m a classe Fachada. Um bom exerc�cio 
	 *         adicional � passar este controle do fluxo de processamento de uma opera��o de transfer�ncia 
	 *         para este m�todo.
	 * 
	 * @see Q2 Que outras valida��es precisariam ser feitas em um processo de transfer�ncia ??  
	 */
	public void transferir(String origem, String destino, double val)
		throws ContaInexistenteException, SaldoInsuficienteException {

		contas.transferir(origem, destino, val);
	}
	
	
	public Vector<Cliente> listarClientes()
	throws ErroAcessoRepositorioException {

		return clientes.listar();
	}
	
}
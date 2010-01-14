package qualiti.banco.clientes;

/**
 * Implementa��o da interface que define os m�todos de acesso aos dados de cliente
 * em um mecanismo de armazenamento de dados. Esta implementa��o � realizada atrav�s
 * do armazenamento de objetos do tipo cliente em um array interno de clientes existente
 * em mem�ria e inicializado com 100 posi��es fixas.
 *
 * @author Qualiti <a href="mailto:qualiti@qualiti.com.br">qualiti@qualiti.com.br</a>
 *
 * @version 1.0
 *
 * @see qualiti.banco.cliente.Cliente
 * @see qualiti.banco.cliente.RepositorioClientes
 */
public class RepositorioClientesArray implements RepositorioClientes {

	/**
	 * Array interno de clientes.
	 */
	private Cliente[] clientes;
	/**
	 * Atributo auxiliar que representa a posi��o do "pr�ximo novo objeto".
	 */
	private int indice;
	/**
	 * Tamanho do array a ser criado.
	 */
	private final static int tamCache = 100;

	/**
	 * O construtor da classe. Inicializa o �ndice com zero e instancia
	 * o array de clientes com 100 ocorr�ncias, onde 100 � o tamanho da cache.
	 */
	public RepositorioClientesArray() {

		indice = 0;
		clientes = new Cliente[tamCache];
	}

	/**
	 * Atualiza os dados de um cliente no array em mem�ria, trocando
	 * o objeto atual do array pelo objeto passado como par�metro.
	 *
	 * @param c o cliente com os dados a serem atualizados.
	 *
	 * @exception ClienteInexistenteException lan�ada quando o cliente a ter seus dados
	 *            atualizados n�o existe no array. A procura � feita pelo CPF.
	 */
	public void atualizar(Cliente c) throws ClienteInexistenteException {

		int i = procurarIndice(c.getCpf());
		if (i != -1) {
			clientes[i] = c;
		} else {
			throw new ClienteInexistenteException(c.getCpf());
		}
	}

	/**
	 * Verifica se um cliente existe armazenado no array.
	 *
	 * @param cpf o CPF do cliente cuja exist�ncia no array
	 *        ser� verificada.
	 *
	 * @return boolean true se o cliente existir no array e
	 *         false caso contr�rio.
	 */
	public boolean existe(String cpf) {

		boolean resp = false;
		int i = this.procurarIndice(cpf);
		if (i != -1) {
			resp = true;
		}
		return resp;
	}

	/**
	 * Cadastra os dados de um cliente no array, inserindo o objeto recebido
	 * como par�metro na primeira ocorr�ncia vaga daquele.
	 *
	 * @param c o cliente com os dados a serem cadastrados.
	 *
	 * @see Q1 Por que este m�todo n�o lan�a a exce��o de cliente j� existente ??
	 *
	 * @see Q2 Por que este m�todo n�o testa a exist�ncia de um cliente com mesmo
	 *         CPF do cliente passado no array ??
	 */
	public void inserir(Cliente c) {

		clientes[indice] = c;
		indice = indice + 1;
	}

	/**
	 * Retorna um cliente armazenado no array.
	 *
	 * @param cpf o CPF do cliente que ser� procurado no array.
	 *
	 * @return Cliente o cliente com seus dados lidos a partir do array.
	 *
	 * @exception ClienteInexistenteException lan�ada quando o cliente a ter seus dados
	 *            lidos n�o existe no array. A procura � feita pelo CPF.
	 */
	public Cliente procurar(String cpf) throws ClienteInexistenteException {

		Cliente c = null;
		if (existe(cpf)) {
			int i = this.procurarIndice(cpf);
			c = clientes[i];
		} else {
			throw new ClienteInexistenteException(cpf);
		}

		return c;
	}

	/**
	 * M�todo auxiliar que retorna o �ndice da ocorr�ncia do array que
	 * cont�m um objeto Cliente cujo CPF � igual ao CPF passado como par�metro.
	 *
	 * @param cpf o CPF a ser procurado nos clientes do array.
	 *
	 * @return int o �ndice da ocorr�ncia do array que cont�m um objeto Cliente
	 *         cujo CPF � igual ao CPF passado como par�metro. Se este objeto
	 *         n�o for encontrado, o retorno � -1.
	 */
	private int procurarIndice(String cpf) {

		int i = 0;
		int ind = -1;
		boolean achou = false;

		while ((i < indice) && !achou) {
			if ((clientes[i].getCpf()).equals(cpf)) {
				ind = i;
				achou = true;
			}
			i = i + 1;
		}
		return ind;
	}

	/**
	 * Exclui um cliente armazenado no array. A exclus�o � feita colocando-se
	 * a �ltima ocorr�ncia na ocorr�ncia a ser exclu�da e se decrementando 1 do
	 * �ndice.
	 *
	 * @param cpf o CPF do cliente que ser� exclu�do do array.
	 *
	 * @exception ClienteInexistenteException lan�ada quando o cliente a ser exclu�do
	 *            n�o existe no array. A procura � feita por CPF.
	 */
	public void remover(String cpf) throws ClienteInexistenteException {

		if (existe(cpf)) {
			int i = this.procurarIndice(cpf);
			clientes[i] = clientes[indice - 1];
			clientes[indice - 1] = null;
			indice = indice - 1;
		} else {
			throw new ClienteInexistenteException(cpf);
		}
	}
}
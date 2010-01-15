package qualiti.banco.contas;

/**
 * Implementa��o da interface que define os m�todos de acesso aos dados de conta 
 * em um mecanismo de armazenamento de dados. Esta implementa��o � realizada atrav�s
 * do armazenamento de objetos do tipo conta abstrata em um array interno de contas
 * abstratas existente em mem�ria e inicializado com 100 posi��es fixas. Este array
 * suporta armazenamento de objetos de qualquer sub-tipo de conta abstrata. 
 *
 * @author Qualiti <a href="mailto:qualiti@qualiti.com.br">qualiti@qualiti.com.br</a>
 *
 * @version 1.0 
 *
 * @see qualiti.banco.contas.ContaAbstrata
 * @see qualiti.banco.clientes.RepositorioContas
 */
public class RepositorioContasBDR implements RepositorioContas {

	/**
	 * Array interno de contas abstratas.
	 */
	private ContaAbstrata[] contas;
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
	 * o array de contas com 100 ocorr�ncias, onde 100 � o tamanho da cache.
	 */
	public RepositorioContasBDR() {

		indice = 0;
		contas = new ContaAbstrata[tamCache];
	}

	/**
	 * Cadastra os dados de uma conta no array, inserindo o objeto recebido
	 * como par�metro na primeira ocorr�ncia vaga daquele.
	 * 
	 * @param c a conta com os dados a serem cadastrados.
	 *
	 * @see Q1 Por que este m�todo n�o lan�a a exce��o de conta j� existente ??
	 * 
	 * @see Q2 Por que este m�todo n�o testa a exist�ncia de uma conta com mesmo
	 *         n�mero da conta passada no array ??
	 */
	public void inserir(ContaAbstrata c) {

		contas[indice] = c;
		indice = indice + 1;
	}

	/**
	 * M�todo auxiliar que retorna o �ndice da ocorr�ncia do array que 
	 * cont�m um objeto ContaAbstrata cujo n�mero � igual ao n�mero passado 
	 * como par�metro. 
	 * 
	 * @param num o n�mero a ser procurado nas contas do array.
	 *        
	 * @return int o �ndice da ocorr�ncia do array que cont�m um objeto ContaAbstrata
	 *         cujo n�mero � igual ao n�mero passado como par�metro. Se este objeto 
	 *         n�o for encontrado, o retorno � -1.  
	 */
	private int procurarIndice(String num) {

		int i = 0;
		int ind = -1;
		boolean achou = false;

		while ((i < indice) && !achou) {
			if ((contas[i].getNumero()).equals(num)) {
				ind = i;
				achou = true;
			}
			i = i + 1;
		}
		return ind;
	}

	/**
	 * Verifica se uma conta existe armazenado no array.
	 * 
	 * @param num o n�mero da conta cuja exist�ncia no array 
	 *        ser� verificada.
	 * 
	 * @return boolean true se a conta existir no array e
	 *         false caso contr�rio.
	 */
	public boolean existe(String num) {

		boolean resp = false;
		int i = this.procurarIndice(num);
		if (i != -1) {
			resp = true;
		}

		return resp;
	}

	/**
	 * Atualiza os dados de uma conta no array em mem�ria, trocando
	 * o objeto atual do array pelo objeto passado como par�metro.
	 * 
	 * @param c a conta com os dados a serem atualizados. 
	 * 
	 * @exception ContaInexistenteException lan�ada quando a conta a ter seus dados 
	 *            atualizados n�o existe no array. A procura � feita pelo n�mero.
	 */
	public void atualizar(ContaAbstrata c) throws ContaInexistenteException {

		int i = procurarIndice(c.getNumero());
		if (i != -1) {
			contas[i] = c;
		} else {
			throw new ContaInexistenteException(c.getNumero());
		}
	}

	/**
	 * Retorna uma conta armazenada no array.
	 * 
	 * @param num o n�mero da conta que ser� procurada no array.
	 *        
	 * @return ContaAbstrata a conta com seus dados lidos a partir do array. Pode ser
	 *         qualquer sub-tipo de conta abstrata. 
	 *
	 * @exception ContaInexistenteException lan�ada quando a conta a ter seus dados 
	 *            lidos n�o existe no array. A procura � feita pelo n�mero.
	 */
	public ContaAbstrata procurar(String num)
		throws ContaInexistenteException {

		ContaAbstrata c = null;
		if (existe(num)) {
			int i = this.procurarIndice(num);
			c = contas[i];
		} else {
			throw new ContaInexistenteException(num);
		}

		return c;
	}

	/**
	 * Exclui uma conta armazenada no array. A exclus�o � feita colocando-se
	 * a �ltima ocorr�ncia na ocorr�ncia a ser exclu�da e se decrementando 1 do
	 * �ndice. 
	 * 
	 * @param num o n�mero da conta que ser� exclu�da do array.
	 *
	 * @exception ContaInexistenteException lan�ada quando a conta a ser exclu�da
	 *            n�o existe no array. A procura � feita por n�mero.
	 */
	public void remover(String num) throws ContaInexistenteException {

		if (existe(num)) {
			int i = this.procurarIndice(num);
			contas[i] = contas[indice - 1];
			contas[indice - 1] = null;
			indice = indice - 1;
		} else {
			throw new ContaInexistenteException(num);
		}
	}
}
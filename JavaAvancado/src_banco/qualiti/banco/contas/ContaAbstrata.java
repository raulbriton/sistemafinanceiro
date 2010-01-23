package qualiti.banco.contas;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import qualiti.banco.clientes.Cliente;

/**
 * Classe abstrata b�sica que representa uma entidade geral conta, com seus dados, valida��es
 * dos mesmos e suas opera��es relacionadas. Esta � a super-classe da hierarquia dos
 * diversos tipos de contas existentes, agregando elementos e opera��es comuns a 
 * todos os sub-tipos de conta existentes.
 * 
 * @author Qualiti <a href="mailto:qualiti@qualiti.com.br">qualiti@qualiti.com.br</a>
 *
 * @version 1.0 
 */
@Entity
@Table( name="tb_conta" )
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn( name="tipo", discriminatorType=DiscriminatorType.INTEGER)
@DiscriminatorValue("0")
public abstract class ContaAbstrata {

	@Id
	@Column ( name="id" )
	private int id;
	/**
	 * O n�mero da conta.
	 */
	@Column ( name="numero" )
	private String numero;
	/**
	 * O saldo da conta.
	 */
	@Column ( name="saldo" )
	private double saldo;
	/**
	 * O cliente associado � conta.
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="tb_cliente_cpf")
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Cliente cliente;

	public ContaAbstrata() {

	}
	
	/**
	 * O construtor da classe. Inicializa os atributos com os valores passados como
	 * par�metro chamando os m�todos sets dos mesmos.
	 * 
	 * @param num o n�mero da conta.
	 * @param c o cliente da conta.  
	 */
	public ContaAbstrata(String num, Cliente c) {
		// Chama o construtor sobrecarregado desta classe que recebe um n�mero,
		// um saldo e um cliente. Neste caso, passa zero para o saldo.
		this(num, 0, c);
	}

	/**
	 * O construtor da classe. Inicializa os atributos com os valores passados como
	 * par�metro chamando os m�todos sets dos mesmos.
	 * 
	 * @param num o n�mero da conta.
	 * @param s o saldo inicial da conta. 
	 * @param c o cliente da conta.  
	 */
	public ContaAbstrata(String num, double s, Cliente c) {

		setNumero(num);
		setSaldo(s);
		setCliente(c);

	}

	/**
	 * Credita um dado valor no saldo atual da conta.
	 * 
	 * @param valor o valor a ser creditado.
	 */
	public void creditar(double valor) {

		saldo = saldo + valor;
	}

	/**
	 * M�todo abstrato com sem�ntica de d�bito a ser implementado pelos sub-tipos de
	 * conta abstrata. Define uma opera��o de d�bito com possibilidade de checagem 
	 * de saldo antes da efetiva��o da opera��o.
	 * 
	 * @param valor o valor a ser debitado.
	 *
	 * @exception SaldoInsuficienteException lan�ada quando o valor passado como
	 *            par�metro � maior que o saldo da conta. 
	 */
	public abstract void debitar(double valor)
		throws SaldoInsuficienteException;

	/**
	 * Retorna o cliente associado � conta.
	 * 
	 * @return Cliente o cliente associado � conta.
	 */
	public Cliente getCliente() {

		return cliente;
	}

	/**
	 * Retorna o n�mero da conta.
	 * 
	 * @return String o n�mero da conta.
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Retorna o saldo da conta.
	 * 
	 * @return double o saldo da conta.
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * Atualiza o cliente associado � conta.
	 * 
	 * @param cliente o novo valor.
	 *
	 * @see Q1 O cliente da conta pode ser nulo ?? 
	 */
	public void setCliente(Cliente cliente) {

		this.cliente = cliente;
	}

	/**
	 * Atualiza o n�mero da conta.
	 * 
	 * @param num o novo valor.
	 *
	 * @see Q1 O n�mero da conta pode ser nulo ou branco ?? 
	 * 
	 * @see Q2 Uma vez definido para uma dada conta, o n�mero da mesma pode 
	 *         mudar, j� que, por defini��o, n�mero � a chave de uma conta ??
	 *         Como se pode definir bem no JAVA a quest�o de n�o alterar 
	 *         atributos que definem a chave de uma entidade ??  
	 */
	public void setNumero(String num) {
		this.numero = num;
	}

	/**
	 * Atualiza o saldo da conta.
	 * 
	 * @param valor o novo valor do saldo.
	 *
	 * @see Q1 O saldo pode ser menor que zero ??
	 */
	public void setSaldo(double valor) {
		saldo = valor;
	}

	/**
	 * Transfere um dado valor da conta para uma conta destino passada como par�metro.
	 * 
	 * @param c a conta destino.
	 * @param v o valor a ser transferido.
	 *
	 * @exception SaldoInsuficienteException se o saldo da conta for menor que o valor
	 *            a ser transferido.
	 */
	public void transferir(ContaAbstrata c, double v)
		throws SaldoInsuficienteException {

		this.debitar(v);
		c.creditar(v);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

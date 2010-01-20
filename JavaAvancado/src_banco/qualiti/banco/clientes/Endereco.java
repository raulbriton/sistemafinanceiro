package qualiti.banco.clientes;

/**
 * Classe b�sica que representa uma entidade endereco, com seus dados, valida��es
 * dos mesmos e suas opera��es relacionadas.
 *
 * @author Qualiti <a href="mailto:qualiti@qualiti.com.br">qualiti@qualiti.com.br</a>
 *
 * @version 1.0
 */
public class Endereco {

	/** CEP do endereco. */
	private String CEP;
	
	/** N�mero do endereco. */
	private String numero;
	
	/** Complemento textual do endereco. */
	private String complemento;

	
	public Endereco(String CEP, String numero, String complemento){
		this.CEP = CEP;
		this.numero = numero;
		this.complemento = complemento;
	}
	
	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cep) {
		CEP = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}

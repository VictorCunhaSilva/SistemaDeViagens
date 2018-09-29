package modelo;

public class Item {

	private int sequencial,idPrestacao;
	private Double valor;
	private String descricao;
	
	public Item() {}

	public Item(int sequencial, int idPrestacao, Double valor, String descricao) {
		super();
		this.sequencial = sequencial;
		this.idPrestacao = idPrestacao;
		this.valor = valor;
		this.descricao = descricao;
	}

	public int getSequencial() {
		return sequencial;
	}

	public void setSequencial(int sequencial) {
		this.sequencial = sequencial;
	}

	public int getIdPrestacao() {
		return idPrestacao;
	}

	public void setIdPrestacao(int idPrestacao) {
		this.idPrestacao = idPrestacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + idPrestacao;
		result = prime * result + sequencial;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idPrestacao != other.idPrestacao)
			return false;
		if (sequencial != other.sequencial)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [sequencial=" + sequencial + ", idPrestacao=" + idPrestacao + ", valor=" + valor + ", descricao="
				+ descricao + ", getSequencial()=" + getSequencial() + ", getIdPrestacao()=" + getIdPrestacao()
				+ ", getValor()=" + getValor() + ", getDescricao()=" + getDescricao() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
	
	
}
package modelo;

public class CentroDeCusto {

	private int id;
	private Double valorAlocado,valorRestante;
	private String nome;
	
	public CentroDeCusto() {}

	public CentroDeCusto(int id, Double valorAlocado, Double valorRestante, String nome) {
		super();
		this.id = id;
		this.valorAlocado = valorAlocado;
		this.valorRestante = valorRestante;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getValorAlocado() {
		return valorAlocado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((valorAlocado == null) ? 0 : valorAlocado.hashCode());
		result = prime * result + ((valorRestante == null) ? 0 : valorRestante.hashCode());
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
		CentroDeCusto other = (CentroDeCusto) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (valorAlocado == null) {
			if (other.valorAlocado != null)
				return false;
		} else if (!valorAlocado.equals(other.valorAlocado))
			return false;
		if (valorRestante == null) {
			if (other.valorRestante != null)
				return false;
		} else if (!valorRestante.equals(other.valorRestante))
			return false;
		return true;
	}

	public void setValorAlocado(Double valorAlocado) {
		this.valorAlocado = valorAlocado;
	}

	public Double getValorRestante() {
		return valorRestante;
	}

	public void setValorRestante(Double valorRestante) {
		this.valorRestante = valorRestante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "CentroDeCusto [id=" + id + ", valorAlocado=" + valorAlocado + ", valorRestante=" + valorRestante
				+ ", nome=" + nome + ", getId()=" + getId() + ", getValorAlocado()=" + getValorAlocado()
				+ ", hashCode()=" + hashCode() + ", getValorRestante()=" + getValorRestante() + ", getNome()="
				+ getNome() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

}
package modelo;

public class Viagem {
	private String destino,origem;
	private int id,data,horario,maxVagas,vagas;
	private double preco;
	
	public Viagem() {
		
	}

	public Viagem(String destino, String origem, int id, int data, int horario, int maxVagas, int vagas, double preco) {
		super();
		this.destino = destino;
		this.origem = origem;
		this.id = id;
		this.data = data;
		this.horario = horario;
		this.maxVagas = maxVagas;
		this.vagas = vagas;
		this.preco = preco;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getHorario() {
		return horario;
	}

	public void setHorario(int horario) {
		this.horario = horario;
	}

	public int getMaxVagas() {
		return maxVagas;
	}

	public void setMaxVagas(int maxVagas) {
		this.maxVagas = maxVagas;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + horario;
		result = prime * result + id;
		result = prime * result + maxVagas;
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + vagas;
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
		Viagem other = (Viagem) obj;
		if (data != other.data)
			return false;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (horario != other.horario)
			return false;
		if (id != other.id)
			return false;
		if (maxVagas != other.maxVagas)
			return false;
		if (origem == null) {
			if (other.origem != null)
				return false;
		} else if (!origem.equals(other.origem))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (vagas != other.vagas)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Viagem [destino=" + destino + ", origem=" + origem + ", id=" + id + ", data=" + data + ", horario="
				+ horario + ", maxVagas=" + maxVagas + ", vagas=" + vagas + ", preco=" + preco + ", getDestino()="
				+ getDestino() + ", getOrigem()=" + getOrigem() + ", getId()=" + getId() + ", getData()=" + getData()
				+ ", getHorario()=" + getHorario() + ", getMaxVagas()=" + getMaxVagas() + ", getVagas()=" + getVagas()
				+ ", getPreco()=" + getPreco() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}

}

package modelo;

public class PassagemAerea {
	private int numero, idViagem, cpfComprador,horario,data;

	public PassagemAerea() {
		
	}
	
	public PassagemAerea(int numero, int idViagem, int cpfComprador, int horario, int data) {
		super();
		this.numero = numero;
		this.idViagem = idViagem;
		this.cpfComprador = cpfComprador;
		this.horario = horario;
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cpfComprador;
		result = prime * result + data;
		result = prime * result + horario;
		result = prime * result + idViagem;
		result = prime * result + numero;
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
		PassagemAerea other = (PassagemAerea) obj;
		if (cpfComprador != other.cpfComprador)
			return false;
		if (data != other.data)
			return false;
		if (horario != other.horario)
			return false;
		if (idViagem != other.idViagem)
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getIdViagem() {
		return idViagem;
	}

	public void setIdViagem(int idViagem) {
		this.idViagem = idViagem;
	}

	public int getCpfComprador() {
		return cpfComprador;
	}

	public void setCpfComprador(int cpfComprador) {
		this.cpfComprador = cpfComprador;
	}

	public int getHorario() {
		return horario;
	}

	public void setHorario(int horario) {
		this.horario = horario;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "PassagemAerea [numero=" + numero + ", idViagem=" + idViagem + ", cpfComprador=" + cpfComprador
				+ ", horario=" + horario + ", data=" + data + ", hashCode()=" + hashCode() + ", getNumero()="
				+ getNumero() + ", getIdViagem()=" + getIdViagem() + ", getCpfComprador()=" + getCpfComprador()
				+ ", getHorario()=" + getHorario() + ", getData()=" + getData() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}
}

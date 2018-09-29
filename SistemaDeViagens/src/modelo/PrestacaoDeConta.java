package modelo;

import java.util.ArrayList;

public class PrestacaoDeConta {
	
	private int idViagem, idUsuario, idPrestacao;
	private ArrayList<Item>item;
	
	public PrestacaoDeConta() {}

	public PrestacaoDeConta(int idViagem, int idUsuario, int idPrestacao, ArrayList<Item> item) {
		super();
		this.idViagem = idViagem;
		this.idUsuario = idUsuario;
		this.idPrestacao = idPrestacao;
		this.item = item;
	}

	public int getIdViagem() {
		return idViagem;
	}

	public void setIdViagem(int idViagem) {
		this.idViagem = idViagem;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdPrestacao() {
		return idPrestacao;
	}

	public void setIdPrestacao(int idPrestacao) {
		this.idPrestacao = idPrestacao;
	}

	public ArrayList<Item> getItem() {
		return item;
	}

	public void setItem(ArrayList<Item> item) {
		this.item = item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPrestacao;
		result = prime * result + idUsuario;
		result = prime * result + idViagem;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
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
		PrestacaoDeConta other = (PrestacaoDeConta) obj;
		if (idPrestacao != other.idPrestacao)
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		if (idViagem != other.idViagem)
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PrestacaoDeConta [idViagem=" + idViagem + ", idUsuario=" + idUsuario + ", idPrestacao=" + idPrestacao
				+ ", item=" + item + ", getIdViagem()=" + getIdViagem() + ", getIdUsuario()=" + getIdUsuario()
				+ ", getIdPrestacao()=" + getIdPrestacao() + ", getItem()=" + getItem() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}


}

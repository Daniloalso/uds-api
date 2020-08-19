package br.com.uds.api.model;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;


@Entity
public class Pedido implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull(message = "Tamanho do açai é obrigatório!")
	@ManyToOne()
	@JoinColumn(name = "tamanho_id")	
	private Tamanho tamanho;
	
	@NotNull(message = "Sabor do açai é obrigatório!")
	@ManyToOne()
	@JoinColumn(name = "sabor_id")
	private Sabor sabor;
	
	@ManyToMany(mappedBy = "pedidos")
	private Set<ItemExtra> itensExtra = new HashSet<>();
	
	@Transient
	private double valorTotal = 0;
	
	@Transient
	private Integer tempoTotal= 0;

	public Pedido() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}
	

	public Set<ItemExtra> getItensExtra() {
		return itensExtra;
	}
	
	public double getValorTotal() {
		this.itensExtra.forEach((item) -> this.valorTotal = this.valorTotal + item.getValor());
		
		return this.valorTotal + this.tamanho.getValor();
	}

	public Integer getTempoTotal() {
		this.itensExtra.forEach((item) -> this.tempoTotal = this.tempoTotal + item.getTempo());
		
		return this.tempoTotal +  + getSabor().getTempo();
	}

	public void setItensExtra(Set<ItemExtra> itensExtra) {
		this.itensExtra = itensExtra;
	}
	
	
	
}

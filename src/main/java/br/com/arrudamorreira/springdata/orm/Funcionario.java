package br.com.arrudamorreira.springdata.orm;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private String cpf;
	
	private Double salaraio;
	
	private LocalDate dataDeContratacao;
	
	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;
	
	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "funcionarios_unidades", joinColumns = {@JoinColumn(name="fk_funcionario")}, 
	 inverseJoinColumns = {@JoinColumn(name= "fk_unidade") })
	private List<Unidade> unidades;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalaraio() {
		return salaraio;
	}

	public void setSalaraio(Double salaraio) {
		this.salaraio = salaraio;
	}

	public LocalDate getDataDeContratacao() {
		return dataDeContratacao;
	}

	public void setDataDeContratacao(LocalDate dataDeContratacao) {
		this.dataDeContratacao = dataDeContratacao;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Unidade> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", salaraio=" + salaraio
				+ ", dataDeContratacao=" + dataDeContratacao + ", cargo=" + cargo + ", unidades=" + unidades + "]";
	}
}

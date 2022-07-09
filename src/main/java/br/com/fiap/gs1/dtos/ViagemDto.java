package br.com.fiap.gs1.dtos;

import java.sql.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


import br.com.fiap.gs1.models.Viagem;

public class ViagemDto {
	
	private int id;
	
	
	private Date dataDecolagem;
	
	@Min(value = 1)
	private int duracaoEstadia;
	
	@Min(value = 1)
	private int qtdAssentos;
	
	@Pattern(regexp = "[a-z]{4,4}-[0-9]{4,4}")
	private String modeloNave;
	
	@NotBlank
	@NotNull
	private String nomePrimeiroComandante;
	
	@Pattern(regexp = "[A-Z]{3,3}-[0-9]{4,4}-[0-9]{3,3}")
	private String matriculaPrimeiroComandante;
	
	@NotBlank
	@NotNull
	private String nomeSegundoComandante;
	
	@Pattern(regexp = "[A-Z]{3,3}-[0-9]{4,4}-[0-9]{3,3}")
	private String matriculaSegundoComandante;
	
	private Date dataRetorno;
	
	
	public ViagemDto() {
		
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataDecolagem() {
		return dataDecolagem;
	}

	public void setDataDecolagem(Date dataDecolagem) {
		this.dataDecolagem = dataDecolagem;
	}

	public int getDuracaoEstadia() {
		return duracaoEstadia;
	}

	public void setDuracaoEstadia(int duracaoEstadia) {
		this.duracaoEstadia = duracaoEstadia;
	}

	public int getQtdAssentos() {
		return qtdAssentos;
	}

	public void setQtdAssentos(int qtdAssentos) {
		this.qtdAssentos = qtdAssentos;
	}

	public String getModeloNave() {
		return modeloNave;
	}

	public void setModeloNave(String modeloNave) {
		this.modeloNave = modeloNave;
	}

	public String getNomePrimeiroComandante() {
		return nomePrimeiroComandante;
	}

	public void setNomePrimeiroComandante(String nomePrimeiroComandante) {
		this.nomePrimeiroComandante = nomePrimeiroComandante;
	}

	public String getMatriculaPrimeiroComandante() {
		return matriculaPrimeiroComandante;
	}

	public void setMatriculaPrimeiroComandante(String matriculaPrimeiroComandante) {
		this.matriculaPrimeiroComandante = matriculaPrimeiroComandante;
	}

	public String getNomeSegundoComandante() {
		return nomeSegundoComandante;
	}

	public void setNomeSegundoComandante(String nomeSegundoComandante) {
		this.nomeSegundoComandante = nomeSegundoComandante;
	}

	public String getMatriculaSegundoComandante() {
		return matriculaSegundoComandante;
	}

	public void setMatriculaSegundoComandante(String matriculaSegundoComandate) {
		this.matriculaSegundoComandante = matriculaSegundoComandate;
	}
	
	public Date getDataRetorno() {
		return dataRetorno;
	}


	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
	
	
	
	
	
	public void fromViagem(Viagem viagem) {
		this.id = viagem.getId();
		this.dataDecolagem = viagem.getDataDecolagem();
		this.duracaoEstadia = viagem.getDuracaoEstadia();
		this.qtdAssentos = viagem.getQtdAssentos();
		this.modeloNave = viagem.getModeloNave();
		this.nomePrimeiroComandante = viagem.getNomePrimeiroComandante();
		this.matriculaPrimeiroComandante = viagem.getMatriculaPrimeiroComandante();
		this.nomeSegundoComandante = viagem.getNomeSegundoComandante();
		this.matriculaSegundoComandante = viagem.getMatriculaSegundoComandante();
	}

	
	
}

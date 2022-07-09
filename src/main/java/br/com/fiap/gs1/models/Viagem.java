package br.com.fiap.gs1.models;



import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Viagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date dataDecolagem;
	
	
	private int duracaoEstadia;
	private int qtdAssentos;
	private String modeloNave;
	
	@Column(nullable = false)
	private String nomePrimeiroComandante;
	
	private String matriculaPrimeiroComandante;
	
	@Column(nullable = false)
	private String nomeSegundoComandante;
	
	private String matriculaSegundoComandante;
	

	public Viagem() {
		
	}

	public Viagem(int id, Date dataDecolagem, int duracaoEstadia, int qtdAssentos, String modeloNave,
			String nomePrimeiroComandante, String matriculaPrimeiroComandante, String nomeSegundoComandante,
			String matriculaSegundoComandante) {
		this.id = id;
		this.dataDecolagem = dataDecolagem;
		this.duracaoEstadia = duracaoEstadia;
		this.qtdAssentos = qtdAssentos;
		this.modeloNave = modeloNave;
		this.nomePrimeiroComandante = nomePrimeiroComandante;
		this.matriculaPrimeiroComandante = matriculaPrimeiroComandante;
		this.nomeSegundoComandante = nomeSegundoComandante;
		this.matriculaSegundoComandante = matriculaSegundoComandante;
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

	public void setMatriculaSegundoComandante(String matriculaSegundoComandante) {
		this.matriculaSegundoComandante = matriculaSegundoComandante;
	}
	
	
	public String calcularDataRetorno() {
		String dataDecolagemAux = dataDecolagem.toString();
		String[] anoMesDia = dataDecolagemAux.split("-");
		
		LocalDate dataRetorno = LocalDate.of(Integer.parseInt(anoMesDia[0]), Integer.parseInt(anoMesDia[1]), Integer.parseInt(anoMesDia[2]));
		
		dataRetorno = dataRetorno.plusDays(duracaoEstadia + 2 * 260);
		
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = dataRetorno.format(dateFormat);
		return dataFormatada;
		
	}

	
	public String getDataDecolagemFormatada() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = dateFormat.format(dataDecolagem);
		return dataFormatada;
	}
	

	
	

	
}

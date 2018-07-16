package model.Bean;

import model.DAO.ConsignadoDAO;

public class Consignado {
 
	    private String cpf;
	    private double renda_liquida;
	    private double margem;
	    private String agencia;
	    private String conta;
	
public Consignado() {
	
}

public Consignado(String cpf, double renda_liquida, double margem, String agencia, String conta) {
    this.cpf = cpf;
    this.renda_liquida = renda_liquida;
    this.margem = margem;
    this.agencia = agencia;
    this.conta = conta;
}

public String getCpf() {
	return cpf;
}

public void setCpf(String cpf) {
	this.cpf = cpf;
}

public double getRenda_liquida() {
	return renda_liquida;
}

public void setRenda_liquida(double renda_liquida) {
	this.renda_liquida = renda_liquida;
}

public double getMargem() {
	return margem;
}

public void setMargem(double margem) {
	this.margem = margem;
}

public String getAgencia() {
	return agencia;
}

public void setAgencia(String agencia) {
	this.agencia = agencia;
}

public String getConta() {
	return conta;
}

public void setConta(String conta) {
	this.conta = conta;
}

public boolean consultar(Consignado consig) throws Exception {

    ConsignadoDAO consigDao = new ConsignadoDAO();
    boolean resposta = consigDao.consultar(consig);
    return resposta;
}

}

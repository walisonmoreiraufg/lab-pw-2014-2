package hello;

import java.text.DecimalFormat;

public class Calculo {

	private Double operador1;
	private String operacao;
	private Double operador2;
	private Double resultado;
	

	public Double getOperador1() {return operador1;}
	public void setOperador1(Double operador1) {this.operador1 = operador1;}
	public String getOperacao() {return operacao;}
	public void setOperacao(String operacao) {this.operacao = operacao;}
	public Double getOperador2() {return operador2;}
	public void setOperador2(Double operador2) {this.operador2 = operador2;}
	public Double getResultado() {return resultado;}
	public void setResultado(Double resultado) {this.resultado = resultado;}
	
	public void calcular() {
		resultado = 0.0;
		if (operacao.equals("+")) {
			resultado = operador1 + operador2;
		} else if (operacao.equals("-")) {
			resultado = operador1 - operador2;
		} else if (operacao.equals("*")) {
			resultado = operador1 * operador2;
		} else if (operacao.equals("/")) {
			resultado = operador1 / operador2;
		}
	}
	
	public String getResultadoFormatado() {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(resultado);
	}
}

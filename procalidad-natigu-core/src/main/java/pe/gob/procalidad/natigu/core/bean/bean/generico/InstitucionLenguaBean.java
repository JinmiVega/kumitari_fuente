package pe.gob.procalidad.natigu.core.bean.bean.generico;

import java.math.BigInteger;

import pe.gob.procalidad.natigu.core.bean.bean.BaseBean;


public class InstitucionLenguaBean extends BaseBean{
	
	//atributos
	private LenguaBean lenguaBean =  new LenguaBean();
	private InstitucionBean institucionBean =  new InstitucionBean();
	private String strFechaRegistro;
	
	private BigInteger totalBasico = new BigInteger("0");
	private BigInteger totalIntermedio = new BigInteger("0");
	private BigInteger totalAvanzado = new BigInteger("0");
	
	//Constructor
	
	public InstitucionLenguaBean() {
		super();
	}

	//Getters and Setter
	
	public LenguaBean getLenguaBean() {
		return lenguaBean;
	}

	public void setLenguaBean(LenguaBean lenguaBean) {
		this.lenguaBean = lenguaBean;
	}

	public InstitucionBean getInstitucionBean() {
		return institucionBean;
	}

	public void setInstitucionBean(InstitucionBean institucionBean) {
		this.institucionBean = institucionBean;
	}

	//toString
	
	public String getStrFechaRegistro() {
		return strFechaRegistro;
	}

	public void setStrFechaRegistro(String strFechaRegistro) {
		this.strFechaRegistro = strFechaRegistro;
	}

	@Override
	public String toString() {
		return "InstitucionLenguaBean [lenguaBean=" + lenguaBean
				+ ", institucionBean=" + institucionBean + "]";
	}

	public BigInteger getTotalBasico() {
		return totalBasico;
	}

	public void setTotalBasico(BigInteger totalBasico) {
		this.totalBasico = totalBasico;
	}

	public BigInteger getTotalIntermedio() {
		return totalIntermedio;
	}

	public void setTotalIntermedio(BigInteger totalIntermedio) {
		this.totalIntermedio = totalIntermedio;
	}

	public BigInteger getTotalAvanzado() {
		return totalAvanzado;
	}

	public void setTotalAvanzado(BigInteger totalAvanzado) {
		this.totalAvanzado = totalAvanzado;
	}
}
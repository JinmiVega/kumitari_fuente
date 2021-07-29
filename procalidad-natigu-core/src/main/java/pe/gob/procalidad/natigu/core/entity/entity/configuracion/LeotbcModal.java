package pe.gob.procalidad.natigu.core.entity.entity.configuracion;

import java.io.Serializable;

 

import java.util.Date;

import javax.persistence.*;  



@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbc_modal.listar",
			procedureName = "conf.fun_leotbcmodal_buscar_x_filtros", 
			resultClasses = LeotbcModal.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nommoda", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitmoda", type = Integer.class)}),

	@NamedStoredProcedureQuery(name = "leotbc_modal.insertar", 
			procedureName = "conf.fun_leotbcmodal_insertar", 
			resultClasses = LeotbcModal.class, parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codmoda", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nommoda", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitmoda", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomimagm", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = String.class)}),
//
			@NamedStoredProcedureQuery(name = "leotbc_modal.actualizar", 
			procedureName = "conf.fun_leotbcmodal_actualizar", 
	 		resultClasses = LeotbcModal.class, parameters = { 
				
//			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_return", type = Integer.class),
		 	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmoda", type = long.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nommoda", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitmoda", type = int.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomimagm", type = String.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = int.class),  
	 		}), 
	 																
	
			@NamedStoredProcedureQuery(name = "leotbc_modal.eliminar", 
			procedureName = "conf.fun_leotbcmodal_eliminar", 
	 		resultClasses = LeotbcModal.class, parameters = {
				
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_return", type = Integer.class),
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmoda", type = long.class),  
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class) }), 
		 
			@NamedStoredProcedureQuery(name = "leotbc_modal.buscar_por_codigo", 
			procedureName = "conf.fun_leotbcmodal_buscar_x_codigo", 
		 	resultClasses = LeotbcModal.class, parameters = { 
				
		 	@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmoda", type = long.class) }), 
		})

@Entity
@Table(name="leotbc_modal")

public class LeotbcModal implements Serializable {
			

	private static final long serialVersionUID = 1L;
	
	public Date getdFecmod() {
		return dFecmod;
	}



	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Id
	@Column(name="n_codmoda")
	private Integer nCodmoda;

	
	@Column(name="n_tm1sitmoda")
	private Integer nTm1sitmoda;
	
	@Column(name="v_nomimagm")
	private String vNomimagm;

	



	@Column(name="n_codusumod")
	private String vCodusumod;

	@Column(name="v_codusureg")
	private String vCodusureg;

	
	@Column(name="v_extimagm")
	private String vExtimagm;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_nommoda")
	private String vNommoda;


	@Column(name="v_ubiimagm")
	private String vUbiimagm;
	
	private String v_nomcortoSituacion; 

	public void setdFecmod(Date dFecmod) {
		this.dFecmod = dFecmod;
	}


	public Date getdFecreg() {
		return dFecreg;
	}


	public void setdFecreg(Date dFecreg) {
		this.dFecreg = dFecreg;
	}


	public Integer getnCodmoda() {
		return nCodmoda;
	}


	public void setnCodmoda(Integer nCodmoda) {
		this.nCodmoda = nCodmoda;
	}


	public Integer getnTm1sitmoda() {
		return nTm1sitmoda;
	}


	public void setnTm1sitmoda(Integer nTm1sitmoda) {
		this.nTm1sitmoda = nTm1sitmoda;
	}


	public String getvCodusumod() {
		return vCodusumod;
	}


	public void setvCodusumod(String vCodusumod) {
		this.vCodusumod = vCodusumod;
	}


	public String getvCodusureg() {
		return vCodusureg;
	}


	public void setvCodusureg(String vCodusureg) {
		this.vCodusureg = vCodusureg;
	}


	public String getvExtimagm() {
		return vExtimagm;
	}


	public void setvExtimagm(String vExtimagm) {
		this.vExtimagm = vExtimagm;
	}


	public String getvFlgest() {
		return vFlgest;
	}


	public void setvFlgest(String vFlgest) {
		this.vFlgest = vFlgest;
	}


	public String getvHostmod() {
		return vHostmod;
	}


	public void setvHostmod(String vHostmod) {
		this.vHostmod = vHostmod;
	}


	public String getvHostreg() {
		return vHostreg;
	}


	public void setvHostreg(String vHostreg) {
		this.vHostreg = vHostreg;
	}


	public String getvNommoda() {
		return vNommoda;
	}


	public void setvNommoda(String vNommoda) {
		this.vNommoda = vNommoda;
	}


	public String getvUbiimagm() {
		return vUbiimagm;
	}


	public void setvUbiimagm(String vUbiimagm) {
		this.vUbiimagm = vUbiimagm;
	}


	public String getV_nomcortoSituacion() {
		return v_nomcortoSituacion;
	}


	public void setV_nomcortoSituacion(String v_nomcortoSituacion) {
		this.v_nomcortoSituacion = v_nomcortoSituacion;
	}

	public String getvNomimagm() {
		return vNomimagm;
	}


	public void setvNomimagm(String vNomimagm) {
		this.vNomimagm = vNomimagm;
	}
	
	public LeotbcModal() {
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
		
		
	}
}

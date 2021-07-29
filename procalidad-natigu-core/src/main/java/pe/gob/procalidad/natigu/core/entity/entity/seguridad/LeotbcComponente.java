package pe.gob.procalidad.natigu.core.entity.entity.seguridad;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


@NamedStoredProcedureQueries({	
	
	@NamedStoredProcedureQuery(name = "leotbc_componente.listar", 
	procedureName = "segu.fun_leotbccomponente_listar", 
	resultClasses = LeotbcComponente.class,
	parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codcompa", type = Long.class),
		@StoredProcedureParameter(mode = ParameterMode.IN,  name = "p_codperfil", type = Long.class)
	}),
		
})

@Entity
@Table(name="leotbc_componente", schema="segu")
public class LeotbcComponente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Column(name="n_codcompa")
	private Long nCodcompa;

	@Id
	@Column(name="n_codcompo")
	private Long nCodcompo;

	@Column(name="n_codusumod")
	private Long nCodusumod;

	@Column(name="n_codusureg")
	private Long nCodusureg;

	@Column(name="v_descompo")
	private String vDescompo;

	@Column(name="v_flgestado")
	private String vFlgestado;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_nomcompo")
	private String vNomcompo;
	
	@Column(name="n_codperfil")
	private Long nCodperfil;
	
	@Column(name="v_flgdelete")
	private String vFlgdelete;

	@Column(name="v_flgread")
	private String vFlgread;

	@Column(name="v_flgwrite")
	private String vFlgwrite;

	public LeotbcComponente() {
	}

	

	public Date getdFecmod() {
		return dFecmod;
	}



	public void setdFecmod(Date dFecmod) {
		this.dFecmod = dFecmod;
	}



	public Date getdFecreg() {
		return dFecreg;
	}



	public void setdFecreg(Date dFecreg) {
		this.dFecreg = dFecreg;
	}



	public Long getnCodcompa() {
		return nCodcompa;
	}



	public void setnCodcompa(Long nCodcompa) {
		this.nCodcompa = nCodcompa;
	}



	public Long getnCodcompo() {
		return nCodcompo;
	}



	public void setnCodcompo(Long nCodcompo) {
		this.nCodcompo = nCodcompo;
	}



	public Long getnCodusumod() {
		return nCodusumod;
	}



	public void setnCodusumod(Long nCodusumod) {
		this.nCodusumod = nCodusumod;
	}



	public Long getnCodusureg() {
		return nCodusureg;
	}



	public void setnCodusureg(Long nCodusureg) {
		this.nCodusureg = nCodusureg;
	}



	public String getvDescompo() {
		return vDescompo;
	}



	public void setvDescompo(String vDescompo) {
		this.vDescompo = vDescompo;
	}



	public String getvFlgestado() {
		return vFlgestado;
	}



	public void setvFlgestado(String vFlgestado) {
		this.vFlgestado = vFlgestado;
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



	public String getvNomcompo() {
		return vNomcompo;
	}



	public void setvNomcompo(String vNomcompo) {
		this.vNomcompo = vNomcompo;
	}



	public Long getNCodcompa() {
		return this.nCodcompa;
	}

	public void setNCodcompa(Long nCodcompa) {
		this.nCodcompa = nCodcompa;
	}

	public Long getNCodcompo() {
		return this.nCodcompo;
	}

	public void setNCodcompo(Long nCodcompo) {
		this.nCodcompo = nCodcompo;
	}

	public Long getNCodusumod() {
		return this.nCodusumod;
	}

	public void setNCodusumod(Long nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public Long getNCodusureg() {
		return this.nCodusureg;
	}

	public void setNCodusureg(Long nCodusureg) {
		this.nCodusureg = nCodusureg;
	}

	public String getVDescompo() {
		return this.vDescompo;
	}

	public void setVDescompo(String vDescompo) {
		this.vDescompo = vDescompo;
	}

	public String getVFlgestado() {
		return this.vFlgestado;
	}

	public void setVFlgestado(String vFlgestado) {
		this.vFlgestado = vFlgestado;
	}

	public String getVHostmod() {
		return this.vHostmod;
	}

	public void setVHostmod(String vHostmod) {
		this.vHostmod = vHostmod;
	}

	public String getVHostreg() {
		return this.vHostreg;
	}

	public void setVHostreg(String vHostreg) {
		this.vHostreg = vHostreg;
	}

	public String getVNomcompo() {
		return this.vNomcompo;
	}

	public void setVNomcompo(String vNomcompo) {
		this.vNomcompo = vNomcompo;
	}

}
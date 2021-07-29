package pe.gob.procalidad.natigu.core.entity.entity.configuracion;

import java.io.Serializable; 

import javax.persistence.*;  

import java.util.Date;


@NamedStoredProcedureQueries({
			@NamedStoredProcedureQuery(name = "leotbc_mensajes.insertar",
			procedureName = "conf.fun_leotbcmensajes_insertar", 
			resultClasses = LeotbcMensajes.class, 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codmensajes", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_mensaje", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2tipomensaje", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
			}),
			@NamedStoredProcedureQuery(name = "leotbc_mensajes.buscarPorFiltros",
			procedureName = "conf.fun_leotbcmensajes_buscar_x_filtros", 
			resultClasses = LeotbcMensajes.class, 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2tipomensaje", type = int.class)
			}),
			@NamedStoredProcedureQuery(name = "leotbc_mensajes.buscarPorCodigo",
			procedureName = "conf.fun_leotbcmensajes_buscar_x_codigo", 
			resultClasses = LeotbcMensajes.class, 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmensajes", type = Long.class)
			}),
			@NamedStoredProcedureQuery(name = "leotbc_mensajes.actulizar",
			procedureName = "conf.fun_leotbcmensajes_actulizar", 
			resultClasses = LeotbcMensajes.class, 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmensajes", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlengua", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_mensaje", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm2tipomensaje", type = Integer.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
			}),
			@NamedStoredProcedureQuery(name = "leotbc_mensajes.eliminar",
			procedureName = "conf.fun_leotbcmensajes_eliminar", 
			resultClasses = LeotbcMensajes.class, 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmensajes", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
			}),

})

@Entity
@Table(name="leotbc_mensajes")
public class LeotbcMensajes implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;
		
	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Id
	@Column(name="n_codmensajes")
	private Long nCodmensajes;
	
	@Column(name="n_codlengua")
	private Long ncodlengua;

	@Column(name="n_tm2tipomensaje")
	private int n_tm2tipomensaje;

	@Column(name="v_mensaje")
	private String vmensaje;

	@Column(name="v_codusureg")
	private Long vCodusureg;
	
	@Column(name="n_codusumod")
	private Long ncodusumod;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;
	
	@Column(name="v_nomlengua")
	private String vNomlengua;
	
	@Column(name="v_nomcorto")
	private String vNomcorto;
	
	public LeotbcMensajes() {
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

	public Long getnCodmensajes() {
		return nCodmensajes;
	}

	public void setnCodmensajes(Long nCodmensajes) {
		this.nCodmensajes = nCodmensajes;
	}

	public Long getNcodlengua() {
		return ncodlengua;
	}

	public void setNcodlengua(Long ncodlengua) {
		this.ncodlengua = ncodlengua;
	}

	public int getN_tm2tipomensaje() {
		return n_tm2tipomensaje;
	}

	public void setN_tm2tipomensaje(int n_tm2tipomensaje) {
		this.n_tm2tipomensaje = n_tm2tipomensaje;
	}

	public String getVmensaje() {
		return vmensaje;
	}

	public void setVmensaje(String vmensaje) {
		this.vmensaje = vmensaje;
	}

	public Long getvCodusureg() {
		return vCodusureg;
	}

	public void setvCodusureg(Long vCodusureg) {
		this.vCodusureg = vCodusureg;
	}

	public Long getNcodusumod() {
		return ncodusumod;
	}

	public void setNcodusumod(Long ncodusumod) {
		this.ncodusumod = ncodusumod;
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

	public String getvNomlengua() {
		return vNomlengua;
	}

	public void setvNomlengua(String vNomlengua) {
		this.vNomlengua = vNomlengua;
	}

	public String getvNomcorto() {
		return vNomcorto;
	}

	public void setvNomcorto(String vNomcorto) {
		this.vNomcorto = vNomcorto;
	}
	
	
}

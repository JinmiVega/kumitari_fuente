package pe.gob.procalidad.natigu.core.entity.entity.general;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedStoredProcedureQueries({
																							 
	@NamedStoredProcedureQuery(name = "leotbdArrastrarDet.buscar_x_codigo", procedureName = "gene.fun_leotbd_detoraxarrastrar_buscar_x_cod", 
			resultClasses = LeotbdArrastraOraDet.class, 											 
			parameters = 
			{	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codoraxarrastrar", type = Long.class)  
			}),
			
	@NamedStoredProcedureQuery(name = "leotbdArrastrarDet.buscar_x_Oracion", procedureName = "gene.fun_leotbd_detoraxArrastrar_buscarXoracion", 
			resultClasses = LeotbdArrastraOraDet.class,  						  
			parameters = 
			{
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codarrastraora", type = Long.class) 
			}),
	@NamedStoredProcedureQuery(name = "leotbdArrastrarDet.buscar_TodoxTEM", procedureName = "gene.fun_leotbd_detoraxarrastrar_Todo", 
			resultClasses = LeotbdArrastraOraDet.class,  						  
			parameters = 
			{
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class) 
			}),
									   												  
	@NamedStoredProcedureQuery(name = "leotbdArrastrarDet.insertar", procedureName = "gene.fun_leotbd_detoraxArrastrar_insertar", 
			resultClasses = LeotbdArrastraOraDet.class, 
			parameters = 
			{
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codoraxArrastrar", 	type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codarrastraora", 		type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numorden", 	type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_oraciondet", 	type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", 		type = Long.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", 			type = String.class) 
			})
		
		,
		@NamedStoredProcedureQuery(name = "leotbdArrastrarDet.eliminar", procedureName = "gene.fun_leotbd_leotbd_detoraxArrastrar_eliminar", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codoraxArrastrar", type = Long.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class) }),
		@NamedStoredProcedureQuery(name = "leotbdArrastrarDet.actualizar", procedureName = "gene.fun_leotbd_leotbd_detoraxArrastrar_actualizar", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codoraxArrastrar", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numorden", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_oraciondet", type = String.class),  
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)

		})

})

@Entity
@Table(name = "gene.leotbd_detoraxArrastrar")
public class LeotbdArrastraOraDet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "n_codoraxArrastrar")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nCodoraxArrastrar;

	@Column(name = "n_codarrastraora")
	private Long nCodarrastraora;
	
	@Column(name = "v_numorden")
	private String vNumorden;

	@Column(name = "v_oraciondet")
	private String vOraciondet;

	  
	@Column(name = "v_flgest")
	private String vFlgest;

	@Column(name = "n_codusureg")
	private Long nCodusureg;

	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecreg")
	private Date dFecreg;

	@Column(name = "v_hostreg")
	private String vHostreg;

	@Column(name = "n_codusumod")
	private Long nCodusumod;

	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecmod")
	private Date dFecmod;

	@Column(name = "v_hostmod")
	private String vHostmod;
	
	private String v_tituloTipo;
	private String v_tituloOra;
	private Long n_codmatpej;
	private String v_oracion;

	public LeotbdArrastraOraDet() {
		super();
	}

	public Long getnCodoraxArrastrar() {
		return nCodoraxArrastrar;
	}

	public void setnCodoraxArrastrar(Long nCodoraxArrastrar) {
		this.nCodoraxArrastrar = nCodoraxArrastrar;
	}

	public Long getnCodarrastraora() {
		return nCodarrastraora;
	}

	public void setnCodarrastraora(Long nCodarrastraora) {
		this.nCodarrastraora = nCodarrastraora;
	}

	public String getvNumorden() {
		return vNumorden;
	}

	public void setvNumorden(String vNumorden) {
		this.vNumorden = vNumorden;
	}

	public String getvOraciondet() {
		return vOraciondet;
	}

	public void setvOraciondet(String vOraciondet) {
		this.vOraciondet = vOraciondet;
	}

	public String getvFlgest() {
		return vFlgest;
	}

	public void setvFlgest(String vFlgest) {
		this.vFlgest = vFlgest;
	}

	public Long getnCodusureg() {
		return nCodusureg;
	}

	public void setnCodusureg(Long nCodusureg) {
		this.nCodusureg = nCodusureg;
	}

	public Date getdFecreg() {
		return dFecreg;
	}

	public void setdFecreg(Date dFecreg) {
		this.dFecreg = dFecreg;
	}

	public String getvHostreg() {
		return vHostreg;
	}

	public void setvHostreg(String vHostreg) {
		this.vHostreg = vHostreg;
	}

	public Long getnCodusumod() {
		return nCodusumod;
	}

	public void setnCodusumod(Long nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public Date getdFecmod() {
		return dFecmod;
	}

	public void setdFecmod(Date dFecmod) {
		this.dFecmod = dFecmod;
	}

	public String getvHostmod() {
		return vHostmod;
	}

	public void setvHostmod(String vHostmod) {
		this.vHostmod = vHostmod;
	}
	
	public String getV_tituloTipo() {
		return v_tituloTipo;
	}

	public void setV_tituloTipo(String v_tituloTipo) {
		this.v_tituloTipo = v_tituloTipo;
	}

	public String getV_tituloOra() {
		return v_tituloOra;
	}

	public void setV_tituloOra(String v_tituloOra) {
		this.v_tituloOra = v_tituloOra;
	}

	public Long getN_codmatpej() {
		return n_codmatpej;
	}

	public void setN_codmatpej(Long n_codmatpej) {
		this.n_codmatpej = n_codmatpej;
	}

	public String getV_oracion() {
		return v_oracion;
	}

	public void setV_oracion(String v_oracion) {
		this.v_oracion = v_oracion;
	}

	@Override
	public String toString() {
		return "LeotbdArrastraOraDet [nCodoraxArrastrar=" + nCodoraxArrastrar
				+ ", nCodarrastraora=" + nCodarrastraora + ", vNumorden="
				+ vNumorden + ", vOraciondet=" + vOraciondet + ", vFlgest="
				+ vFlgest + ", nCodusureg=" + nCodusureg + ", dFecreg="
				+ dFecreg + ", vHostreg=" + vHostreg + ", nCodusumod="
				+ nCodusumod + ", dFecmod=" + dFecmod + ", vHostmod="
				+ vHostmod + "]";
	}

	 

	 

}

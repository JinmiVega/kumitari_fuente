package pe.gob.procalidad.natigu.core.entity.entity.general;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


@NamedStoredProcedureQueries({
																							 
	@NamedStoredProcedureQuery(name = "leotbd_altxtextopalabracorrec.buscar_x_texto_palbcorrec", 
			procedureName = "gene.fun_leotbd_altxtextopalabracorrec_buscar_x_texto_palbcorrec", 
			resultClasses = LeotbdAltxtextopalabracorrec.class, 											 
			parameters = 
			{	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtextopalabracorrec", type = long.class) ,
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_palabracorrecta", 	type = long.class)
			}),
			
	@NamedStoredProcedureQuery(name = "leotbd_altxtextopalabracorrec.buscar_x_textopalco", 
			procedureName = "gene.fun_leotbd_altxtextopalabracorrec_buscar_x_textopalco", 
			resultClasses = LeotbdAltxtextopalabracorrec.class, 
			parameters = 
			{
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtextopalabracorrec", type = long.class) 
			}),
	
									   												  
	@NamedStoredProcedureQuery(name = "leotbd_altxtextopalabracorrec.insertar", 
			procedureName = "gene.fun_leotbd_altxtextopalabracorrec_insertar", 
			parameters = 
			{
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codaltern", 	type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtextopalabracorrec", 		type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nroorden", 		type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_palabracorrecta", 	type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_alternativa", 	type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_rptaestado", 		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", 		type = Long.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", 			type = String.class) 
			})
		
		,
		@NamedStoredProcedureQuery(name = "leotbd_altxtextopalabracorrec.eliminar", 
		procedureName = "gene.fun_leotbd_altxtextopalabracorrec_eliminar", 
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtextopalabracorrec", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_palabracorrecta", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class) 
		
		}),
		@NamedStoredProcedureQuery(name = "leotbd_altxtextopalabracorrec.actualizar", 
		procedureName = "gene.fun_leotbd_altxtextopalabracorrec_actualizar", 
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codaltern", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nroorden", 		type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_palabracorrecta", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_alternativa", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_rptaestado", type = String.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)

		}),
		
		@NamedStoredProcedureQuery(name = "leotbd_altxtextopalabracorrec.listar_todoAprendizaje", 
		procedureName = "gene.fun_leotbd_altxtextopalabracorrec_listartodo", 
		resultClasses = LeotbdAltxtextopalabracorrec.class, 
		parameters = {
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", type = long.class) 
		}),
		
		@NamedStoredProcedureQuery(name = "leotbd_altxtextopalabracorrec.listarNombrePalabraCorrecta_codigoCab", 
		procedureName = "gene.fun_leotbd_altxtextopalabracorrec_listarcodigocadetalle", 
		resultClasses = LeotbdAltxtextopalabracorrec.class, 
		parameters = {
				
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nroorden", type = Long.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtextopalabracorrec", type = Long.class)
		})

})

@Entity
@Table(name="leotbd_altxtextopalabracorrec")
public class LeotbdAltxtextopalabracorrec implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codaltern")
	private long nCodaltern;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Column(name="n_codtextopalabracorrec")
	private long nCodtextopalabracorrec;

	@Column(name="n_codusumod")
	private long nCodusumod;

	@Column(name="n_codusureg")
	private long nCodusureg;

	@Column(name="v_alternativa")
	private String vAlternativa;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_palabracorrecta")
	private String vPalabracorrecta;

	@Column(name="v_rptaestado")
	private String vRptaestado;
		
	/********************/	
	
	@Column(name="n_codmatpej")
	private long nCodmatpej;

	@Column(name="v_titulotipo")
	private String vTitulotipo;
	
	@Column(name="v_tituloora")
	private String vTituloora;
	
	@Column(name="v_texto")
	private String vTexto;
	
	@Column(name="v_comentario")
	private String vComentario;
	
	@Column(name="n_nroOrden")
	private long nNroOrden;
	
	public LeotbdAltxtextopalabracorrec() {
	}

	public long getnCodaltern() {
		return nCodaltern;
	}

	public void setnCodaltern(long nCodaltern) {
		this.nCodaltern = nCodaltern;
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

	public long getnCodtextopalabracorrec() {
		return nCodtextopalabracorrec;
	}

	public void setnCodtextopalabracorrec(long nCodtextopalabracorrec) {
		this.nCodtextopalabracorrec = nCodtextopalabracorrec;
	}

	public long getnCodusumod() {
		return nCodusumod;
	}

	public void setnCodusumod(long nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public long getnCodusureg() {
		return nCodusureg;
	}

	public void setnCodusureg(long nCodusureg) {
		this.nCodusureg = nCodusureg;
	}

	public String getvAlternativa() {
		return vAlternativa;
	}

	public void setvAlternativa(String vAlternativa) {
		this.vAlternativa = vAlternativa;
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

	public String getvPalabracorrecta() {
		return vPalabracorrecta;
	}

	public void setvPalabracorrecta(String vPalabracorrecta) {
		this.vPalabracorrecta = vPalabracorrecta;
	}

	public String getvRptaestado() {
		return vRptaestado;
	}

	public void setvRptaestado(String vRptaestado) {
		this.vRptaestado = vRptaestado;
	}

	public long getnCodmatpej() {
		return nCodmatpej;
	}

	public void setnCodmatpej(long nCodmatpej) {
		this.nCodmatpej = nCodmatpej;
	}

	public String getvTitulotipo() {
		return vTitulotipo;
	}

	public void setvTitulotipo(String vTitulotipo) {
		this.vTitulotipo = vTitulotipo;
	}

	public String getvTituloora() {
		return vTituloora;
	}

	public void setvTituloora(String vTituloora) {
		this.vTituloora = vTituloora;
	}

	public String getvTexto() {
		return vTexto;
	}

	public void setvTexto(String vTexto) {
		this.vTexto = vTexto;
	}

	public String getvComentario() {
		return vComentario;
	}

	public void setvComentario(String vComentario) {
		this.vComentario = vComentario;
	}

	public long getnNroOrden() {
		return nNroOrden;
	}

	public void setnNroOrden(long nNroOrden) {
		this.nNroOrden = nNroOrden;
	}

	
	
	
}
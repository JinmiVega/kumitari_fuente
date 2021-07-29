package pe.gob.procalidad.natigu.core.entity.entity.general;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@NamedStoredProcedureQueries({
	 
		@NamedStoredProcedureQuery(name = "leotbd_altxtextopalabraence.buscar_x_codigo", 
		procedureName = "gene.fun_leotbd_altxtextopalabraence_buscar_x_codigo", 
		resultClasses = LeotbdAltxtextopalabraence.class, 											 
		parameters = {	
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codaltern", 			type = long.class)					
					}),
			
		@NamedStoredProcedureQuery(name = "leotbd_altxtextopalabraence.buscar_x_textopalco", 
		procedureName = "gene.fun_leotbd_altxtextopalabraence_buscar_x_textopalaence", 
		resultClasses = LeotbdAltxtextopalabraence.class, 
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtextopalabraence", 	type = long.class) 
					}),
	
									   												  
		@NamedStoredProcedureQuery(name = "leotbd_altxtextopalabraence.insertar", 
		procedureName = "gene.fun_leotbd_altxtextopalabraence_insertar", 
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codaltern", 			type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nroorden", 			type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codtextopalabraence", 	type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_palabraencerrada",		type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", 			type = Long.class), 
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", 				type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_palabrarpta",		    type = String.class)
					})
		
		,
		@NamedStoredProcedureQuery(name = "leotbd_altxtextopalabraence.eliminar", 
		procedureName = "gene.fun_leotbd_altxtextopalabraence_eliminar", 
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codaltern", 			type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", 			type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 				type = String.class) 
		
					}),
		@NamedStoredProcedureQuery(name = "leotbd_altxtextopalabraence.actualizar", 
		procedureName = "gene.fun_leotbd_altxtextopalabraence_actualizar", 
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codaltern", 			type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nroorden", 			type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_palabraencerrada", 	type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", 			type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", 				type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_palabrarpta",		    type = String.class)
					}),
		
		@NamedStoredProcedureQuery(name = "leotbd_altxtextopalabraence.cabeceraydetalle", 
		procedureName = "gene.fun_leotbctextopalabraencerrada_cabeceraydetalle", 
		resultClasses = LeotbdAltxtextopalabraence.class, 
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmatpej", 			type = long.class) 
					
		
		})

})

@Entity
@Table(name="leotbd_altxtextopalabraence")
public class LeotbdAltxtextopalabraence implements Serializable {
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

	@Column(name="n_codtextopalabraence")
	private long nCodtextopalabraence;

	@Column(name="n_codusumod")
	private long nCodusumod;

	@Column(name="n_codusureg")
	private long nCodusureg;

	@Column(name="n_tm1sitaltxtexto")
	private long nTm1sitaltxtexto;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_palabraencerrada")
	private String vPalabraencerrada;
	
	@Column(name="n_codmatpej")
	private long nCodmatpej;
	
	@Column(name="v_titulotipo")
	private String vTitulotipo;
	
	@Column(name="v_titulo")
	private String vTitulo;
	
	@Column(name="v_texto")
	private String vTexto;
	
	@Column(name="v_comentario")
	private String vComentario;
	
	@Column(name="n_nroOrden")
	private long nNroOrden;
	
	@Column(name="v_palabrarpta")
	private String vPalabrarpta;
	
	public LeotbdAltxtextopalabraence() {
	}

	public long getnCodmatpej() {
		return nCodmatpej;
	}

	public void setnCodmatpej(long nCodmatpej) {
		this.nCodmatpej = nCodmatpej;
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

	public long getnCodtextopalabraence() {
		return nCodtextopalabraence;
	}

	public void setnCodtextopalabraence(long nCodtextopalabraence) {
		this.nCodtextopalabraence = nCodtextopalabraence;
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

	public long getnTm1sitaltxtexto() {
		return nTm1sitaltxtexto;
	}

	public void setnTm1sitaltxtexto(long nTm1sitaltxtexto) {
		this.nTm1sitaltxtexto = nTm1sitaltxtexto;
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

	public String getvPalabraencerrada() {
		return vPalabraencerrada;
	}

	public void setvPalabraencerrada(String vPalabraencerrada) {
		this.vPalabraencerrada = vPalabraencerrada;
	}

	public String getvTitulo() {
		return vTitulo;
	}

	public void setvTitulo(String vTitulo) {
		this.vTitulo = vTitulo;
	}

	public String getvTexto() {
		return vTexto;
	}

	public void setvTexto(String vTexto) {
		this.vTexto = vTexto;
	}

	public String getvTitulotipo() {
		return vTitulotipo;
	}

	public void setvTitulotipo(String vTitulotipo) {
		this.vTitulotipo = vTitulotipo;
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

	public String getvPalabrarpta() {
		return vPalabrarpta;
	}

	public void setvPalabrarpta(String vPalabrarpta) {
		this.vPalabrarpta = vPalabrarpta;
	}
	


	
}
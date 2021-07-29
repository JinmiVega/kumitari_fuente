package pe.gob.procalidad.natigu.core.entity.entity.general;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "leotbccrucigrama.buscar_por_codrelacion", procedureName = "gene.fun_leotbccrucigrama_buscar_x_codigo", resultClasses = LeotbcCrucigrama.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codcrucigrama", type = long.class) 
		}),
		@NamedStoredProcedureQuery(name = "leotbccrucigrama.buscar_por_ejercicio", procedureName = "gene.fun_leotbccrucigrama_buscar_x_ejercicio", resultClasses = LeotbcCrucigrama.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codejercicio", type = long.class) 
		}),
		@NamedStoredProcedureQuery(name = "leotbccrucigrama.insertar", procedureName = "gene.fun_leotbcrelacion_insertar", resultClasses = LeotbcCrucigrama.class, parameters = {
				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codrelacion", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codejercicio", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_palabra", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_definicion", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_orientacion", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_orden", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
		}),
		@NamedStoredProcedureQuery(name = "leotbccrucigrama.eliminar", procedureName = "gene.fun_leotbccrucigrama_eliminar", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codcrucigrama", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
		}),
		@NamedStoredProcedureQuery(name = "leotbccrucigrama.actualizar", procedureName = "gene.fun_leotbccrucigrama_actualizar", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codcrucigrama", type = Long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_palabra", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_definicion", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_orientacion", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_orden", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
		})
})


@Entity
@Table(name="leotbc_crucigrama")
public class LeotbcCrucigrama implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;
	@Id
	@Column(name="n_codcrucigrama")
	private Integer nCodcrucigrama;

	@Column(name="n_codejercicio")
	private Integer nCodejercicio;

	@Column(name="n_codusumod")
	private Integer nCodusumod;

	@Column(name="n_codusureg")
	private Integer nCodusureg;

	@Column(name="n_orden")
	private Integer nOrden;

	@Column(name="n_orientacion")
	private Integer nOrientacion;

	@Column(name="v_definicion")
	private String vDefinicion;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_palabra")
	private String vPalabra;

	public LeotbcCrucigrama() {
	}

	public Date getDFecmod() {
		return this.dFecmod;
	}

	public void setDFecmod(Date dFecmod) {
		this.dFecmod = dFecmod;
	}

	public Date getDFecreg() {
		return this.dFecreg;
	}

	public void setDFecreg(Date dFecreg) {
		this.dFecreg = dFecreg;
	}

	public Integer getNCodcrucigrama() {
		return this.nCodcrucigrama;
	}

	public void setNCodcrucigrama(Integer nCodcrucigrama) {
		this.nCodcrucigrama = nCodcrucigrama;
	}

	public Integer getNCodejercicio() {
		return this.nCodejercicio;
	}

	public void setNCodejercicio(Integer nCodejercicio) {
		this.nCodejercicio = nCodejercicio;
	}

	public Integer getNCodusumod() {
		return this.nCodusumod;
	}

	public void setNCodusumod(Integer nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public Integer getNCodusureg() {
		return this.nCodusureg;
	}

	public void setNCodusureg(Integer nCodusureg) {
		this.nCodusureg = nCodusureg;
	}

	public Integer getNOrden() {
		return this.nOrden;
	}

	public void setNOrden(Integer nOrden) {
		this.nOrden = nOrden;
	}

	public Integer getNOrientacion() {
		return this.nOrientacion;
	}

	public void setNOrientacion(Integer nOrientacion) {
		this.nOrientacion = nOrientacion;
	}

	public String getVDefinicion() {
		return this.vDefinicion;
	}

	public void setVDefinicion(String vDefinicion) {
		this.vDefinicion = vDefinicion;
	}

	public String getVFlgest() {
		return this.vFlgest;
	}

	public void setVFlgest(String vFlgest) {
		this.vFlgest = vFlgest;
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

	public String getVPalabra() {
		return this.vPalabra;
	}

	public void setVPalabra(String vPalabra) {
		this.vPalabra = vPalabra;
	}

}
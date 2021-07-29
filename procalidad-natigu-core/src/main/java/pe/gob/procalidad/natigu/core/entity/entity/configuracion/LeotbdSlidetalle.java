package pe.gob.procalidad.natigu.core.entity.entity.configuracion;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@NamedStoredProcedureQueries({

	@NamedStoredProcedureQuery(name = "leotbd_slidetalle.insertar", 
			procedureName = "conf.fun_leotbd_slidetalle_insertar", 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codslidet", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codslide", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomslide", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)
	  }),
	
	 @NamedStoredProcedureQuery(name = "leotbd_slidetalle.eliminar", 
	 procedureName = "conf.fun_leotbd_slidetalle_eliminar", 
 		parameters = { 
		 @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_return", type = Integer.class),
 		 @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codslidet", type = long.class),  
 		 @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class), 
 		 @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class) 
	  })
	 ,
	 @NamedStoredProcedureQuery(name = "leotbd_slidetalle.listado_buscar_por_codigoslider", 
	 procedureName = "conf.fun_leotbd_slidetalle_listadobuscar_x_codigoslider", 
 		resultClasses = LeotbdSlidetalle.class, 
 		parameters = { 
 		 @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codslide", type = long.class) 
 	  }),
	 @NamedStoredProcedureQuery(name = "leotbd_slidetalle.buscar_x_slider_activo", 
	 	procedureName = "conf.fun_leotbd_slidetalle_buscar_x_slider_activo", 
 		resultClasses = LeotbdSlidetalle.class, 
 		parameters = {}
	 )
})

@Entity
@Table(name="leotbd_slidetalle")
public class LeotbdSlidetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="n_codslidet")
	private long nCodslidet;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecmod")
	private Date dFecmod;

	@Temporal(TemporalType.DATE)
	@Column(name="d_fecreg")
	private Date dFecreg;

	@Column(name="n_codusumod")
	private long nCodusumod;

	@Column(name="n_codusureg")
	private long nCodusureg;

	@Column(name="n_tm1sitslidet")
	private long nTm1sitslidet;

	@Column(name="v_flgest")
	private String vFlgest;

	@Column(name="v_hostmod")
	private String vHostmod;

	@Column(name="v_hostreg")
	private String vHostreg;

	@Column(name="v_nomslidet")
	private String vNomslidet;
	
	@Column(name="n_codslide")
	private long nCodslide;

	@Column(name="n_item")
	private Integer nItem;

	public LeotbdSlidetalle() {
	}

	public long getNCodslidet() {
		return this.nCodslidet;
	}

	public void setNCodslidet(long nCodslidet) {
		this.nCodslidet = nCodslidet;
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

	public long getNCodusumod() {
		return this.nCodusumod;
	}

	public void setNCodusumod(long nCodusumod) {
		this.nCodusumod = nCodusumod;
	}

	public long getNCodusureg() {
		return this.nCodusureg;
	}

	public void setNCodusureg(long nCodusureg) {
		this.nCodusureg = nCodusureg;
	}

	public long getNTm1sitslidet() {
		return this.nTm1sitslidet;
	}

	public void setNTm1sitslidet(long nTm1sitslidet) {
		this.nTm1sitslidet = nTm1sitslidet;
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

	public String getVNomslidet() {
		return this.vNomslidet;
	}

	public void setVNomslidet(String vNomslidet) {
		this.vNomslidet = vNomslidet;
	}

	public long getnCodslide() {
		return nCodslide;
	}

	public void setnCodslide(long nCodslide) {
		this.nCodslide = nCodslide;
	}

	public Integer getnItem() {
		return nItem;
	}

	public void setnItem(Integer nItem) {
		this.nItem = nItem;
	}

}
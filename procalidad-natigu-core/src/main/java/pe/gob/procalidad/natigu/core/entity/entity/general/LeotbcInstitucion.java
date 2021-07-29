package pe.gob.procalidad.natigu.core.entity.entity.general;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "leotbcInstitucion.listar", 
			procedureName = "gene.fun_leotbcinstitucion_buscar_x_filtros", 
			resultClasses = LeotbcInstitucion.class, 
			parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nominsti", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitinst", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tpinst", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codregion", type = String.class)

			}),
	@NamedStoredProcedureQuery(name = "leotbcInstitucion.insertar", 
			procedureName = "gene.fun_leotbcinstitucion_insertar", 
			parameters = {		
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codinsti", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomcorto", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitinst", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nominsti", type =  String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_descripc", type =  String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddirec", type =  long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codsitins", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tpinst", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tpact", type =  int.class),
			
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numugel", type =   String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmodul", type =  String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlocal", type =  String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codubigeo", type = String.class),
			
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_dirinstit", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tparge", type = int.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_latitud", type =   String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_longitud", type =  String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_urlpagweb", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_telefono", type =   String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correo", type =  String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = long.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)

			
			}),
			@NamedStoredProcedureQuery(name = "leotbcInstitucion.listarCombo", 
			procedureName = "gene.fun_leotbcinstitucion_listarCombo", 
			resultClasses = LeotbcInstitucion.class, 
			parameters = {			

			}),
			@NamedStoredProcedureQuery(name = "leotbcInstitucion.actulizarUbicacion", 
			procedureName = "gene.fun_leotbcinstitucion_actulizar_ubicacion",  
			parameters = {			
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = long.class),
										
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codubigeo", type = String.class),
					
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_dirinstit", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tparge", type = int.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_latitud", type =   String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_longitud", type =  String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_urlpagweb", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_telefono", type =   String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correo", type =  String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
			}),
			@NamedStoredProcedureQuery(name = "leotbcInstitucion.eliminar", 
			procedureName = "gene.fun_leotbcinstitucion_eliminar",  
			parameters = {			
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
			}),
			@NamedStoredProcedureQuery(name = "leotbcInstitucion.actualizar", 
			procedureName = "gene.fun_leotbcinstitucion_actulizar",  
			parameters = {			
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomcorto", type = String.class),					
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nominsti", type =  String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_descripc", type =  String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitinst", type = int.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tpinst", type = int.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1tpact", type =  int.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_numugel", type =   String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codmodul", type =  String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codlocal", type =  String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
			}),
			@NamedStoredProcedureQuery(name = "leotbcInstitucion.buscarPorCodigo", 
			procedureName = "gene.fun_leotbcinstitucion_buscar_x_codigo", 
			resultClasses = LeotbcInstitucion.class, 
			parameters = {			
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codinsti", type = long.class)
			}),
			@NamedStoredProcedureQuery(name = "leotbcInstitucion.actulizarDirector", 
			procedureName = "gene.fun_leotbcinstitucion_actulizar_director",  
			parameters = {			
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = long.class),
										
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_coddirec", type = int.class),					
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_urlpagweb", type = String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_telefono", type =   String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_correo", type =  String.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusumod", type = long.class),
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostmod", type = String.class)
			}),
			@NamedStoredProcedureQuery(name = "leotbcInstitucion.listarDirectores", 
			procedureName = "gene.fun_leotbcinstitucion_listar_directores", 
			resultClasses = LeotbcInstitucion.class,
			parameters = {		
			
			}),
			@NamedStoredProcedureQuery(name = "leotbcInstitucion.listarPorTipoUsuario", 
			procedureName = "gene.fun_leotbcinstitucion_listarcomboxtipousuario",  
			resultClasses = LeotbcInstitucion.class,
			parameters = {			
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperso", type = int.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codperfil", type = int.class)
			}),
			@NamedStoredProcedureQuery(name = "leotbcInstitucion.listarExiste", 
			procedureName = "gene.fun_leotbcinstitucion_buscar_existe", 
			resultClasses = LeotbcInstitucion.class, 
			parameters = {			
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codisnti", type = long.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomcorto", type = String.class)
			})
	 /*@NamedStoredProcedureQuery(name = "ngtbcLengua.actualizar", procedureName = "fun_ngtbcLengua_insertar", 
	 		resultClasses = LeotbcLengua.class, parameters = { 
	 		@StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_codlengua", type = Integer.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_nomlengua", type = String.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_tm1sitlen", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_codusureg", type = int.class), 
	 		@StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hostreg", type = String.class)

		})*/ 
})

@Entity
@Table(name = "leotbc_institucion",schema="gene")
public class LeotbcInstitucion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "n_codisnti")
	private Long nCodInstitucion;
	
	@Column(name = "v_nominsti")
	private String vNomInstitucion;
	
	@Column(name = "v_descripc")
	private String vDescripcion;
	
	@Column(name = "n_coddirec")
	private Long nCodDireccion;
	
	@Column(name = "n_tm1sitinst")
	private int nTm1sitinst;
	
	@Column(name = "n_tm1tpact")
	private int nTm1tpact;
	
	@Column(name = "n_tm1tpinst")
	private int nTm1tpinst;
	
	@Column(name = "v_numugel")
	private String vNumUgel;
	
	@Column(name = "v_codmodul")
	private String vCodModulo;
	
	@Column(name = "v_codlocal")
	private String vCodLocal;
	
	@Column(name = "n_codregion")
	private Long nCodregion;
	
	@Column(name = "n_codprovin")
	private Long nCodProvincia;
	
	@Column(name = "n_coddistri")
	private Long nCodDistrito;
	
	@Column(name = "v_dirinstit")
	private String vDirinstit;
	
	@Column(name = "n_tm1tparge")
	private int nTm1tParge;
	
	@Column(name = "v_latitud")
	private String vLatitud;
	
	@Column(name = "v_longitud")
	private String vlongitud;
	
	@Column(name = "v_urlpagweb")
	private String vUrlPagWeb;
	
	@Column(name = "v_telefono")
	private String vTelefono;
	
	@Column(name = "v_correo")
	private String vCorreo;
	
	@Column(name = "v_flgest")
	private String vFlgEstado;
	
	@Column(name = "n_codusureg")
	private int nCodUsuRegistro;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecreg")
	private Date dFecRegistro;
	
	@Column(name = "v_hostreg")
	private String vHostRegistro;
	
	@Column(name = "n_codusumod")
	private int nCodUsuModificado;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "d_fecmod")
	private Date dfecModificado;
	

	@Column(name = "v_hostmod")
	private String vHostModificado;
	
	@Column(name = "nombreubigeo")
	private String nombreubigeo;
	
	@Column(name = "v_codubigeo")
	private String vCodubigeo;
	
	@Column(name = "v_nomcorto")
	private String vNomcorto;
	

	private String nombreSituacion;
	private String nombreTipoInstitucion;

	
	
	
	public LeotbcInstitucion() {
		super();
	}

	public Long getnCodInstitucion() {
		return nCodInstitucion;
	}

	public void setnCodInstitucion(Long nCodInstitucion) {
		this.nCodInstitucion = nCodInstitucion;
	}

	public String getvNomInstitucion() {
		return vNomInstitucion;
	}

	public void setvNomInstitucion(String vNomInstitucion) {
		this.vNomInstitucion = vNomInstitucion;
	}

	public String getvDescripcion() {
		return vDescripcion;
	}

	public void setvDescripcion(String vDescripcion) {
		this.vDescripcion = vDescripcion;
	}

	public Long getnCodDireccion() {
		return nCodDireccion;
	}

	public void setnCodDireccion(Long nCodDireccion) {
		this.nCodDireccion = nCodDireccion;
	}



	public String getvNumUgel() {
		return vNumUgel;
	}

	public void setvNumUgel(String vNumUgel) {
		this.vNumUgel = vNumUgel;
	}

	public String getvCodModulo() {
		return vCodModulo;
	}

	public void setvCodModulo(String vCodModulo) {
		this.vCodModulo = vCodModulo;
	}

	public String getvCodLocal() {
		return vCodLocal;
	}

	public void setvCodLocal(String vCodLocal) {
		this.vCodLocal = vCodLocal;
	}

	public Long getnCodregion() {
		return nCodregion;
	}

	public void setnCodregion(Long nCodregion) {
		this.nCodregion = nCodregion;
	}

	public Long getnCodProvincia() {
		return nCodProvincia;
	}

	public void setnCodProvincia(Long nCodProvincia) {
		this.nCodProvincia = nCodProvincia;
	}

	public Long getnCodDistrito() {
		return nCodDistrito;
	}

	public void setnCodDistrito(Long nCodDistrito) {
		this.nCodDistrito = nCodDistrito;
	}

	public String getvDirinstit() {
		return vDirinstit;
	}

	public void setvDirinstit(String vDirinstit) {
		this.vDirinstit = vDirinstit;
	}

	public int getnTm1tParge() {
		return nTm1tParge;
	}

	public void setnTm1tParge(int nTm1tParge) {
		this.nTm1tParge = nTm1tParge;
	}

	public String getvLatitud() {
		return vLatitud;
	}

	public void setvLatitud(String vLatitud) {
		this.vLatitud = vLatitud;
	}

	public String getVlongitud() {
		return vlongitud;
	}

	public void setVlongitud(String vlongitud) {
		this.vlongitud = vlongitud;
	}

	public String getvUrlPagWeb() {
		return vUrlPagWeb;
	}

	public void setvUrlPagWeb(String vUrlPagWeb) {
		this.vUrlPagWeb = vUrlPagWeb;
	}

	public String getvTelefono() {
		return vTelefono;
	}

	public void setvTelefono(String vTelefono) {
		this.vTelefono = vTelefono;
	}

	public String getvCorreo() {
		return vCorreo;
	}

	public void setvCorreo(String vCorreo) {
		this.vCorreo = vCorreo;
	}

	public String getvFlgEstado() {
		return vFlgEstado;
	}

	public void setvFlgEstado(String vFlgEstado) {
		this.vFlgEstado = vFlgEstado;
	}

	public int getnCodUsuRegistro() {
		return nCodUsuRegistro;
	}

	public void setnCodUsuRegistro(int nCodUsuRegistro) {
		this.nCodUsuRegistro = nCodUsuRegistro;
	}

	public Date getdFecRegistro() {
		return dFecRegistro;
	}

	public void setdFecRegistro(Date dFecRegistro) {
		this.dFecRegistro = dFecRegistro;
	}

	public String getvHostRegistro() {
		return vHostRegistro;
	}

	public void setvHostRegistro(String vHostRegistro) {
		this.vHostRegistro = vHostRegistro;
	}

	public int getnCodUsuModificado() {
		return nCodUsuModificado;
	}

	public void setnCodUsuModificado(int nCodUsuModificado) {
		this.nCodUsuModificado = nCodUsuModificado;
	}

	public Date getDfecModificado() {
		return dfecModificado;
	}

	public void setDfecModificado(Date dfecModificado) {
		this.dfecModificado = dfecModificado;
	}
	public String getvCodubigeo() {
		return vCodubigeo;
	}

	public void setvCodubigeo(String vCodubigeo) {
		this.vCodubigeo = vCodubigeo;
	}
	public int getnTm1tpinst() {
		return nTm1tpinst;
	}

	public void setnTm1tpinst(int nTm1tpinst) {
		this.nTm1tpinst = nTm1tpinst;
	}

	public String getvHostModificado() {
		return vHostModificado;
	}

	public void setvHostModificado(String vHostModificado) {
		this.vHostModificado = vHostModificado;
	}

	public int getnTm1tpact() {
		return nTm1tpact;
	}

	public void setnTm1tpact(int nTm1tpact) {
		this.nTm1tpact = nTm1tpact;
	}

	public int getnTm1sitinst() {
		return nTm1sitinst;
	}

	public void setnTm1sitinst(int nTm1sitinst) {
		this.nTm1sitinst = nTm1sitinst;
	}
	public String getNombreSituacion() {
		return nombreSituacion;
	}

	public void setNombreSituacion(String nombreSituacion) {
		this.nombreSituacion = nombreSituacion;
	}

	public String getNombreTipoInstitucion() {
		return nombreTipoInstitucion;
	}

	public void setNombreTipoInstitucion(String nombreTipoInstitucion) {
		this.nombreTipoInstitucion = nombreTipoInstitucion;
	}
	public String getvNomcorto() {
		return vNomcorto;
	}

	public void setvNomcorto(String vNomcorto) {
		this.vNomcorto = vNomcorto;
	}

	public String getNombreubigeo() {
		return nombreubigeo;
	}

	public void setNombreubigeo(String nombreubigeo) {
		this.nombreubigeo = nombreubigeo;
	}
	//toString
	@Override
	public String toString() {
		return "Institucion [nCodInstitucion=" + nCodInstitucion
				+ ", vNomInstitucion=" + vNomInstitucion + ", vDescripcion="
				+ vDescripcion + ", nCodDireccion=" + nCodDireccion
				+ ", nTm1sitinst=" + nTm1sitinst + ", nTm1tpact=" + nTm1tpact
				+ ", nTm1tpinst=" + nTm1tpinst + ", vNumUgel=" + vNumUgel
				+ ", vCodModulo=" + vCodModulo + ", vCodLocal=" + vCodLocal
				+ ", nCodregion=" + nCodregion + ", nCodProvincia="
				+ nCodProvincia + ", nCodDistrito=" + nCodDistrito
				+ ", vDirinstit=" + vDirinstit + ", nTm1tParge=" + nTm1tParge
				+ ", vLatitud=" + vLatitud + ", vlongitud=" + vlongitud
				+ ", vUrlPagWeb=" + vUrlPagWeb + ", vTelefono=" + vTelefono
				+ ", vCorreo=" + vCorreo + ", vFlgEstado=" + vFlgEstado
				+ ", nCodUsuRegistro=" + nCodUsuRegistro + ", dFecRegistro="
				+ dFecRegistro + ", vHostRegistro=" + vHostRegistro
				+ ", nCodUsuModificado=" + nCodUsuModificado
				+ ", dfecModificado=" + dfecModificado + ", vHostModificado="
				+ vHostModificado + ", nombreubigeo=" + nombreubigeo
				+ ", vCodubigeo=" + vCodubigeo + ", vNomcorto=" + vNomcorto
				+ ", nombreSituacion=" + nombreSituacion
				+ ", nombreTipoInstitucion=" + nombreTipoInstitucion + "]";
	}

	

	

}
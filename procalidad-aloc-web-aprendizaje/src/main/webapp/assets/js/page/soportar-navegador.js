//Navegador a soportar [navegador/version]
//var navegadores = ["Chrome", "Firefox", "Internet Explorer"];
//var versiones = ["60", "50", "11"];
var navegadores = ["Chrome", "Firefox"];
var versiones = ["60", "50"];

function navegador() {
	var agente = bowser.name;
    for (var i in navegadores) {
        if (agente.indexOf(navegadores[i]) != -1 && parseInt(bowser.version) >= versiones[i]) {
            return true;
        }
    }
    return false;
}
		
/** INI : main **/
var strNav = "";
for (var i = 0; i < navegadores.length; i++) {
    strNav += navegadores[i] + " " + versiones[i] + ".x";
    if (i < navegadores.length - 1) {
        strNav += ",";
    }
}

if (!navegador()) {
	//redireccionar a page/error/navegador_no_soportado.jsp
	//window.location="C:\AmbDesarrollo\NATIGU\Workspace\procalidad-aloc-web-aprendizaje\src\main\webapp\page\error\navegador_no_soportado.jsp";
	window.location = window.location.origin+window.location.pathname+"/../../errorController/NavegadorNoSoportado";
    //alert("Para este portal \"Ponte en carrera\" se recomienta los navegadores : \n "+strNav);
}
//console.log(window.location.href);
//console.log(window.location.origin+window.location.pathname+"/../../errorController/NavegadorNoSoportado");

/** FIN : main **/
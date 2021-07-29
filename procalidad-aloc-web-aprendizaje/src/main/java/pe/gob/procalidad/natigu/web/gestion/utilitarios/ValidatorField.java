package pe.gob.procalidad.natigu.web.gestion.utilitarios;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorField {

    public static Boolean validarCorreo(String correo) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
        Matcher mather = pattern.matcher(correo);
        return mather.find();
    }

    public static Boolean validarLetras(String field) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher mather = pattern.matcher(field);
        return mather.find();
    }

    public static Boolean validarFecha(String correo) {
        Pattern pattern = Pattern.compile("^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$");
        Matcher mather = pattern.matcher(correo);
        return mather.find();
    }

    public static Boolean validarURL(String correo) {
        Pattern pattern = Pattern.compile("^(?:http(s)?:\\/\\/)?[\\w.-]+(?:\\.[\\w\\.-]+)+[\\w\\-\\.~:/?#[\\]@!\\$&'\\(\\)\\*\\+,;=.]+$");
        Matcher mather = pattern.matcher(correo);
        return mather.find();
    }

    public static Boolean validarMascaraTelefono(String telefono) {
        Pattern pattern = Pattern.compile("^(\\()([0-9+]{0,3})(\\)) ([0-9+]{0,3})-([0-9+]{0,4}) (\\/) (([0-9+]{0,3})-([0-9+]{0,3})-([0-9+]{0,3}))$");
        Matcher mather = pattern.matcher(telefono);
        return mather.find();
    }

}

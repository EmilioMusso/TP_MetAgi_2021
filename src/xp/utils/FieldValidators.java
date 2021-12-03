package xp.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import xp.exceptions.CampoNoAlfabeticoException;
import xp.exceptions.CampoNoNumericoException;
import xp.exceptions.EmailInvalidoException;
import xp.exceptions.NroDocValidoException;
import xp.exceptions.PasswordIncorrectaException;
import xp.exceptions.PasswordInvalidaException;

public class FieldValidators {

	public Boolean esAlfabetico(String str, String campo) throws CampoNoAlfabeticoException {
		Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(str);
        if(!matcher.matches()) throw new CampoNoAlfabeticoException("El campo "+campo+ " debe "
        		+ "ser de tipo alfabetico.");
        return true;
	} 
	
	public Boolean esNumerico(String str, String campo) throws CampoNoNumericoException {
		Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(str);
        if(!matcher.matches()) throw new CampoNoNumericoException("El campo "+campo+ " debe "
        		+ "ser de tipo numerico.");
        return true;
	}
	
	public Boolean nroDocValido(String str) throws NroDocValidoException {
		Pattern pattern = Pattern.compile("[0-9]{8}"); //TODO ver punto opcional
        Matcher matcher = pattern.matcher(str);
        if(!matcher.matches()) throw new NroDocValidoException("Ingrese un DNI valido.");
        return true;
	}
	
	
	public Boolean passwordValida(String pass) throws PasswordInvalidaException {
        Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$");
        Matcher matcher = pattern.matcher(pass);
        if(!matcher.matches()) throw new PasswordInvalidaException("La contraseña debe contener al menos "
        		+ "8 caracteres, una mayúscula, una minúscula y un numero");
        return true;
	}
	
	public Boolean emailValido(String email) throws EmailInvalidoException {
        Pattern pattern = Pattern.compile("^@[a-z]{3}$");
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()) throw new EmailInvalidoException("Debe contener ..."); //TODO completar mensaje
        return true;
    }

	public Boolean passwordCorrecta(String contrasenia, String usuarioContrasenia) throws PasswordIncorrectaException {
		if(contrasenia!=usuarioContrasenia) throw new PasswordIncorrectaException("No existe combinacion Usuario/Contraseña.");
		return true; //TODO implementar
	}
}

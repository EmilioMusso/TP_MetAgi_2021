package xp.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import xp.exceptions.emailInvalidoException;
import xp.exceptions.passwordInvalidaException;

public class FieldValidators {

	public Boolean esAlfabetico(String str) {
		Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(str);
        return !matcher.matches();		
	} 
	
	public Boolean esNumerico(String str) {
		Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
	}
	
	public Boolean passwordValida(String pass) throws passwordInvalidaException {
        Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$");
        Matcher matcher = pattern.matcher(pass);
        if(!matcher.matches()) throw new passwordInvalidaException("La contraseña debe contener al menos "
        		+ "8 caracteres, una mayúscula, una minúscula y un numero");
        return true;
	}
	
	public Boolean emailValido(String email) throws emailInvalidoException {
        Pattern pattern = Pattern.compile("^@[a-z]{3}$");
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()) throw new emailInvalidoException("Debe contener ..."); //TODO completar mensaje
        return true;
    }
}

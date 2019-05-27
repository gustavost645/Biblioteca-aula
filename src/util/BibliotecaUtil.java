/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author gusteinhoefel
 */
public class BibliotecaUtil {

    private static String inf;

    public static String MD5(String s) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(s.getBytes(), 0, s.length());
            inf = new BigInteger(1, m.digest()).toString(16);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BibliotecaUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inf;
    }

    public static void eventoSemNumeros(KeyEvent evt) {
        String caracteres = "0987654321";
        if (caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }

    public static void eventoSemCaracteres(KeyEvent evt) {
        String caracteres = "0987654321";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }

    public static String removeAcentos(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

    public static Date stod(String data) throws ParseException {
        DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Date d = f.parse(data);
        return d;
    }

    public static String removeZeros(String cod) {
        return Integer.valueOf(cod).toString();
    }

    public static Object formatarData(String toString) {
        LocalDate data = LocalDate.parse(toString);
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatador);
    }

    public static boolean validaCGC(String numCGC) {
        String num_CGC = numCGC.replace(".", "").replace("/", "").replaceAll("-", "");
        if (num_CGC.length() == 11) {
            System.out.println(ValidaCPF.imprimeCPF(num_CGC));
            return ValidaCPF.isCPF(num_CGC);

        } else {
            System.out.println(ValidaCNPJ.imprimeCNPJ(num_CGC));
            return ValidaCNPJ.isCNPJ(num_CGC);
        }
    }

    public static boolean validaEmail(String email) {

        //Verifica se o email possui o @.
        int indiceEmail = email.indexOf('@');
        if (indiceEmail > 0) {
            return (true);
        } else {
            return (false);
        }

    }

}

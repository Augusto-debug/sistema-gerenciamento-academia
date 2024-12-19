package prova01_AugustoCesarRezende.Academia;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilitaria {
    public static String geraCodigo() {
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"};
        String[] numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        StringBuilder codigo = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            codigo.append(letras[(int) (Math.random() * letras.length)]);
        }
        for (int i = 3; i < 5; i++) {
            codigo.append(numeros[(int) (Math.random() * numeros.length)]);
        }
        return codigo.toString();
    }


    public static boolean validaTel(String telefone) {
        String regexValidacao = "\\(3[1-57-9]\\) 9[89]\\d{3}-\\d{4}";
        Pattern pattern = Pattern.compile(regexValidacao);
        Matcher matcher = pattern.matcher(telefone);
        return matcher.matches();
    }
}



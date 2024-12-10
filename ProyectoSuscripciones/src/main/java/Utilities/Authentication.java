package Utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Authentication {

    // Método para hashear el texto de entrada
    public static String hashSHA1(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1"); // Escoge el hash requerido
            byte[] hashedBytes = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al crear el hash SHA-1", e);
        }
    }

    // Método para verificar la contraseña ingresada
    public static boolean verifyPassword(String passwordIngresada, String hashAlmacenado) {
        // Hashear la contraseña ingresada
        String hashIngresado = hashSHA1(passwordIngresada);

        // Comparar el hash de la contraseña ingresada con el hash almacenado
        return hashIngresado.equals(hashAlmacenado);
    }

    public static boolean validateEmail(String email){
        /*
        La expresión regular ^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,6}$ valida que:
        Empiece con uno o más caracteres alfanuméricos, guiones bajos o puntos.
        Contenga una "@" seguida de caracteres alfanuméricos y guiones.
        Termine con un punto seguido de entre 2 y 6 letras (para validar el dominio).
        La función email.matches(regex) verifica si la cadena cumple con el patrón de la expresión regular.
         */

        String regex = "^[\\w-\\.]+@[\\w-]+\\.[a-zA-Z]{2,6}$";
        return email != null && email.matches(regex);

    }


}

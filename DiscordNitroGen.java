import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DiscordNitroGen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de promoCodes que desea generar: ");
        int cantidadPromoCodes = scanner.nextInt();

        int longitudNumeros = 19;
        int longitudAlfanumerico1 = 39;
        int longitudComplejo = 238; // 5 guiones y 233 caracteres alfanuméricos
        int longitudAlfanumerico2 = 16;

        List<String> PromoCodes = generarPromocodes(cantidadPromoCodes, longitudNumeros, longitudAlfanumerico1, longitudComplejo, longitudAlfanumerico2);

        System.out.println("PromoCodes generados:");
        for (String Promocodes : PromoCodes) {
            System.out.println(PromoCodes);
        }

        scanner.close();
    }

    public static List<String> generarPromoCodes(int cantidad, int longitudNumeros, int longitudAlfanumerico1, int longitudComplejo, int longitudAlfanumerico2) {
        List<String> licencias = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            String numeros = generarVariableNumerica(longitudNumeros);
            String alfanumerico1 = generarVariableAlfanumerica(longitudAlfanumerico1);
            String complejo = generarVariableCompleja(longitudComplejo);
            String alfanumerico2 = generarVariableAlfanumerica(longitudAlfanumerico2);
            licencias.add("https://discord.com/billing/partner-promotions/" + numeros + "/" + alfanumerico1 + ".." + alfanumerico2 + "." + complejo);
        }
        return PromoCodes;
    }

    private static String generarVariableNumerica(int longitud) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(longitud);
        String numeros = "0123456789";

        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(numeros.length());
            sb.append(numeros.charAt(index));
        }
        return sb.toString();
    }

    private static String generarVariableAlfanumerica(int longitud) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(longitud);
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }
        return sb.toString();
    }

    private static String generarVariableCompleja(int longitud) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(longitud);
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // Posiciones aleatorias para colocar guiones
        List<Integer> posiciones = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            posiciones.add(i * (longitud / 5) + random.nextInt(longitud / 5)); // Distribuir guiones en diferentes partes
        }
        Collections.shuffle(posiciones); // Mezclar las posiciones para colocar guiones en diferentes lugares

        int guionIndex = 0;
        for (int i = 0; i < longitud; i++) {
            if (guionIndex < 5 && posiciones.contains(i)) {
                sb.append('-');
                guionIndex++;
            } else {
                int index = random.nextInt(caracteres.length());
                sb.append(caracteres.charAt(index));
            }
        }
        return sb.toString();
    }
}

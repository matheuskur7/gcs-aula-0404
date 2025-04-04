import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class JogoForca {
    public static void main (String[] args) {
        System.out.println("===============");
        System.out.println(" Jogo da Forca ");
        System.out.println("===============");

        Scanner in = new Scanner(System.in);

        // Configurar jogo
        String[] bancoPalavras = {
                "SPOCK",
                "ENTERPRISE",
                "VOYAGER",
                "WORTH",
                "DIANNA",
                "DATA",
                "ABACATE",
                "MANGA",
                "MELANCIA",
                "JABUTICABA",
                "BANANA",
                "PESSEGO",
        };

        Random random = new Random();

        int indicePalavraSorteada = random.nextInt(bancoPalavras.length);
        int chancesRestantes = 10;
        String palavraSorteada = bancoPalavras[indicePalavraSorteada];
        int tamPalavraSorteada = palavraSorteada.length();
        char[] letrasEscondidas = palavraSorteada.toCharArray();
        char[] letrasReveladas = new char[tamPalavraSorteada];
        for (int i = 0; i < tamPalavraSorteada; i++) {
            letrasReveladas[i] = '?';
        }

        boolean ganhou = false;

        // Loop do jogo
        while (chancesRestantes > 0 && !ganhou) {
            System.out.println("\nChances restantes: " + chancesRestantes);

            // Mostra letras ja reveladas
            for (int i = 0; i < tamPalavraSorteada; i++) {
                System.out.print(letrasReveladas[i]);
            }
            System.out.println(); // quebra a linha

            // Solicita letra do usuario
            String strLetraDigitada;
            do {
                System.out.print("Letra: ");
                strLetraDigitada = in.nextLine();
            } while (strLetraDigitada.isEmpty());

            char letraDigitada = strLetraDigitada.toUpperCase().charAt(0);

            // Revela letras, se existirem.
            boolean letraEncontrada = false;
            for (int i = 0; i < tamPalavraSorteada; i++) {
                if (letrasEscondidas[i] == letraDigitada) {
                    letraEncontrada = letrasReveladas[i] != letrasEscondidas[i];
                    letrasReveladas[i] = letrasEscondidas[i];
                }
            }

            if(Arrays.equals(letrasReveladas, letrasEscondidas)) ganhou = true;

            // Reduz nro de chances se letra digitada nao existir.
            if (!letraEncontrada) {
                chancesRestantes--;
            }
        }

        System.out.println("===========");
        System.out.println(ganhou ? "Parabéns! ": " Game Over ");
        System.out.println("===========");

    }


}
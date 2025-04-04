import java.util.Scanner;

public class JogoForca {
    public static void main (String[] args) {
        System.out.println("===============");
        System.out.println(" Jogo da Forca ");
        System.out.println("===============");

        Scanner in = new Scanner(System.in);

        // Configurar jogo
        String[] bancoPalavras = {
                "ABACATE",
                "MANGA",
                "MELANCIA",
                "JABUTICABA",
                "BANANA",
                "PESSEGO",
        };

        int indicePalavraSorteada = 2;
        int chancesRestantes = 10;
        String palavraSorteada = bancoPalavras[indicePalavraSorteada];
        int tamPalavraSorteada = palavraSorteada.length();
        char[] letrasEscondidas = palavraSorteada.toCharArray();
        char[] letrasReveladas = new char[tamPalavraSorteada];
        for (int i = 0; i < tamPalavraSorteada; i++) {
            letrasReveladas[i] = '?';
        }


        // Loop do jogo
        while (chancesRestantes > 0) {
            System.out.println("\nChances restantes: " + chancesRestantes);

            // Mostra letras ja reveladas
            for (int i = 0; i < tamPalavraSorteada; i++) {
                System.out.print(letrasReveladas[i]);
            }
            System.out.println(); // quebra a linha

            // Solicita letra do usuario
            System.out.print("Letra: ");
            String strLetraDigitada = in.nextLine();
            char letraDigitada = strLetraDigitada.charAt(0);

            // Revela letras, se existirem.
            boolean letraEncontrada = false;
            for (int i = 0; i < tamPalavraSorteada; i++) {
                if (letrasEscondidas[i] == letraDigitada) {
                    letraEncontrada = true;
                    letrasReveladas[i] = letrasEscondidas[i];
                }
            }

            // Reduz nro de chances se letra digitada nao existir.
            if (letraEncontrada) {
                chancesRestantes--;
            }
        }

        System.out.println("===========");
        System.out.println(" Game Over ");
        System.out.println("===========");

    }



}
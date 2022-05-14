import java.util.Scanner;

public class Problem_6_11 {

    // WRITE A STRING SINUSOIDALLY

    // Define the snakestring of s to be the left-right top-to-bottom sequence in which
    //characters appear when s is written in sinusoidal fashion. For example, the
    //snakestring string for "HelloÿWorld!" is "eÿlHloWrdlo!".

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(convertToSinusoldally(s));
    }

    // Time 0(n) and space 0(n)
    private static String convertToSinusoldally(String s) {

        // After observing pattern

        // First add 1,5,9,... chars
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < s.length(); i=i+4) {
            answer.append(s.charAt(i));
        }

        // then add 0,2,4,6,... chars
        for (int i = 0; i < s.length(); i=i+2) {
            answer.append(s.charAt(i));
        }

        // then add 3,7,11,... chars
        for (int i = 3; i < s.length(); i=i+4) {
            answer.append(s.charAt(i));
        }

        return answer.toString();
    }
}

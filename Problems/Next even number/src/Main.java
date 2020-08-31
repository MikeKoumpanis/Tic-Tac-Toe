import java.util.Scanner;
import static java.lang.System.out;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        
        
        out.println((a%2)*(a+1) + ((a+1)%2)*(a+2));
        
    }
}

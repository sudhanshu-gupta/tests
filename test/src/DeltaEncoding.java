import java.util.Scanner;

/**
 * Created by sgupta on 2/25/17.
 */
public class DeltaEncoding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int previous = scanner.nextInt();
        System.out.print(previous + " ");
        while(scanner.hasNext()) {
            int current = scanner.nextInt();
            int diff = current - previous;
            if(diff>= -127 && diff <= 127) {
                System.out.print(diff + " ");
            } else {
                System.out.print("-128 " + diff + " ");
            }
            previous = current;
        }
        scanner.close();
    }
}

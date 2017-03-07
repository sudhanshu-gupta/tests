import java.util.Scanner;

/**
 * Created by sgupta on 2/25/17.
 */
public class Polygon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        int sqaure = 0, rectangle = 0, other = 0;
        int A, B, C, D;
        while(scanner.hasNext()) {
            line = scanner.nextLine();
            String [] lineSplit = line.split(" ");
            A = Integer.parseInt(lineSplit[0]);
            B = Integer.parseInt(lineSplit[1]);
            C = Integer.parseInt(lineSplit[2]);
            D = Integer.parseInt(lineSplit[3]);
            if(A>0 && B>0 && C>0 && D>0) {
                if(A==C && B==D && A==B) {
                    sqaure++;
                } else if(A==C && B==D && A != B) {
                    rectangle++;
                } else {
                    other++;
                }
            } else {
                other++;
            }
        }
        scanner.close();
        System.out.println(sqaure +" "+rectangle+" "+other);
    }
}

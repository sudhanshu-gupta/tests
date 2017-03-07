import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sgupta on 2/25/17.
 */
public class CustomerExecutive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int currentCS = Integer.parseInt(scanner.nextLine());
        int total = Integer.parseInt(scanner.nextLine());
        long [] inTime = new long[total];
        long [] outTime = new long[total];
        String line;
        for(int i=0;i<total;i++) {
            line = scanner.nextLine().trim();
            inTime[i] = Long.parseLong(line.split(" ")[0]);
            outTime[i] = Long.parseLong(line.split(" ")[1]);
        }
        Arrays.sort(inTime);
        Arrays.sort(outTime);
        int cs_needed = 1, result = 1;
        int i = 1, j = 0;
        while (i < total && j < total) {
            if (inTime[i] < outTime[j]) {
                cs_needed++;
                i++;
                if (cs_needed > result)
                    result = cs_needed;
            } else {
                cs_needed--;
                j++;
            }
        }
        int csCount = Math.max(0, result-currentCS);
        System.out.println(csCount);
        scanner.close();
    }
}

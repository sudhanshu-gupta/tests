import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by sgupta on 2/25/17.
 */
public class Hotel {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        String line  = scanner.nextLine();
        Set<String> keywords = new HashSet<>();
        for(String str: line.split(" ")) {
            keywords.add(str.toLowerCase());
        }
        int reviewCount = Integer.parseInt(scanner.nextLine().trim());
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < reviewCount; i++) {
            int id = Integer.parseInt(scanner.nextLine().trim());
            int count = 0;
            String [] words = scanner.nextLine().replaceAll("[^a-zA-Z0-9\\s\\-\\\\']", "").trim().split(" ");
            for(String word : words) {
                if(keywords.contains(word.toLowerCase())) {
                    count++;
                }
            }
            if(map.containsKey(id)) {
                count += map.get(id);
                map.put(id, count);
            } else {
                map.put(id, count);
            }
        }
        scanner.close();
        map.entrySet().stream()
                .sorted((Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) -> o1.getValue().equals(o2.getValue()) ?
                        o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue()))
                .map(e -> e.getKey())
                .forEach(key -> System.out.print(key+" "));
    }


}

package com.company;

import java.util.*;

/**
 * Created by sgupta on 11/12/16.
 */
public class SortHotels {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Hotel> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            int id = scanner.nextInt();
            int score = scanner.nextInt();
            if(map.containsKey(id)) {
                map.get(id).setSum(score);
            } else {
                Hotel hotel = new Hotel(id);
                hotel.setSum(score);
                map.put(id, hotel);
            }
        }

        List<Hotel> hotels = new ArrayList<>(map.values());
        Collections.sort(hotels, (h1, h2) -> ((h1.getAvg() == h2.getAvg())?(Integer.compare(h1.getId(), h2.getId())):
        (Integer.compare(h2.getAvg(), h1.getAvg()))));

        hotels.forEach(hotel -> System.out.println(hotel.getId()));
    }

    public static class Hotel {
        private int id;
        private int sum;
        private int count;

        public Hotel(int id) {
            this.id = id;
            sum = 0;
            count = 0;
        }

        public void setSum(int sum) {
            this.sum += sum;
            count++;
        }

        public int getId() {
            return id;
        }

        public int getAvg() {
            return sum/count;
        }
    }
}

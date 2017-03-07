package com.company;



import java.util.*;

/**
 * Created by sgupta on 11/12/16.
 */
public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Interval> intervals = new ArrayList<>();
        for(int i=0;i<n;i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            intervals.add(new Interval(start, end));
        }
        Collections.sort(intervals, (p1, p2) -> p1.getStart()-p2.getStart());
        Stack<Interval> stack = new Stack<>();
        stack.push(intervals.get(0));
        for(int i=1;i<intervals.size();i++) {
            Interval top = stack.peek();
            if(top.getEnd()<intervals.get(i).getStart()) {
                stack.push(intervals.get(i));
            } else if(top.getEnd() < intervals.get(i).getEnd()) {
                top.setEnd(intervals.get(i).getEnd());
            }
        }
        System.out.println(stack.size());
        print(stack);
    }

    public static void print(Stack<Interval> stack) {
        if(stack.isEmpty())
            return;
        Interval interval = stack.pop();
        print(stack);
        System.out.println(interval.getStart()+" "+ interval.getEnd());
    }

    static class Interval {
        private Integer start;
        private Integer end;
        public Interval(Integer start, Integer end) {
            this.start = start;
            this.end = end;
        }

        public Integer getStart() {
            return start;
        }

        public Integer getEnd() {
            return end;
        }

        public void setStart(Integer start) {
            this.start = start;
        }

        public void setEnd(Integer end) {
            this.end = end;
        }
    }

}

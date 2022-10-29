package mysolution;

import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yeyang
 * @Date 2020-05-23
 */
public class Test {

//    public static int strStr(String haystack, String needle) {
////        Pattern pattern = Pattern.compile(needle);
////        Matcher matcher = pattern.matcher(haystack);
////        if (matcher.find()){
////            return matcher.start();
////        }
////        return -1;
//    }

    public static void main(String[] args) {
//        int x = strStr("applle", "ll");
//        System.out.println(x);
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        heap.add(2);
        heap.add(6);
        heap.add(1);
//        heap.add(5);
//        for (Integer i: heap){
//            heap.poll();
//            System.out.println(i);
//        }
        heap.poll();
        heap.peek();
        System.out.println(heap.peek());
        System.out.println(heap);
        System.out.println(8%2);
    }
}

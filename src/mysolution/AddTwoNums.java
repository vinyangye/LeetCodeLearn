package mysolution;


import com.sun.tools.javac.util.Convert;

import java.util.ArrayList;
import java.util.Stack;


public class AddTwoNums {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String num1 = getNumber(l1);
        String num2 = getNumber(l2);

        int temp = 0;
        int count = Math.min(num1.length(), num2.length());
        for(int i=0; i<count ;i++){
            int a = Integer.parseInt(String.valueOf(num1.charAt(i)));
            for (int j=0; j< num2.length(); j++){
                int b = Integer.parseInt(String.valueOf(num2.charAt(i)));
            }


        }

        return formListNode(num1);
    }

    public static String getNumber(ListNode ln){

        String num = "";
        while (ln != null){
            num = String.valueOf(ln.val) + num;
            ln = ln.next;
        }

        return num;
    }

    public static ListNode formListNode(String number){

//        String number = String.valueOf(num);
        System.out.println(number);
        ListNode[] temp = new ListNode[number.length()];
        for(int i=0; i<number.length() ;i++){
            ListNode x = new ListNode(Integer.parseInt(String.valueOf(number.charAt(i))));
            if(i > 0){
               x.next = temp[i-1];
            }
            temp[i] = x;
        }
        return temp[number.length()-1];
    }

    public static void main(String[] args){
        ListNode a = formListNode("9999999991");
        ListNode b = formListNode("9");
        addTwoNumbers(a,b);
//        System.out.println(a.next.val);
    }

}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

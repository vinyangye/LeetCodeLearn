package mysolution.Q1152_AnalyzeUsrWebsiteVisitPattern;

import apple.laf.JRSUIUtils;

import java.util.*;

/**
 * @author yeyang
 * @Date 4/11/22
 */
public class Solution {

    public List<String>  websiteVist(String[] username, String[] website, int[] timestamp) {


        HashMap<List<String>, Integer> visitList = new HashMap<>();
        List<String> queue = new LinkedList<>();

        String currentUser = "";


        for (int i = 0; i < username.length; i++) {
            if (!username[i].equals(currentUser)) {
                currentUser = username[i];
                queue = new LinkedList<>();
                queue.add(website[i]);
            } else {
                queue.add(website[i]);
                if (queue.size() > 3) {
                    ((LinkedList<String>) queue).poll();
                }
                if (queue.size() == 3) {
                    visitList.put(queue, visitList.getOrDefault(queue, 0) + 1);
                }
            }
        }

        Map.Entry<List<String>, Integer> entry =
                Collections.max(visitList.entrySet(),
                        (a, b) -> a.getValue().equals(b.getValue()) ?
                        -a.getKey().toString().compareTo(b.getKey().toString()) : Integer.compare(a.getValue(), b.getValue()));


        return entry.getKey();
    }

    public static void main(String[] args) {
        String[] username = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = {1,2,3,4,5,6,7,8,9,10};
        String[] website = {"home","about","career","home","cart","maps","home","home","about","career"};
        List<String> res = new Solution().websiteVist(username, website, timestamp);

        System.out.println(res.toString());
    }

}

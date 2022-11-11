package mysolution.Q1650_LowestCommonAncestorOfBinaryTreeIII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yeyang
 * @Date 8/11/22
 */
public class Solution {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    public Node lowestCommonAncestor(Node p, Node q) {
        Node cur = p;
        List<Node> pList = new ArrayList();
        while (cur != null) {
            pList.add(cur);
            cur = cur.parent;
        }

        Node curQ = q;
        while (curQ != null) {
            if (pList.contains(curQ)) {
                return curQ;
            }
            curQ = curQ.parent;
        }

        return null;
    }
}

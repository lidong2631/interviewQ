From Groupon

Leetcode subset

Phone Screen I: Behavior 20 min + Subsets


// Recursive
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        getSubsets(0, num, new ArrayList<Integer>(), rst);
        return rst;
    }
   
    private void getSubsets(int start, int[] num, List<Integer> cur, List<List<Integer>> rst) {
        rst.add(new ArrayList<Integer>(cur));
      
        for (int i = start; i < num.length; i++) {
            if (i > start && num【i】 == num[i-1]) continue;
            cur.add(num【i】);
            getSubsets(i + 1, num, cur, rst);
            cur.remove(cur.size() - 1);
        }
    }
}



Phone Screen II: Serialize and deserialize BST

// Preorder(or level order) + placeholder(e.g. #) for null
class Solution{
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    public TreeNode deserialize(String data) {
        // write your code here
        String[] ss = data.split("");
        return deserialize(ss);
    }
   
    private void serialize(TreeNode root,StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
            return;
        }
        sb.append(root.val);
        sb.append(" ");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }
   
    private int _i;
   
    private TreeNode deserialize(String[] ss) {
        if (_i >= ss.length) return null;
        String s = ss[_i];
        _i++;
        if (s.equals("#")) returnnull;
        TreeNode n = new TreeNode(Integer.valueOf(s));
        n.left = deserialize(ss);
        n.right = deserialize(ss);
        return n;
    }
}



Onsite:
1. Trending Topics.

Apache Kafka + Storm (rolling count aka sliding window)

还聊了 stream processing 的一些系统 Samza, S4, MillWheel 及他们的区别


2. Data Structures about Inverting Index

如何 index (tree vs hashing), sharding, skip list, or and not operations and k way merge


3. Regular Expression matching
4. Permutations
5. Median of two sorted array
6. Topological sort
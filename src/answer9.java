
import java.util.LinkedList;
import java.util.List;

class TreeNode {// 不同的二叉搜索树 II
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class answer9 {
    public List<TreeNode> generateTrees(int n) {//最终要返回序列1 到 n 产生的所有不同树的根节点
        if (n == 0) return new LinkedList<TreeNode>();// n 若为0，则返回一个新的空链表
        //if (n == 0) return null; //不要返回null，null和空链表意义不同
        else return generateTrees(1,n);// n 不为0，计算左边界为 1，右边界为n，能产生的所有不同树的根节点

    }

    private List<TreeNode> generateTrees(int left, int right){//多态，输入值是左右边界时，返回此区间内的数能产生的所有不同二叉树的根
        //LinkedList<TreeNode> total = new LinkedList<>();
        List<TreeNode> total = new LinkedList<TreeNode>();//最终要返回的结果
        if (right - left<0) total.add(null);//如果右边界小于左边界，返回一个空链表
        // if(right-left<0) return null;   //道理同上，不要返回null，null和空链表意义不同
        else{
            for (int i = left; i <= right; i++) {//利用for循环开始假设根为序列中每一个具体数字的情况
                //所有可能的左子树
                List<TreeNode> lefttree = generateTrees(left,i-1);
                //所有可能的右子树
                List<TreeNode> righttree = generateTrees(i+1,right);
                //根为i，左子树链表为lefttree，右子树链表为righttree，返回所有可能的不同二叉树链表（这里虽然根的取值相同，但是他们的左子树或右子树不同，是不同的节点）
                List<TreeNode> result = generateTrees(lefttree,righttree,i);//
                total.addAll(result);//将上面多态产生的链表中的所有节点加进要返回的结果链表中
            }
        }

    return total;
    }

    private List<TreeNode> generateTrees(List<TreeNode> left, List<TreeNode> right, int root){//完善上面设计的多态
        List<TreeNode> result = new LinkedList<TreeNode>();
        for (TreeNode le : left) {
            for (TreeNode ri : right){//利用两个循环成功组合出所有树的情况，并返回根节点
                TreeNode rootr = new TreeNode(root);
                rootr.left = le;
                rootr.right = ri;
                result.add(rootr);
            }
        }
        return  result;
    }

}

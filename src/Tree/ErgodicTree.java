package Tree;

/**
 * <b>二叉树的遍历</b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2021/2/24 10:42
 */
public class ErgodicTree {

    public static void main(String[] args) {

    }

    public int[][] threeOrders (TreeNode root) {
        // write code here
        //前序
        if(root==null){
            return new int[3][];
        }
        int count = treeCount(root);
        int[][] arr = new int[3][count];
        int[] arrLeft = new int[count];
        int[] arrMid = new int[count];
        int[] arrRight = new int[count];
        treeLeft(root,arrLeft, 0);
        treeMid(root,arrMid, 0);
        treeRight(root,arrRight, 0);
        arr[0] = arrLeft;
        arr[1] = arrMid;
        arr[2] = arrRight;
        return arr;
    }


    /**
     * 先序遍历，先根-->左-->右
     * @param tree
     * @param arrLeft
     * @param i
     * @return
     */
    private int treeLeft(TreeNode tree,int[] arrLeft,int i){
        //中
        arrLeft[i] = tree.val;
        TreeNode left = tree.left;
        //左
        if(left!=null){
            i++;
            i = treeLeft(left,arrLeft,i);
        }
        //右
        TreeNode right = tree.right;
        if(right!=null){
            i++;
            i = treeLeft(right,arrLeft,i);
        }
        return i;
    }
    /**
     * 中序遍历，先左-->中-->右
     * @param tree
     * @param treeMid
     * @param i
     * @return
     */
    private int treeMid(TreeNode tree,int[] treeMid,int i){
        TreeNode left = tree.left;
        //左
        if(left!=null){
            i = treeMid(left,treeMid,i);
        }
        //中
        treeMid[i] = tree.val;
        i++;
        TreeNode right = tree.right;
        if(right!=null){
            i = treeMid(right,treeMid,i);
        }
        return i;
    }
    /**
     * 后序遍历，先左-->右-->中
     * @param tree
     * @param arrRight
     * @param i
     * @return
     */
    private int treeRight(TreeNode tree,int[] arrRight,int i){
        TreeNode left = tree.left;
        //左
        if(left!=null){
            i = treeRight(left,arrRight,i);
        }
        //右
        TreeNode right = tree.right;
        if(right!=null){
            i = treeRight(right,arrRight,i);
        }
        //中
        arrRight[i] = tree.val;
        i++;

        return i;
    }
    private int treeCount(TreeNode tree){
        TreeNode left = tree.left;
        int i = 0;
        if(left!=null){
            i ++;
            i+=treeCount(left);
        }
        TreeNode right = tree.right;
        if(right!=null){
            i ++;
            i+=treeCount(right);
        }
        return i;
    }

     class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
}

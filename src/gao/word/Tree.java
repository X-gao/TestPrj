package gao.word;

import java.util.ArrayList;
import java.util.List;

/**
 * <b></b></br>
 *
 * @Company 子虚</ br>
 * @Version V1.0
 * @Author 花月
 * @Date 2021/3/2 19:47
 */
public class Tree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left =  new TreeNode(4);
        root.left.right =  new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        putTree(list,0);
    }

    public static void putTree(List<TreeNode> list,int m){
        if(list.isEmpty()){
            return;
        }
        List<TreeNode> relist = new ArrayList<TreeNode>();
        for(int i=0;i<list.size();i++){
            TreeNode node = list.get(i);
            if(node.left!=null){
                relist.add(node.left);
            }
            if(node.right!=null){
                relist.add(node.right);
            }
        }
        if(m%2==0){
            for(int i=0;i<list.size();i++){
                TreeNode node = list.get(i);
                System.out.print(node.val);
            }
        }else{
            for(int i=list.size()-1;i>=0;i--){
                TreeNode node = list.get(i);
                System.out.print(node.val);
            }
        }

        System.out.println();
        putTree(relist,++m);
    }

}
class TreeNode{
        int val ;
        TreeNode left ;
        TreeNode right;
        TreeNode(int v){
            val = v;
        }
}
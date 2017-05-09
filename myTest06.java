/**
 * 
* Title: myTest06.java
* Description: All Rights Reserved !!!
* Copyright: Copyright (c) 2017
* Company: BUCT
* @author JiangXingAn
* @date 2017年5月8日
* @time 下午5:36:12
* @version 1.0
 */
public class myTest06 {
	/**
	 * 二叉树节点类 
	 */
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * @param pre 前序遍历
 * @param in 中序遍历
 * @return 根节点
 */
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		if (pre == null || in == null || pre.length != in.length || pre.length < 1)
			return null;
		TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
		return root;
	}
/**
 * 
 * @param pre 前序遍历
 * @param prebegin 前序遍历起始位置
 * @param preend 前序遍历结束位置
 * @param in 
 * @param inbegin
 * @param inend
 * @return
 */
	public static TreeNode reConstructBinaryTree(int[] pre, int prebegin, int preend, int[] in, int inbegin,
			int inend) {
		if (prebegin > preend)
			return null;
		TreeNode rootnode = new TreeNode(pre[prebegin]);
		for (int i = inbegin; i <= inend; i++) {
			if (rootnode.val == in[i]) {
				rootnode.left = reConstructBinaryTree(pre, prebegin + 1, prebegin + i - inbegin, in, inbegin, i - 1);
				rootnode.right = reConstructBinaryTree(pre, prebegin + i - inbegin + 1, preend, in, i + 1, inend);
			}
		}
		return rootnode;
	}
	public static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }

    }

    // 普通二叉树
    //              1
    //           /     \
    //          2       3
    //         /       / \
    //        4       5   6
    //         \         /
    //          7       8
    private static void test1() {
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        printTree(root);
    }

    // 所有结点都没有右子结点
    //            1
    //           /
    //          2
    //         /
    //        3
    //       /
    //      4
    //     /
    //    5
    private static void test2() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {5, 4, 3, 2, 1};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        printTree(root);
    }

    // 所有结点都没有左子结点
    //            1
    //             \
    //              2
    //               \
    //                3
    //                 \
    //                  4
    //                   \
    //                    5
    private static void test3() {
        int[] preorder = {1, 2, 3, 4, 5};
        int[] inorder = {1, 2, 3, 4, 5};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        printTree(root);
    }

    // 树中只有一个结点
    private static void test4() {
        int[] preorder = {1};
        int[] inorder = {1};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        printTree(root);
    }

    // 完全二叉树
    //              1
    //           /     \
    //          2       3
    //         / \     / \
    //        4   5   6   7
    private static void test5() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        printTree(root);
    }

    // 输入空指针
    private static void test6() {
        reConstructBinaryTree(null, null);
    }

    // 输入的两个序列不匹配
    private static void test7() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 8, 1, 6, 3, 7};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        printTree(root);
    }


    public static void main(String[] args) {

        test1();
        System.out.println();
        test2();
        System.out.println();
        test3();
        System.out.println();
        test4();
        System.out.println();
        test5();
        System.out.println();
        test6();
//        System.out.println();
//        test7();

    }
}
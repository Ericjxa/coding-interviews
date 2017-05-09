/**
 * 
* Title: myTest06.java
* Description: All Rights Reserved !!!
* Copyright: Copyright (c) 2017
* Company: BUCT
* @author JiangXingAn
* @date 2017��5��8��
* @time ����5:36:12
* @version 1.0
 */
public class myTest06 {
	/**
	 * �������ڵ��� 
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
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * @param pre ǰ�����
 * @param in �������
 * @return ���ڵ�
 */
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		if (pre == null || in == null || pre.length != in.length || pre.length < 1)
			return null;
		TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
		return root;
	}
/**
 * 
 * @param pre ǰ�����
 * @param prebegin ǰ�������ʼλ��
 * @param preend ǰ���������λ��
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

    // ��ͨ������
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

    // ���н�㶼û�����ӽ��
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

    // ���н�㶼û�����ӽ��
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

    // ����ֻ��һ�����
    private static void test4() {
        int[] preorder = {1};
        int[] inorder = {1};
        TreeNode root = reConstructBinaryTree(preorder, inorder);
        printTree(root);
    }

    // ��ȫ������
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

    // �����ָ��
    private static void test6() {
        reConstructBinaryTree(null, null);
    }

    // ������������в�ƥ��
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
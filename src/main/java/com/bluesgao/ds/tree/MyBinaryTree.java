package com.bluesgao.ds.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyBinaryTree {
    public MyBinaryTree() {
    }

    public void printData(TreeNode node) {
        System.out.print(node.getData()+"->");
    }

    //前序：根->左->右
    //若二叉树为空，遍历结束；否则，访问根结点，先序遍历根结点的左子树，先序遍历根结点的右子树。
    public void preOrder(TreeNode root) {
        if (root != null) {
            printData(root);
            preOrder(root.getLeft());
            preOrder((root.getRight()));
        }
    }

    //中序：左->根->右
    //若二叉树为空，遍历结束；否则，中序遍历根结点的左子树，访问根结点，中序遍历根结点的右子树。
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.getLeft());
            printData(root);
            inOrder((root.getRight()));
        }
    }

    //后序：左->右->根
    //若二叉树为空，遍历结束；否则，后序遍历根结点的左子树，后序遍历根结点的右子树，访问根结点。
    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            printData(root);
        }
    }

    //层次遍历，就是从二叉树的第一层（根结点）开始，从上至下逐层遍历，在同一层，则按照从左至右的顺序对每个结点逐个访问
    //层次遍历的基本思想是：由于层次遍历结点的顺序是先遇到的结点先访问，与队列的操作顺序相同
    //在进行层次遍历时，设置一个队列，将根结点引用入队，当队列非空时，循环执行以下三步：
    //从队列中取出一个结点的引用，并访问该节点；
    //若该结点的左子树非空，将该结点的左子树引用入队；
    //若该结点的右子树非空，将该结点的右子树引用入队。
    public void levelOrder(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
            // 根结点入队
            queue.add(root);
            while (!queue.isEmpty()) {
                // 当前结点出队
                TreeNode node = queue.poll();
                // 处理当前结点
                printData(node);
                // 将当前结点的左孩子结点入队
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                // 将当前结点的右孩子结点入队
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
        }
    }

    public static void main(String[] args) {
        /**
         *            1
         *        2      3
         *     4    5  6   7
         *
         *
         * */
        TreeNode n4 = new TreeNode(4, null, null);
        TreeNode n5 = new TreeNode(5, null, null);
        TreeNode n6 = new TreeNode(6, null, null);
        TreeNode n7 = new TreeNode(7, null, null);
        TreeNode n3 = new TreeNode(3, n6, n7);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n1 = new TreeNode(1, n2, n3);

        MyBinaryTree binaryTree = new MyBinaryTree();
        System.out.println("\n -----前序遍历------");
        binaryTree.preOrder(n1);
        System.out.println("\n -----中序遍历------");
        binaryTree.inOrder(n1);
        System.out.println("\n -----后序遍历------");
        binaryTree.postOrder(n1);
        System.out.println("\n -----层序遍历------");
        binaryTree.levelOrder(n1);

    }
}

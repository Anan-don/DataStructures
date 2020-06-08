package com.anan.tree;

import org.junit.Test;

/**
 * @author don
 * @create 2020-06-08 13:38
 */
public class TestBinaryTree {
    @Test
    public void test(){
        BinaryTree<String> sbt = new BinaryTree<>();
        BinaryTree<String>.TNode<String> root = sbt.new TNode<String>("aiqing");
        BinaryTree<String>.TNode<String> yaodahai = sbt.new TNode<String>("yaodahai");
        BinaryTree<String>.TNode<String> yaoxingtong = sbt.new TNode<String>("yaoxingtong");
        BinaryTree<String>.TNode<String> mafuju = sbt.new TNode<String>("mafuju");
        BinaryTree<String>.TNode<String> wangjiannan = sbt.new TNode<String>("wangjiannan");
        BinaryTree<String>.TNode<String> wangjianbing = sbt.new TNode<String>("wangjianbing");
        sbt.setRoot(root);
        root.setLeftNode(yaodahai);
        root.setRightNode(wangjiannan);
        yaodahai.setLeftNode(yaoxingtong);
        yaodahai.setRightNode(mafuju);
        wangjiannan.setRightNode(wangjianbing);
        sbt.preOrder(root);
        sbt.infixOrder(root);
        sbt.postOrder(root);
        System.out.println(sbt);
        System.out.println(sbt.preInserch(root, "wangjiannan"));
        System.out.println(sbt.infixInserch(root, "wangjiannan"));
        System.out.println(sbt.postInserch(root, "wangjiannan"));
    }

}

package com.anan.tree;

/**
 * @author don
 * @create 2020-06-08 14:35
 */
public class ArrBinaryTree<T> {

    private TNode<T> root;

    public ArrBinaryTree() {
        root = null;
    }

    class TNode<T>{

        private T t;
        private TNode<T> leftNode;
        private TNode<T> rightNode;
        public TNode(T t){
            this.t = t;
            leftNode = null;
            rightNode =null;
        }
        @Override
        public String toString() {
            return "TNode{" +
                    "t=" + t +
                    '}';
        }

    }
}

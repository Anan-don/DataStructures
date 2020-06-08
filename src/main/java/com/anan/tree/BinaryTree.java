package com.anan.tree;

/**
 * @author don
 * @create 2020-06-08 13:27
 */
public class BinaryTree<T> {
    private TNode<T> root;
    public BinaryTree(){
        root = null;
    }

    public TNode<T> getRoot() {
        return root;
    }

    public void setRoot(TNode<T> root) {
        this.root = root;
    }
    //前序遍历
    public void preOrder(TNode<T> node){
        System.out.println(node);
        if(node.leftNode != null){
            preOrder(node.leftNode);
        }
        if(node.rightNode != null){
            preOrder(node.rightNode);
        }
    }
    //中序遍历
    public void infixOrder(TNode<T> node){
        if(node.leftNode != null){
            infixOrder(node.leftNode);
        }
        System.out.println(node);
        if(node.rightNode != null){
            infixOrder(node.rightNode);
        }
    }
    //后序遍历
    public void postOrder(TNode<T> node){
        if(node.leftNode != null){
            postOrder(node.leftNode);
        }
        if(node.rightNode != null){
            postOrder(node.rightNode);
        }
        System.out.println(node);
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
    //前序查找
    public TNode<T> preInserch(TNode<T> tNode,T t){
        if (tNode.t.equals(t)){
            return tNode;
        }
        if (tNode.leftNode != null){
            TNode<T> result = preInserch(tNode.leftNode,t);
            if (result != null){
                return result;
            }
        }
        if (tNode.rightNode != null){
            TNode<T> result = preInserch(tNode.rightNode,t);
            if (result != null){
                return result;
            }
        }
        return null;
    }
    //中序查找
    public TNode<T> infixInserch(TNode<T> tNode,T t){

        if (tNode.leftNode != null){
            TNode<T> result = infixInserch(tNode.leftNode,t);
            if (result != null){
                return result;
            }
        }
        if (tNode.t.equals(t)){
            return tNode;
        }
        if (tNode.rightNode != null){
            TNode<T> result = infixInserch(tNode.rightNode,t);
            if (result != null){
                return result;
            }
        }
        return null;
    }
    //后序查找
    public TNode<T> postInserch(TNode<T> tNode,T t){

        if (tNode.leftNode != null){
            TNode<T> result = postInserch(tNode.leftNode,t);
            if (result != null){
                return result;
            }
        }
        if (tNode.rightNode != null){
            TNode<T> result = postInserch(tNode.rightNode,t);
            if (result != null){
                return result;
            }
        }
        if (tNode.t.equals(t)){
            return tNode;
        }
        return null;
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

        public T getT() {
            return t;
        }

        public TNode<T> getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(TNode<T> leftNode) {
            this.leftNode = leftNode;
        }

        public TNode<T> getRightNode() {
            return rightNode;
        }

        public void setRightNode(TNode<T> rightNode) {
            this.rightNode = rightNode;
        }

        @Override
        public String toString() {
            return "TNode{" +
                    "t=" + t +
                    '}';
        }
    }
}

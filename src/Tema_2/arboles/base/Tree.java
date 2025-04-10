package Tema_2.arboles.base;

public class Tree {

    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void add(Integer value) {
        if (this.root == null)
            this.root = new TreeNode(value);
        else
            this.add(this.root,value);
    }

    private void add(TreeNode actual, Integer value) {
        if (actual.getValue() > value) {
            if (actual.getLeft() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(),value);
            }
        } else if (actual.getValue() < value) {
            if (actual.getRight() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setRight(temp);
            } else {
                add(actual.getRight(),value);
            }
        }
    }

    public Integer getRoot(){
        return this.root.getValue();
    }
    public boolean hasElem(Integer elem){
        return hasElem(root, elem);
    }

    private boolean hasElem(TreeNode node, Integer elem) {
        if(node==null){
            return false;
        }
        //Si el valor del nodo actual es igual a elem retorno true
        if(node.getValue().equals(elem)){
            return true;
        }
        //Si el nodo es mayor al elemento hay que ir por izquierda
        if(node.getValue()>elem){
            return hasElem(node.getLeft(),elem);
        }else {
            return hasElem(node.getRight(),elem);
        }

    }
    public boolean isEmpty(){
        return this.root==null;
    }

}
package Tema_2.arboles_ej6.base;

public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private Libro libro;

    public TreeNode( Libro libro) {
        this.left = null;
        this.right = null;
        this.libro = libro;
    }

    public Integer getId() {
        return libro.getId();
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }


}

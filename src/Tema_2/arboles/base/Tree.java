package Tema_2.arboles.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tree {

    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void add(Integer value) {
        if (this.root == null) this.root = new TreeNode(value);
        else this.add(this.root, value);
    }

    private void add(TreeNode actual, Integer value) {
        if (actual.getValue() > value) {
            if (actual.getLeft() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(), value);
            }
        } else if (actual.getValue() < value) {
            if (actual.getRight() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setRight(temp);
            } else {
                add(actual.getRight(), value);
            }
        }
    }

    //O(1)
    public Integer getRoot() {
        return this.root.getValue();
    }

    //En el mejor de los casos (Arbol balanceado o Arbol completo)
    // nos queda O(Log2 n)
    //En el peor de los casos (Arbol Enredadera) O(n)
    public boolean hasElem(Integer elem) {
        return hasElem(root, elem);
    }

    private boolean hasElem(TreeNode node, Integer elem) {
        if (node == null) {
            return false;
        }
        //Si el valor del nodo actual es igual a elem retorno true
        if (node.getValue().equals(elem)) {
            return true;
        }
        //Si el nodo es mayor al elemento hay que ir por izquierda
        if (node.getValue() > elem) {
            return hasElem(node.getLeft(), elem);
        } else {
            return hasElem(node.getRight(), elem);
        }

    }


    //O(1)
    public boolean isEmpty() {
        return this.root == null;
    }

    public Integer getHeight() {
        return getHeight(root) - 1;
    }

    private Integer getHeight(TreeNode node) {
        Integer heightL = 0;
        Integer heightR = 0;
        if (node == null) {
            return 0;
        }


        heightR = getHeight(node.getRight()) + 1;
        heightL = getHeight(node.getLeft()) + 1;

        if (heightR > heightL) {
            return heightR;
        } else {
            return heightL;
        }
    }

    public void printPosOrder() {
        printPosOrder(root);
    }

    private void printPosOrder(TreeNode node) {
        if (node == null) {
            System.out.print("-");
            return;
        }

        printPosOrder(node.getLeft());
        printPosOrder(node.getRight());
        System.out.print(node.getValue() + " ");
    }

    public void printPreOrder() {
        printPreOrder(root);
    }

    private void printPreOrder(TreeNode node) {
        if (node == null) {
            System.out.print("-");
            return;
        }

        System.out.print(node.getValue() + " ");
        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(TreeNode node) {
        if (node == null) {
            System.out.print("-");
            return;
        }

        printInOrder(node.getLeft());
        System.out.print(node.getValue() + " ");
        printInOrder(node.getRight());
    }

    public List<Integer> getFrontera() {
        List<Integer> result = new ArrayList<>();
        return getFrontera(root, result);
    }

    private List<Integer> getFrontera(TreeNode node, List<Integer> result) {

        if (node == null) {
            return result;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            result.add(node.getValue());
        }

        getFrontera(node.getLeft(), result);
        getFrontera(node.getRight(), result);

        return result;
    }

    public Integer getMaxElem() {
        Integer maxElemen = 0;
        return getMaxElem(root, maxElemen);
    }

    private Integer getMaxElem(TreeNode node, Integer maxElem) {
        if (node == null) {
            return maxElem;
        }
        if (node.getValue() > maxElem) {
            maxElem = node.getValue();
        }


        return getMaxElem(node.getRight(), maxElem);

    }

    public List<Integer> getElemAtLevel(int level) {
        List<Integer> result = new ArrayList<>();
        getElemAtLevel(root, level, result);
        return result;
    }

    private void getElemAtLevel(TreeNode node, int level, List<Integer> result) {
        if (node == null) return;

        if (level == 0) {
            result.add(node.getValue());
        } else {
            getElemAtLevel(node.getLeft(), level - 1, result);
            getElemAtLevel(node.getRight(), level - 1, result);
        }
    }

    public Integer summAllNodes() {
        return summAllNodes(root, 0);
    }

    private Integer summAllNodes(TreeNode node, Integer sum) {
        if (node == null) {
            return sum;
        }
        sum += node.getValue();
        sum = summAllNodes(node.getLeft(), sum);
        sum = summAllNodes(node.getRight(), sum);

        return sum;
    }

    public List<Integer> getFrontGreat(Integer elem) {
        List<Integer> result = new ArrayList<>();
        return getFrontGreat(root, elem, result);
    }

    public List<Integer> getFrontGreat(TreeNode node, Integer elem, List<Integer> result) {
        if (node == null) {
            return result;
        }
        if (node.getLeft() == null && node.getRight() == null && node.getValue() > elem) {
            result.add(node.getValue());
        }
        getFrontGreat(node.getLeft(), elem, result);
        getFrontGreat(node.getRight(), elem, result);

        return result;

    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(TreeNode node) {
        if (node == null) {
            return true;
        }
        Integer heightL = this.getHeight(node);
        Integer heightR = this.getHeight(node);
        if (heightR - heightL > 1) {
            return false;
        }


        return isBalanced(node.getLeft()) && isBalanced(node.getRight());

    }

    public boolean isLeaf(Integer elem) {
        if (hasElem(elem)) {
            return isLeaf(root, elem);

        } else {
            return false;
        }
    }

    private boolean isLeaf(TreeNode node, Integer elem) {
        if (node == null) {
            return false;
        }
        if (node.getValue().equals(elem)) {
            return node.getLeft() == null && node.getRight() == null;
        } else if (elem < node.getValue()) {
            return isLeaf(node.getLeft(), elem);
        } else {
            return isLeaf(node.getRight(), elem);
        }


    }

    public boolean delete(Integer elem) {
        // Si el árbol contiene el elemento, lo borramos
        if (hasElem(elem)) {
            // Si el nodo a borrar es la raíz, puede cambiar. Por eso reasignamos root
            root = deleteNode(root, elem);
            return true;
        }
        // Si no está, no hacemos nada
        return false;
    }

    private TreeNode deleteNode(TreeNode node, Integer elem) {
        if (node == null) return null; // 🛑 Si llegamos a un nodo nulo, cortamos la recursión

        if (elem < node.getValue()) {
            // 🔍 Buscamos por la izquierda si el valor a borrar es menor
            node.setLeft(deleteNode(node.getLeft(), elem));

        } else if (elem > node.getValue()) {
            // 🔍 Buscamos por la derecha si el valor a borrar es mayor
            node.setRight(deleteNode(node.getRight(), elem));

        } else {

            // 🎯 Encontramos el nodo a borrar

            // 💥 Caso 1: no tiene hijo izquierdo
            // Ej: Si queremos borrar el 60 → 60 no tiene hijo izquierdo → devolvemos su hijo derecho (null)
            if (node.getLeft() == null) {
                return node.getRight(); // el padre lo reemplaza con este
            }

            // 🌿 Caso 2: no tiene hijo derecho
            // Ej: Si queremos borrar el 20 → 20 no tiene hijo derecho → devolvemos su hijo izquierdo (null)
            if (node.getRight() == null) {
                return node.getLeft(); // el padre lo reemplaza con este
            }

            // 🌳 Caso 3: tiene dos hijos
            // Ej: Si queremos borrar el 30 → tiene 20 (izq) y 40 (der)

            // 🧭 Buscamos el sucesor in-order: el menor del subárbol derecho
            // En este caso, si estamos en 30, su subárbol derecho es 40 → el menor es 40
            TreeNode min = getMin(node.getRight());

            // 🔁 Copiamos ese valor en el nodo actual (30 → 40)
            node.setValue(min.getValue());

            // ❌ Ahora borramos el nodo duplicado (el original 40 en este caso)
            node.setRight(deleteNode(node.getRight(), min.getValue()));
        }

        // 🔗 Devolvemos el nodo actualizado para mantener el árbol bien conectado
        return node;
    }


    private TreeNode getMin(TreeNode node) {
        // Vamos al nodo más a la izquierda → el menor del subárbol
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }


    public void printTree() {
        if (root == null) {
            System.out.println("El árbol está vacío");
            return;
        }

        List<List<String>> lines = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();

        level.add(root);
        int nn = 1;
        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<>();
            nn = 0;

            for (TreeNode n : level) {
                if (n == null) {
                    line.add(null);
                    next.add(null);
                    next.add(null);
                } else {
                    String aa = n.getValue().toString();
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.getLeft());
                    next.add(n.getRight());

                    if (n.getLeft() != null) nn++;
                    if (n.getRight() != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);
            List<TreeNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {
                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (String f : line) {
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }

    ArrayList<Integer> algoritmo(TreeNode node, Integer value) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (node != null) {
            Integer newValue = value;
            if (node.getValue() < value) {
                newValue = value - node.getValue();
                result.add(node.getValue());
            }
            if (node.getLeft() != null)
                result.addAll(algoritmo(node.getLeft(), newValue));
            else if (node.getRight() != null)
                result.addAll(algoritmo(node.getRight(), newValue));
        }
        return result;
    }

}
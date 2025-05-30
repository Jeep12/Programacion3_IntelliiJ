package Tema_2.arboles_ej5.base;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Tree {

    private TreeNode root;

    public Tree() {
        this.root = null;
    }


    public List<String> formarPalabra(Integer max) {
        List<String> result = new ArrayList<>();

        return formarPalabra(root, result, max, 0, "");

    }

    private List<String> formarPalabra(TreeNode node, List<String> result, Integer max, Integer contador, String palabra) {

        if (node == null) {
            return result;
        }
        String letra = node.getValue(); // asumo que getValue() devuelve un String
        palabra += letra;

        if (isVocal(node.getValue())) contador++;

        if (node.getLeft() == null && node.getRight() == null) {

            if (contador == max) {
                result.add(palabra);
            }
        }
        formarPalabra(node.getLeft(), result, max, contador, palabra);
        formarPalabra(node.getRight(), result, max, contador, palabra);
        return result;
    }


    public void add(String elem, String direccion) {
        TreeNode newNode = new TreeNode(elem);

        if (direccion.isEmpty()) {
            root = newNode;
            return;
        }

        add(root, newNode, direccion);
    }

    private void add(TreeNode current, TreeNode newNode, String direccion) {
        for (int i = 0; i < direccion.length() - 1; i++) {
            char dir = direccion.charAt(i);
            if (dir == 'L') {
                if (current.getLeft() == null)
                    current.setLeft(new TreeNode(null));
                current = current.getLeft();
            } else if (dir == 'R') {
                if (current.getRight() == null)
                    current.setRight(new TreeNode(null));
                current = current.getRight();
            }
        }

        char lastDir = direccion.charAt(direccion.length() - 1);
        if (lastDir == 'L') {
            current.setLeft(newNode);
        } else if (lastDir == 'R') {
            current.setRight(newNode);
        }
    }


    public boolean isVocal(String letra) {
        return letra.equalsIgnoreCase("A") ||
                letra.equalsIgnoreCase("E") ||
                letra.equalsIgnoreCase("I") ||
                letra.equalsIgnoreCase("O") ||
                letra.equalsIgnoreCase("U");
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
                    String aa = n.getValue();
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
}
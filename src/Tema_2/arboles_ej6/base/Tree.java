package Tema_2.arboles_ej6.base;

import Tema_2.ABB.base.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tree {

    private TreeNode root;
    private Map<Integer, Libro> mapBooks;

    public Tree() {
        this.root = null;
        this.mapBooks = new HashMap<>();
    }

    public void add(Libro libro) {
        TreeNode newNode = new TreeNode(libro);
        if (root == null) {
            root = newNode;
        } else {
            add(root, newNode);
        }
        mapBooks.put(libro.getId(), libro);

    }

    private void add(TreeNode current, TreeNode newNode) {
        if (current.getId() > newNode.getId()) {
            if (current.getLeft() == null) {
                current.setLeft(newNode);
            } else {
                add(current.getLeft(), newNode);
            }
        } else if (current.getId() < newNode.getId()) {
            if (current.getRight() == null) {
                current.setRight(newNode);
            } else {
                add(current.getRight(), newNode);
            }
        }

    }


    public Libro getBookById(Integer id){
        return this.mapBooks.get(id);
    }

    // O(1)
    public Integer getBookQuantityById(Integer id) {
        return mapBooks.get(id).getCantidadEjemplares();
    }

    //O(n) en el peor de los casos porque se busca por genero si fuera por id
    //seria O(log2 n) si el arbol esta balanceado o completo ya que se inserta ordenado por el id del libro
    public List<Libro> getBooksByGenre(String genre) {
        List<Libro> result = new ArrayList<>();
        getBooksByGenre(root, result, genre);
        return result;
    }

    public void getBooksByGenre(TreeNode current, List<Libro> result, String genre) {
        if (current == null) {
            return;
        }

        List<String> generos = current.getLibro().getGeneros();

        for (String genero : generos) {
            if (genero.equalsIgnoreCase(genre)) {
                result.add(current.getLibro());
            }
        }
        getBooksByGenre(current.getLeft(), result, genre);
        getBooksByGenre(current.getRight(), result, genre);

    }

    public List<Libro> getBookBeetwenYears(Integer year1, Integer year2) {
        List<Libro> result = new ArrayList<>();
        getBookBeetwenYears(root, result, year1, year2);
        return result;
    }


    private void getBookBeetwenYears(TreeNode current, List<Libro> result, Integer year1, Integer year2) {
        if (current == null) {
            return;
        }
        if (current.getLibro().getAñoPublicacion() >= year1 && current.getLibro().getAñoPublicacion() <= year2) {
            result.add(current.getLibro());
        }
        getBookBeetwenYears(current.getLeft(), result, year1, year2);
        getBookBeetwenYears(current.getRight(), result, year1, year2);


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
                    String aa = n.getId().toString();
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

package PracticaParciales.parcial2024Tresa.base;


import java.util.ArrayList;
import java.util.List;

public class Tree {

    private Node root;

    public Tree() {
        this.root = null;
    }


    public void add(Integer elem) {
        Node newNode = new Node(elem);
        if (root == null) {
            root = newNode;
        } else {
            add(root, newNode);
        }
    }

    public void add(Node current, Node newNode) {
        //Si el nodo nuevo es menor al actual deberiamos insertar en izquierda
        if (newNode.getValue() < current.getValue()) {
            //Si el nodo actual no tiene izquierda insertamos
            if (current.getLeft() == null) {
                current.setLeft(newNode);
            } else {
                //Si tiene izquierda hacemos el  llamado recursivo enviando siempre la izquierda
                add(current.getLeft(), newNode);
            }
        }
        //Si el nodo nuevo es mayor insertamos en derecha
        else if (newNode.getValue() > current.getValue()) {
            if (current.getRight() == null) {
                current.setRight(newNode);
            } else {
                add(current.getRight(), newNode);
            }
        }
    }

    public boolean hasElem(Integer elem) {
        return hasElem(root, elem);
    }

    private boolean hasElem(Node current, Integer elem) {
        if (current == null) {
            return false;
        }
        if (current.getValue().equals(elem)) {
            return true;
        }
        return hasElem(current.getLeft(), elem) && hasElem(current.getRight(), elem);
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public Integer getHeight() {
        return getHeight(root) - 1;
    }

    private Integer getHeight(Node current) {
        if (current == null) {
            return 0;
        }
        Integer heightL = getHeight(current.getLeft()) + 1;
        Integer heightR = getHeight(current.getRight()) + 1;

        if (heightR > heightL) {
            return heightR;
        } else {
            return heightL;
        }


    }

    public void printPosOrder() {
        printPosOrder(root);
    }

    private void printPosOrder(Node current) {
        if (current == null) {
            System.out.println("-");
            return;
        }
        printPosOrder(current.getLeft());
        printPosOrder(current.getRight());
        System.out.println(current.getValue());
    }

    public List<Integer> getLongestBranch() {
        List<Integer> result = new ArrayList<>();
        return getLongestBranch(root, result);
    }

    private List<Integer> getLongestBranch(Node current, List<Integer> result) {
        if (current == null) {
            return result;
        }

        // Hacemos una copia de la lista para cada rama
        List<Integer> leftResult = new ArrayList<>(result);
        leftResult.add(current.getValue());

        List<Integer> listLeft = getLongestBranch(current.getLeft(), leftResult);

        // Hacemos una copia de la lista para la rama derecha
        List<Integer> rightResult = new ArrayList<>(result);
        rightResult.add(current.getValue());

        List<Integer> listRight = getLongestBranch(current.getRight(), rightResult);

        if (listLeft.size() > listRight.size()) {
            return listLeft;
        } else {
            return listRight;
        }

    }

    public List<Integer> getLeaves() {
        return getLeaves(root, new ArrayList<Integer>());
    }

    private List<Integer> getLeaves(Node current, ArrayList<Integer> result) {
        if (current == null) {
            return result;
        }

        if (current.getLeft() == null && current.getRight() == null) {
            result.add(current.getValue());
        }
        getLeaves(current.getLeft(), result);
        getLeaves(current.getRight(), result);

        return result;

    }

    public List<List<Integer>> getAllPath() {
        return getAllPath(root, new ArrayList<>(), new ArrayList<>()); // pero el segundo es List<Integer>, el tercero es List<List<Integer>>

    }

    private List<List<Integer>> getAllPath(Node current, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (current == null) {
            return allPaths;
        }
        List<Integer> aux = new ArrayList<>(currentPath);
        aux.add(current.getValue());
        if (current.getRight() == null && current.getLeft() == null) {
            allPaths.add(aux);
        }
        getAllPath(current.getLeft(), aux, allPaths);
        getAllPath(current.getRight(), aux, allPaths);


        return allPaths;
    }

    public boolean cumplePropiedad(Integer diferencia) {
        return cumplePropiedad(root, diferencia);
    }

    private boolean cumplePropiedad(Node current, Integer diferencia) {
        if (current == null) {
            return true; // tiene que ser true, no false. Un nodo nulo no rompe la propiedad.
        }

        if (current.getLeft() != null) {
            int diffLeft = current.getValue() - current.getLeft().getValue();
            if (diffLeft < 0) {
                diffLeft = -diffLeft;
            }
            if (diffLeft <= diferencia) {
                return false;
            }
        }

        if (current.getRight() != null) {
            int diffRight = current.getValue() - current.getRight().getValue();
            if (diffRight < 0) {
                diffRight = -diffRight;
            }
            if (diffRight <= diferencia) {
                return false;
            }
        }

        return cumplePropiedad(current.getLeft(), diferencia) && cumplePropiedad(current.getRight(), diferencia);
    }


    public void printTree() {
        if (root == null) {
            System.out.println("El árbol está vacío");
            return;
        }

        List<List<String>> lines = new ArrayList<>();
        List<Node> level = new ArrayList<>();
        List<Node> next = new ArrayList<>();

        level.add(root);
        int nn = 1;
        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<>();
            nn = 0;

            for (Node n : level) {
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
            List<Node> tmp = level;
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

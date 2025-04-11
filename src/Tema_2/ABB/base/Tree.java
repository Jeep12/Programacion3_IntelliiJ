package Tema_2.ABB.base;


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

    public Integer countBranchesLongerThan(Integer elem) {
        return countBranchesLongerThan(root, elem, 0, 0);
    }

    private Integer countBranchesLongerThan(Node current, Integer elem, Integer count, Integer result) {
        if (current == null) {
            return 0;
        }
        //Variable que incrementa con los nodos
        count++;

        //si el nodo es hoja(Llegamos al final de la rama ) y la cantidad de nodos es mayor a elem
        if (current.getLeft() == null && current.getRight() == null & count > elem) {
            return 1;
        }

        return countBranchesLongerThan(current.getLeft(), elem, count, result) +
                countBranchesLongerThan(current.getRight(), elem, count, result);

    }


    public Integer sumForLevel(Integer level) {
        return sumForLevel(root, level, 0);
    }

    private Integer sumForLevel(Node current, Integer level, Integer countLevel) {
        if (current == null) {
            return 0;
        }


        if (countLevel.equals(level)) {
            return current.getValue();
        }

        return sumForLevel(current.getLeft(), level, countLevel + 1) + sumForLevel(current.getRight(), level, countLevel + 1);
    }

    public List<Integer> nodesBetweenLevel(Integer levelMin, Integer levelMax) {
        if (levelMax > this.getHeight()) {
            return null;
        }
        return nodesBetweenLevel(root, levelMin, levelMax, new ArrayList<>(), 0);
    }

    private List<Integer> nodesBetweenLevel(Node current, Integer min, Integer max, List<Integer> result, Integer countLevel) {
        if (current == null) {
            return result;
        }

        if (countLevel >= min && countLevel <= max) {
            result.add(current.getValue());
        }

        nodesBetweenLevel(current.getLeft(), min, max, result, countLevel + 1);
        nodesBetweenLevel(current.getRight(), min, max, result, countLevel + 1);

        return result;
    }

    public List<Integer> nodesForLevel(Integer level) {
        if (level > this.getHeight()) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        return nodesForLevel(root, level, 0, result);
    }

    private List<Integer> nodesForLevel(Node current, Integer level, Integer countLevel, List<Integer> result) {
        if (current == null) {
            return result;
        }
        //Creamos una copia de result para llevar los nodos parcialmente
        List<Integer> aux = new ArrayList<Integer>(result);
        if (countLevel.equals(level)) {
            aux.add(current.getValue());
        }
        List<Integer> resultLeft = nodesForLevel(current.getLeft(), level, countLevel + 1, result);
        List<Integer> resultRight = nodesForLevel(current.getRight(), level, countLevel + 1, result);

        aux.addAll(resultLeft);
        aux.addAll(resultRight);

        return aux;


    }

    public List<Integer> getNodesInternal() {
        List<Integer> result = new ArrayList<>();
        getNodesInternal(root, result);
        return result;
    }

    private void getNodesInternal(Node current, List<Integer> result) {
        if (current == null) {
            return;
        }

        if (current.getRight() != null || current.getLeft() != null) {
            result.add(current.getValue());
        }
        getNodesInternal(current.getRight(), result);
        getNodesInternal(current.getLeft(), result);

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

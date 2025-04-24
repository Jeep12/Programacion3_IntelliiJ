package Tema_2.ABBREPASO.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree {

    protected Node root;

    public Tree() {
        this.root = null;
    }


    public void add(Integer value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
        } else {
            add(root, newNode);
        }
    }

    private void add(Node root, Node newNode) {
        if (newNode.getValue() < root.getValue()) {
            if (root.getLeft() == null) {
                root.setLeft(newNode);
            } else {
                add(root.getLeft(), newNode);
            }
        } else {
            if (root.getRight() == null) {
                root.setRight(newNode);
            } else {
                add(root.getRight(), newNode);
            }
        }

    }

    public Integer sumarEntreAcumulador(Integer min, Integer max) {
        return sumarEntreAcumulador(root, 0, min, max);
    }

    private Integer sumarEntreAcumulador(Node current, Integer resultado, Integer min, Integer max) {
        if (current == null) {
            return resultado;
        }
        if (current.getValue() >= min && current.getValue() <= max) {
            resultado += current.getValue();
        }
        resultado = sumarEntreAcumulador(current.getLeft(), resultado, min, max);
        resultado = sumarEntreAcumulador(current.getRight(), resultado, min, max);

        return resultado;
    }

    public Integer sumarEntreLocal(Integer min, Integer max) {
        return sumarEntreLocal(root, min, max);
    }

    private Integer sumarEntreLocal(Node current, Integer min, Integer max) {
        if (current == null) {
            return 0;
        }
        Integer resultado = 0;
        if (current.getValue() >= min && current.getValue() <= max) {
            resultado += current.getValue();
        }


        return resultado + sumarEntreLocal(current.getRight(), min, max) + sumarEntreLocal(current.getLeft(), min, max);

    }


    public Integer contarNodoxRango(Integer min, Integer max) {
        return contarNodoxRango(root, min, max);
    }

    private Integer contarNodoxRango(Node current, Integer min, Integer max) {
        if (current == null) {
            return 0;
        }
        Integer resultado = 0;
        if (current.getValue() >= min && current.getValue() <= max) {
            resultado++;
        }

        return resultado + contarNodoxRango(current.getLeft(), min, max) + contarNodoxRango(current.getRight(), min, max);
    }

    public Integer nodoMin() {
        return nodoMin(root);
    }

    private Integer nodoMin(Node current) {
        if (current == null) {
            return 0;
        }

        if (current.getLeft().getLeft() == null) {
            return current.getValue();
        }


        return nodoMin(current.getLeft());

    }

    public Integer cantHojas() {
        return cantHojas(root);
    }

    private Integer cantHojas(Node current) {
        if (current == null) {
            return 0;
        }
        Integer resultado = 0;
        if (current.getLeft() == null & current.getRight() == null) {
            resultado++;
        }

        return resultado + cantHojas(current.getLeft()) + cantHojas(current.getRight());
    }

    public Integer altura() {
        return altura(root) - 1;
    }

    private Integer altura(Node current) {
        if (current == null) {
            return 0;
        }
        Integer heightL = altura(current.getLeft()) + 1;
        Integer heightR = altura(current.getRight()) + 1;

        if (heightR > heightL) {
            return heightR;

        } else {
            return heightL;

        }
    }

    public Integer sumarPorNivel(Integer nivel) {
        return sumarPorNivel(root, nivel, 0);
    }

    private Integer sumarPorNivel(Node current, Integer nivel, Integer contadorNivel) {
        if (current == null) {
            return 0;
        }
        Integer suma = 0;
        if (contadorNivel.equals(nivel)) {
            suma += current.getValue();
        }


        return suma + sumarPorNivel(current.getLeft(), nivel, contadorNivel + 1) + sumarPorNivel(current.getRight(), nivel, contadorNivel + 1);

    }

    public Integer contarNodosInternos() {
        return contarNodosInternos(root);
    }

    private Integer contarNodosInternos(Node current) {
        if (current == null) {
            return 0;
        }
        Integer contador = 0;
        if (current.getRight() != null || current.getLeft() != null) {
            contador++;
        }

        return contador + contarNodosInternos(current.getLeft()) + contarNodosInternos(current.getRight());
    }

    public Integer contarNodosPorNivel(Integer nivel) {
        return contarNodosPorNivel(root, nivel, 0, 0);
    }

    private Integer contarNodosPorNivel(Node current, Integer nivel, Integer contadorNivel, Integer resultado) {
        if (current == null) {
            return resultado;
        }
        if (contadorNivel.equals(nivel)) {
            resultado++;
        }

        resultado = contarNodosPorNivel(current.getLeft(), nivel, contadorNivel + 1, resultado);
        resultado = contarNodosPorNivel(current.getRight(), nivel, contadorNivel + 1, resultado);

        return resultado;
    }

    public Integer contarNodosConUnHijo() {
        return contarNodosConUnHijo(root, 0);
    }

    private Integer contarNodosConUnHijo(Node current, Integer resultado) {
        if (current == null) {
            return resultado;
        }
        if ((current.getLeft() == null && current.getRight() != null) || (current.getRight() == null && current.getLeft() != null)) {
            resultado++;
        }
        resultado = contarNodosConUnHijo(current.getLeft(), resultado);
        resultado = contarNodosConUnHijo(current.getRight(), resultado);

        return resultado;
    }

    public List<Integer> nodosConUnHijo() {
        List<Integer> resultado = new ArrayList<>();
        nodosConUnHijo(root, resultado);
        return resultado;
    }

    private void nodosConUnHijo(Node current, List<Integer> resultado) {

        if (current == null) {
            return;
        }
        if ((current.getLeft() == null && current.getRight() != null) || (current.getRight() == null && current.getLeft() != null)) {
            resultado.add(current.getValue());
        }
        nodosConUnHijo(current.getLeft(), resultado);
        nodosConUnHijo(current.getRight(), resultado);

    }

    public List<Integer> nodosEntreNiveles(Integer nivel) {
        List<Integer> resultado = new ArrayList<>();
        nodosEntreNiveles(root, nivel, 0, resultado);
        return resultado;
    }

    public void nodosEntreNiveles(Node current, Integer nivel, Integer contarNiveles, List<Integer> resultado) {
        if (current == null) {
            return;
        }
        if (contarNiveles.equals(nivel)) {
            resultado.add(current.getValue());
        }

        nodosEntreNiveles(current.getLeft(), nivel, contarNiveles + 1, resultado);
        nodosEntreNiveles(current.getRight(), nivel, contarNiveles + 1, resultado);
    }

    public List<Integer> nodosHojas() {
        List<Integer> resultado = new ArrayList<>();

        nodosHojas(root, resultado);
        return resultado;
    }

    public void nodosHojas(Node current, List<Integer> resultado) {
        if (current == null) {
            return;
        }
        if (current.getRight() == null && current.getLeft() == null) {
            resultado.add(current.getValue());
        }

        nodosHojas(current.getLeft(), resultado);
        nodosHojas(current.getRight(), resultado);
    }

    public List<List<Integer>> todasLasRamas() {
        List<List<Integer>> resultado = new ArrayList<>();
        todasLasRamas(root, resultado, new ArrayList<>());
        return resultado;
    }

    private void todasLasRamas(Node current, List<List<Integer>> resultado, List<Integer> caminoParcial) {
        if (current == null) {
            return;
        }
        caminoParcial.add(current.getValue());
        // Si es una hoja (sin hijos), agrego una copia de la lista caminoParcial
        // Esto es necesario porque las listas son por referencia, y si agregara la lista original,
        // cualquier cambio posterior (como eliminar elementos) afectaría a las ramas ya agregadas.
        if (current.getLeft() == null && current.getRight() == null) {
            resultado.add(new ArrayList<>(caminoParcial));
        }
        todasLasRamas(current.getLeft(), resultado, caminoParcial);
        todasLasRamas(current.getRight(), resultado, caminoParcial);

        caminoParcial.remove(caminoParcial.size() - 1);

    }

    public List<Integer> nodosMasCercanos(Integer value) {
        List<Integer> resultado = new ArrayList<>();
        nodosMasCercanos(root, value, resultado);
        return resultado;
    }

    private void nodosMasCercanos(Node current, Integer value, List<Integer> resultado) {
        if (current == null) {
            return;
        }


        //Si del nodo actual tiene hijo izquierdo y el valor del hijo izquierdo es igual al valor del argumento
        //entonces seria el padre y lo agregamos
        if (current.getLeft() != null && current.getLeft().getValue().equals(value)) {
            resultado.add(current.getValue());
        }
        //Si del nodo actual tiene hijo derecho y el valor del hijo derecho es igual al valor del argumento
        //entonces seria el padre y lo agregamos
        if (current.getRight() != null && current.getRight().getValue().equals(value)) {
            resultado.add(current.getValue());
        }

        // Si estamos en el nodo igual al valor del argumento agregamos el valor de sus hijos si los tiene
        if (current.getValue().equals(value)) {

            if (current.getLeft() != null) {
                resultado.add(current.getLeft().getValue());
            }
            if (current.getRight() != null) {
                resultado.add(current.getRight().getValue());
            }
        }

        // Recursión en ambos subárboles
        nodosMasCercanos(current.getLeft(), value, resultado);
        nodosMasCercanos(current.getRight(), value, resultado);
    }

    public Integer nodoMax() {
        return nodoMax(root);
    }

    private Integer nodoMax(Node current) {
        if (current == null) {
            return 0;
        }

        if (current.getRight() == null) {
            return current.getValue();
        }

        return nodoMax(current.getRight());
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node current) {
        if (current == null) {
            System.out.print(" - ");
            return;
        }
        System.out.print(current.getValue() + " ");
        preOrder(current.getLeft());
        preOrder(current.getRight());
    }

    public void posOrder() {
        posOrder(root);
    }

    private void posOrder(Node current) {
        if (current == null) {
            System.out.print(" - ");
            return;
        }
        posOrder(current.getLeft());
        posOrder(current.getRight());
        System.out.print(current.getValue() + " ");
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node current) {
        if (current == null) {
            System.out.print(" - ");
            return;
        }
        inOrder(current.getLeft());
        System.out.print(current.getValue() + " ");
        inOrder(current.getRight());
    }

    public List<Integer> ramaMasLarga() {
        List<Integer> resultado = new ArrayList<>();
        ramaMasLarga(root, new ArrayList<>(), resultado);
        return resultado;
    }

    private void ramaMasLarga(Node current, List<Integer> caminoParcial, List<Integer> resultado) {
        if (current == null) {
            return;
        }
        caminoParcial.add(current.getValue());

        if (caminoParcial.size() > resultado.size()) {
            resultado.clear();
            resultado.addAll(caminoParcial);
        }
        ramaMasLarga(current.getLeft(), caminoParcial, resultado);
        ramaMasLarga(current.getRight(), caminoParcial, resultado);

        caminoParcial.remove(caminoParcial.size() - 1);

    }

    public boolean esCompleto() {
        return esCompleto(root);
    }

    private boolean esCompleto(Node current) {
        if (current == null) {
            return true;
        }

        if (
            //Si tiene izquierda y no tiene derecha () tiene un solo hijo
                (current.getLeft() == null && current.getRight() != null) ||
                        //Si no tiene izquierda y tiene derecha tiene un solo hijo
                        (current.getLeft() != null && current.getRight() == null)) {
            return false;
        }

        return esCompleto(current.getLeft()) && esCompleto(current.getRight());


    }

    public List<Integer> sumaRamas() {
        List<Integer> sumas = new ArrayList<>();
        sumaRamas(root, 0, sumas);
        return sumas;
    }

    public void sumaRamas(Node current, Integer sumaParcial, List<Integer> resultados) {
        if (current == null) {
            return;
        }
        sumaParcial += current.getValue();

        if (current.getRight() == null && current.getLeft() == null) {
            resultados.add(sumaParcial);
        }

        sumaRamas(current.getLeft(), sumaParcial, resultados);
        sumaRamas(current.getRight(), sumaParcial, resultados);


    }

    public List<Integer> caminoAUnNodo(Integer destino) {
        List<Integer> camino = new ArrayList<>();
        caminoAUnNodo(root, camino, destino);
        return camino;
    }

    public void caminoAUnNodo(Node current, List<Integer> camino, Integer destino) {
        if (current == null) {
            return;
        }
        camino.add(current.getValue());
        if (current.getValue().equals(destino)) {
            return;
        }
        caminoAUnNodo(current.getLeft(), camino, destino);
        caminoAUnNodo(current.getRight(), camino, destino);

        //Si el ultimo de la lista camino no es el mismo que el destino no lo borro.
        if (!camino.get(camino.size() - 1).equals(destino)) {
            camino.remove(camino.size() - 1);
        }
    }

    public List<List<Integer>> nodosHermanos() {
        List<List<Integer>> resultado = new ArrayList<>();
        nodosHermanos(root, resultado);
        return resultado;
    }

    public void nodosHermanos(Node current, List<List<Integer>> resultado) {
        if (current == null) {
            return;
        }
        if (current.getLeft() != null && current.getRight() != null) {
            resultado.add(Arrays.asList(
                    current.getLeft().getValue(),
                    current.getRight().getValue()
            ));

        }

        nodosHermanos(current.getLeft(), resultado);
        nodosHermanos(current.getRight(), resultado);


    }

    public List<Integer> ramaMasLarga2() {
        List<Integer> ramaMasLarga = new ArrayList<>();
        ramaMasLarga2(root, ramaMasLarga, new ArrayList<>());
        return ramaMasLarga;
    }

    public void ramaMasLarga2(Node current, List<Integer> resultado, List<Integer> caminoParcial) {

        if (current == null) {
            return;
        }
        caminoParcial.add(current.getValue());
        if (caminoParcial.size() > resultado.size()) {
            //saco lo que ya hay
            resultado.clear();
            resultado.addAll(caminoParcial);
        }

        ramaMasLarga2(current.getLeft(), resultado, caminoParcial);
        ramaMasLarga2(current.getRight(), resultado, caminoParcial);

        //vacio el camino parcial a la vuelta sacando siempre le ultimo elemento.
        caminoParcial.remove(caminoParcial.size() - 1);
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

package Tema_3.EJ4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sistema {

    private HashMap<Integer, Cliente> clientes;

    public Sistema() {
        this.clientes = new HashMap<Integer, Cliente>();
    }

    //O(1)
    public void addCliente(Cliente nuevoCliente) {
        this.clientes.put(nuevoCliente.getDni(), nuevoCliente);
    }

    //O(1)
    public Double saldoPorCliente(Integer dni) {
        return this.clientes.get(dni).getSaldo_cuenta();
    }

    //O(n)
    public List<List<String>> listaClientesConSaldoMenor(Double saldo) {
        List<List<String>> resultado = new ArrayList<>();

        for (Cliente cliente : this.clientes.values()) {
            if (cliente.getSaldo_cuenta() < saldo) {
                List<String> subResultado = new ArrayList<>();
                subResultado.add(cliente.getNombre());
                subResultado.add(cliente.getApellido());

                resultado.add(subResultado);
            }
        }

        return resultado;
    }

    //O(n)
    public List<Cliente> listaClientesPorCPostal(Integer cp) {
        List<Cliente> resultado = new ArrayList<>();

        for (Cliente cliente : this.clientes.values()) {
            if (cliente.getCp().equals(cp)) {
                resultado.add(cliente);
            }
        }
        return resultado;

    }

}

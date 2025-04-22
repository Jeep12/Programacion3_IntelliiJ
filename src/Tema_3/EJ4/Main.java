package Tema_3.EJ4;
import java.util.Date;
public class Main {

    public static void main(String[] args) {
        Sistema sis = new Sistema();

        Cliente cliente1 = new Cliente(12345678, "Juan", "Gómez", 15000.0, "TUDAI", new Date(2000, 5, 15), 7000, "Tandil");
        Cliente cliente2 = new Cliente(87654321, "Lucía", "Pérez", 22000.0, "Ing. Sistemas", new Date(1998, 3, 20), 7600, "Azul");
        Cliente cliente3 = new Cliente(22334455, "Mariano", "Martínez", 18000.0, "TUDAI", new Date(2001, 8, 10), 7000, "Tandil");
        Cliente cliente4 = new Cliente(33445566, "Florencia", "Rodríguez", 25000.0, "Lic. Informática", new Date(1997, 11, 5), 7400, "Olavarría");
        Cliente cliente5 = new Cliente(44556677, "Pedro", "Sánchez", 20000.0, "TUDAI", new Date(1999, 1, 30), 7000, "Tandil");

        sis.addCliente(cliente1);
        sis.addCliente(cliente2);
        sis.addCliente(cliente3);
        sis.addCliente(cliente4);
        sis.addCliente(cliente5);


        System.out.println(sis.saldoPorCliente(87654321));

        System.out.println(sis.listaClientesConSaldoMenor(19000.0));

        System.out.println(sis.listaClientesPorCPostal(7000));

    }
}

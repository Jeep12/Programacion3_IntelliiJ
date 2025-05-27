package Tema_5.Varios.GPT1;

public class Plato {
    Integer precio;
    Integer calorias;
    Integer sabor;


    public Plato(int calorias, int precio, int sabor) {
        this.calorias = calorias;
        this.precio = precio;
        this.sabor = sabor;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getSabor() {
        return sabor;
    }

    public void setSabor(int sabor) {
        this.sabor = sabor;
    }


}

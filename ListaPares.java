public class ListaPares{

    private String nombreA;
    private String nombreB;

    public ListaPares( String nombreA, String nombreB ){
        this.nombreA = nombreA;
        this.nombreB = nombreB;
    }

    public ListaPares(){

    }

    public boolean estaEnLista( String nombre ){
        return nombreA.equals(nombre) || nombreB.equals(nombre);
    }

    public String retornarConocido( ){
        return nombreB;
    }

}
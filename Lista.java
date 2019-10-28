public class Lista{

    private String nombre;
    private boolean considerar;


    public Lista( String nombre, boolean considerar ){
        this.nombre = nombre;
        this.considerar = considerar;
    }

    public Lista( String nombre ){
        this.nombre = nombre;
        this.considerar = true;
    }

    public boolean getConsiderar(){
        return considerar;
    }

    public String getNombre(){
        return nombre;
    }

    public void setConsiderar( boolean considerar ){
        this.considerar = considerar;
    }

    @Override
    public String toString(){
        return "[Nombre: " + nombre + " , Considerar: " + considerar + " ]";
    }

}
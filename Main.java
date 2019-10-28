import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main{

    public static void main(String[] args) {
        
        Lista listaA[] = { new Lista("Isaias"), 
                           new Lista("Hugo"),
                           new Lista("Luis"),
                           new Lista("Oscar"),
                           new Lista("Einar"),
                           new Lista("Ricardo"),
                           new Lista("Daniel"),
                           new Lista("Ariel"),
                           new Lista("Jesus"),
                           new Lista("Omar"),
                           new Lista("Alejandro"),
                           new Lista("Ivan"),
                           new Lista("Jack"),
                           new Lista("John"),
                           new Lista("Sparrow"),
                           new Lista("Joan"),
                           new Lista("Joaquin")
                        };

        ListaPares listaB [] = { new ListaPares("Isaias", "Hugo"), 
                                 new ListaPares("Isaias", "Luis"), 
                                 new ListaPares("Isaias", "Oscar"),
                                 new ListaPares("Isaias", "Einar"),
                                 new ListaPares("Isaias", "Daniel"),
                                 new ListaPares("John", "Sparrow"),
                                 new ListaPares("John", "Joaquin"),
                                 new ListaPares("John", "Ivan"),
                                 new ListaPares("John", "Jack"),
                                 new ListaPares("John", "Alejandro"),
                                };

        //remover el que conoce de la lista

        ArrayList<String> listaInvitados = new ArrayList<>();
        int cont = 0;


            for( int i=0; i<listaA.length; i++ ){
                
            
                int contadorConocidos = 0 ;
                ArrayList<String> aux = new ArrayList<>();
    
                for( int j = 0; j<listaB.length; j++){
                    if( listaB[j].estaEnLista(listaA[i].getNombre() )  && listaA[i].getConsiderar() ){
                        contadorConocidos++;
                        aux.add(listaB[j].retornarConocido());
                        
                    }
                }
    
                if( contadorConocidos >= 5 && ( -contadorConocidos + listaA.length ) >= 5 ){
                    listaInvitados.add(listaA[i].getNombre());
                    for(int k=0; k<aux.size(); k++){
                        cambiarEstado(aux.get(k), listaA);
                    }
                }
                
                aux.clear();
            }
            
            System.out.println("Lista invitados: " + listaInvitados);

    }

    public static void cambiarEstado( String nombre, Lista[] lista ) {
        for( int i=0; i< lista.length; i++ ){
            if( nombre.equals(lista[i].getNombre())){
                lista[i].setConsiderar(false);
            }
        }
    }
  

}
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) {

        
        ArrayList<Lista> listaA = new ArrayList<>();
        ArrayList<ListaPares> listaB = new ArrayList<>();

        llenarLista( listaA , listaB , args );


        //remover el que conoce de la lista

        ArrayList<String> listaInvitados = new ArrayList<>();
        int cont = 0;


            for( int i=0; i<listaA.size(); i++ ){
                
            
                int contadorConocidos = 0 ;
                ArrayList<String> aux = new ArrayList<>();
    
                for( int j = 0; j<listaB.size(); j++){
                    if( listaB.get(j).estaEnLista(listaA.get(i).getNombre() )  && listaA.get(i).getConsiderar() ){
                        contadorConocidos++;
                        aux.add(listaB.get(j).retornarConocido());
                        
                    }
                }
    
                if( contadorConocidos >= 5 && ( -contadorConocidos + listaA.size() ) >= 5 ){
                    listaInvitados.add(listaA.get(i).getNombre());
                    for(int k=0; k<aux.size(); k++){
                        cambiarEstado(aux.get(k), listaA);
                    }
                }
                
                aux.clear();
            }
            
            System.out.println("Lista invitados: " + listaInvitados);

    }

    public static void cambiarEstado( String nombre, ArrayList<Lista> lista ) {
        for( int i=0; i< lista.size(); i++ ){
            if( nombre.equals(lista.get(i).getNombre())){
                lista.get(i).setConsiderar(false);
            }
        }
    }

    public static void llenarLista( ArrayList<Lista> listaA , ArrayList<ListaPares> listaB, String args[] ){

        try{

            File archivo = new File("pruebaCod\\" + args[0]);
            FileReader fr = new FileReader (archivo);
            BufferedReader br = new BufferedReader(fr);
    
            
            String listaA_cad = br.readLine();

            StringTokenizer st = new StringTokenizer(listaA_cad, ",");
            while( st.hasMoreTokens() ){
                listaA.add(new Lista(st.nextToken()));
            }

            String listaB_cad = br.readLine();

            StringTokenizer st_b = new StringTokenizer(listaB_cad, ";");
            
            while( st_b.hasMoreTokens()){
                StringTokenizer pares = new StringTokenizer(st_b.nextToken(), "-");
                listaB.add(new ListaPares( pares.nextToken(), pares.nextToken() ));
            }
            
            


            br.close();
            
            }catch( Exception e ){
                System.out.println(e);
            }

    }
  

}
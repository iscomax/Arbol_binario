import java.util.Scanner;

//clase principal
public class Arbol {
//metodo princial
public static void main( String args[] ){
    Scanner entrada = new Scanner(System.in);//nuevo objeto scanner
    //variables globales
    int opcion;
    boolean salir =false;
    while (salir==false) {
        System.out.println();//mensaje en pantalla a el usuario
        System.out.println("Ingresa el numero de nodos que tendra el arbol");
        int num_nodos = entrada.nextInt();//nos indica el nuemro de nodos del arbol
        int contador =1;//variable contador
        int valor_nodo;//variable para capurar el valor de cada nodo
        
        ab nuevo_arbol= new ab();//nuevo objeto ab con los medotos para el arbol
        //Iniciamps el cliclo while 
        while (contador <=num_nodos) {
           
            System.out.print((contador)+ ".- Ingresa el valor tipo entero del nodo : ");
            valor_nodo = entrada.nextInt();
           nuevo_arbol.insertar(valor_nodo);
           contador ++;
        }
        boolean opc =false;
        while (opc ==false) {
            System.out.println();
            System.out.println("ingresa una opcion del menu");
           
            System.out.println("1.-Mostrar el recoorido preorden");
            System.out.println("2.-Mostrar el recoorido  Inorden ");
            System.out.println("3.-Mostrar el recoorido posnorden ");
            System.out.println("4.-Ingresar un nuevo valor al arbol");
            System.out.println("5.-Borrar un nodo del arbol");
            System.out.println("6.-Buscar un Valor de Arbol");
            System.out.println("7.- Mostrar la Altura del Arbol");
            System.out.println("8.- salir para ingresar un nuevo arbol");
            opcion = entrada.nextInt();
            System.out.println();

         switch (opcion) {
            case 1:
            System.out.println();
            System.out.println("El recorrido preorden es :");
                nuevo_arbol.pre();
                
                break;
            case 2:
            System.out.println();
            System.out.println("El recorrido inorden es :");
                nuevo_arbol.in();
                break;
            case 3:
            System.out.println();
            System.out.println("El recorrido posorden es :");
                nuevo_arbol.pos();
                break;
            case 4:
            System.out.println("Ingresa el nuevo valor del nodo");
                valor_nodo = entrada.nextInt();
                nuevo_arbol.insertar(valor_nodo);
                System.out.println("el nuevo valor ha sido agregado");
                break;
            case 5:
                System.out.println("Ingresa el valor del nodo a eliminar");
                int eliminar_nodo = entrada.nextInt();
                nuevo_arbol.borrar(eliminar_nodo);
                nuevo_arbol.pre();
            
                break;
            case 6:
                 //variables locales
                 boolean resultado;
                 //pedimos al usuario que ingrese el valor a buscar en el arbol
                 System.out.println("ingresa el valor a buscar");
                 int buscar_nodo = entrada.nextInt();//leemos el valor
                 resultado = nuevo_arbol.buscar(buscar_nodo);//usamor el metodo buscar
                 //mostramos en pantalla al usuario el resultado de la  busqueda
                 if (resultado ==true) {
                     System.out.println("el valor del nodo si se encuentra en el arbol");
                 } else {
                     System.out.println("el valor del nodo nose encuentra en el arbol");
                 }
                 break;
            case 7:
                 System.out.println("La Altura del Arbol es: ");
                System.out.println(nuevo_arbol.altura(nuevo_arbol.raiz));
                
                break;
            case 8:
                 opc =true;
                break;
            default:
            System.out.println("opcion invalida ");
                break;
            }
        }
    }

    }
} 


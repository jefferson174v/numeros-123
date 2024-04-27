//Jefferson Aron Flores Corea 17m-S
//carnet: 2024-1626U

//creo yo que esto es lo que menciono usted profesor.
//tiene sentido porque maneja situaciones donde el tipo de dato 
//esperado no coincide con el tipo de dato ingresado
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // inicio el programa.
        System.out.println("Ingrese tres números enteros diferentes:");

        int num1, num2, num3;
        // se usa el do while para solicitar los numeros
        do {
            // se llama al metodo numero que es el encargado de guardar las variables ( numeros )  en las sig variables que se  declararon como enteros antes
            num1 = numero(sc);
            num2 = numero(sc);
            num3 = numero(sc);

            // Verifica si los números ingresados son diferentes
            if (num1 == num2 || num1 == num3 || num2 == num3) {
                System.out.println("Error: Los números deben ser diferentes. Por favor, ingrese nuevamente.");
            }
        } while (num1 == num2 || num1 == num3 || num2 == num3); // aca este bucle es infinito si los numeros siguen
                                                                // siendo iguales
        //si no son iguales no dentra al bucle do while
        // por lo que la unica manera de salir del bucle es que no sean iguales

        // Estos metodos retornan la suma de menores, la resta de mayores y el num mayor
        int sumaMenores = SumaMenores(num1, num2, num3);
        int RestaMayores = RestaaMayores(num1, num2, num3);
        int mayor = encontrarMayor(num1, num2, num3);
        // aca se muestra en pantalla el retono de los metodos que se llamaron
        // anteriormente
        System.out.println("La suma de los dos números más pequeños es: " + sumaMenores);
        System.out.println("La diferencia entre los dos números más grandes es: " + RestaMayores);
        System.out.println("El número mayor es: " + mayor);
        // cerramos el Scanner .....
        sc.close(); 
    }

    // inicio con los metodos,
    //este metodo es el encargado de pedir los numeros.
    public static int numero(Scanner sc) {
        // Se crea un bucle, en este caso while por ser especificamente para lo que deseo
        // que te pida dijitar el numero hasta que se rompa el while con el return del
        // numero dijitado, esto no se rompe si hay uan excepcion
        while (true) {
            System.out.print("Ingrese un número entero: ");
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {// aca se captura la excepcion que se lanza cuando el tipo de dato
                                                // ingresado por el usuario no coincide con el tipo de dato esperado que es un entero
                System.out.println("Error: Por favor, ingrese un número entero válido.");
                // Limpiar el buffer del scanner en caso de que se ingrese una entrada no válida
                sc.nextLine(); // se llama de nuevo para que dijite los numeros
                // se rompre el catch sin embargo vuelve al while puesto que no retorno nada
            }
        }
        // ingresado los 3 datos se rompe el ciclo while
    }

    // este metodo controla la suma de los menores, para lo cual primero se necesta conocer
    // el num mas pequeno comparando los valores
    public static int SumaMenores(int num1, int num2, int num3) {
        int menor1 = num1; // Esta variable se utilizará para almacenar el número más pequeño de los tres
        if (num2 < menor1) { // Se compara num2 con menor1, Si num2 es menor que menor1
            menor1 = num2;// se actualiza el valor de menor1 para que sea igual a num2 y se hace lo mismo
                          // para num3
        }
        if (num3 < menor1) {
            menor1 = num3;
        } // en num1 se contiene lo que es el numero mas pequeno

        int menor2; // Dependiendo de cuál sea igual a menor1 se le asigna el valor mínimo entre los
                    // otros dos números a menor2
        if (menor1 == num1) {// Si menor1 es igual a num1 significa que num1 es el número más pequeño
            menor2 = Math.min(num2, num3); // math.min devuelve el valor más pequeño de dos números
        } else if (menor1 == num2) { // Si menor1 es igual a num2, significa que es el valor mínimo entre num1 y num3
            menor2 = Math.min(num1, num3);
        } else {
            menor2 = Math.min(num1, num2); // Si ninguna de las condiciones anteriores se cumple significa que menor1 es
                                           // igual a num3, y num3 es el número más pequeño. Entonces
            // menor2 se asigna como el valor mínimo entre num1 y num2 utilizando
            // Math.min(num1, num2)
        }
        // finalmente se retorna la suma de los dos numerosencontrados que son los
        // menores
        return menor1 + menor2;
    }

    // aca se realiza la resta de mayores
    public static int RestaaMayores(int num1, int num2, int num3) {
        int mayor1 = encontrarMayor(num1, num2, num3);
        int menor = num1; // se inicializa el num menor
        if (num2 < menor) { //verifica si el valor de la variable num2 es menor que el valor actual almacenado en la variable menor
            menor = num2; //  para uego si lo es pasa a ser el valor de num2
        }
        if (num3 < menor) {
            menor = num3;
        }
        int mayor2 = num1 + num2 + num3 - mayor1 - menor; // este paso es importante para encontrar el num de enmedio
        // se hace intuitivamente sabiendo que se sabe el mayor y el menor, por lo que
        // su suma total y resta del mayor y menos el menor es igual al de enmedio
        return mayor1 - mayor2;
    }

    // hice una matriz con los valores de um1 num2 num3 como valor en sus columnas
    // con el objetivo de recorrer con un for each sus valores almacenados para
    // compararlos y mostrar el mayor
    public static int encontrarMayor(int num1, int num2, int num3) {
        int comp = num1; // Se tiene que inicializarn en num 1,de otro modo si fuese 0, no funcionaria
                         // con neagtivos
        int numeros[] = { num1, num2, num3 };
        for (int i : numeros) {
            if (i > comp) {
                comp = i;
            }
        }
        return comp; // retorna el num mayor
        // muchas gracias
    }
}

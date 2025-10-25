package crudpoo;

import java.util.Scanner;

// Clase abstracta CrudConsola<T>
// Plantilla reusable para CRUDs de consola (genérico con <T>), con helpers.

public abstract class CrudConsola<T> {
          // ABSTRACTO-> SIRVE PARA HERENCIA
   // lo defino como abstracto porque no voy a necesitar crear objetos en memoria de esto, si sirve para heredar.
    // cual es el constructor de la clase abstracta?
    //   - No tiene un constructor explícito, pero Java crea uno por defecto.
    //   - Las clases hijas pueden llamar al constructor de la superclase si es necesario.
    //   - Las clases hijas deben implementar los métodos abstractos.
    // por qué no definir un constructor aquí?
    //   - Porque no hay atributos específicos que inicializar en la clase abstracta.
    //   - Porque las clases hijas pueden tener sus propios atributos y constructores.
    //   - Porque queremos mantener la clase abstracta lo más genérica posible.
    
    // que es final?
    //   - Es una palabra clave que indica que la variable no puede ser reasignada.
    //   - Es una buena práctica para variables compartidas que no deben cambiar.
    //   - Ayuda a evitar errores accidentales de reasignación.
    // por qué usar final aquí?
    //   - Porque el Scanner es un recurso compartido que no debe cambiar.
    //   - Porque queremos asegurarnos de que todas las subclases usen el mismo Scanner.
    //   - Porque mejora la legibilidad y el mantenimiento del código.
    // por qué no usar static?
    //   - Porque no necesitamos que sea compartido entre todas las instancias.
    //   - Porque cada instancia de CrudConsola puede tener su propio Scanner si es necesario.
    //   - Porque no queremos que el Scanner persista más allá del ciclo de vida de la instancia.
    // es mutable?
    //   - No, la referencia es inmutable (final), pero el estado del Scanner sí puede cambiar.
    //   - Podemos usar el Scanner para leer diferentes entradas sin problema.
    //   - Podemos cerrar el Scanner si es necesario, pero no reasignarlo.
    // qué pasa si lo cerramos?
    //   - Si cerramos el Scanner, no podremos usarlo nuevamente para leer entradas.
    //   - Si intentamos usar un Scanner cerrado, lanzará una excepción.
    //   - Por eso, generalmente no cerramos el Scanner que lee de System.in.

    //Las excepciones en Java son eventos inesperados que interrumpen el flujo normal de ejecución de un programa.
    //Permiten manejar errores y condiciones anómalas de forma controlada, evitando que el programa se bloquee.

    protected final Scanner scanner = new Scanner(System.in); // Scanner compartido
      // Para que hereden los CRUDS//
    public abstract void crear();
    public abstract void listar();
    public abstract void actualizar();
    public abstract void eliminar();


    // Uso void porque no devuelve nada --> El void es pq no retorna nada, PUBLIC pq se puede acceder, STATIC pq no depende ninguna clase, Abstracto para heredar .//
    public void mostrarOpciones() {
        System.out.println("\n=== Menú CRUD ===");
        System.out.println("1) Crear");
        System.out.println("2) Listar");
        System.out.println("3) Actualizar");
        System.out.println("4) Eliminar");
        System.out.println("0) Volver/Salir");
        System.out.print("Opción: ");
    }
 

    // por qué estos métodos?
    //   - Porque son comunes a muchos CRUDs y evitan duplicación de código.
    //   - Porque mejoran la experiencia de usuario al manejar errores de entrada.
    //   - Porque facilitan la lectura y mantenimiento del código.
    // por qué no hacerlos estáticos?
    //   - Porque usan el Scanner de instancia (no pueden ser estáticos).
    //   - Porque podrían necesitar acceso a otros atributos/métodos de instancia en el futuro.
    //   - Porque mantenerlos como instancia permite mayor flexibilidad y personalización.



    protected int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String linea = scanner.nextLine();
                return Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe ser un número entero.");
            }
        }
    }

    protected double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String linea = scanner.nextLine();
                return Double.parseDouble(linea.trim());
            } catch (NumberFormatException e) {
                System.out.println("Debe ser un número (use punto).");
            }
        }
    }

    protected String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}

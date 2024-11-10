package interfaz;

import dominio.Libreta;
import dominio.Contacto;

public class interfaz {

    public void procesarPeticion(String[] args, Libreta libreta) {
        if (args.length == 0) {
            System.out.println("Uso: java -jar libreta.jar <operación>");
            return;
        }

        String operacion = args[0];

        switch (operacion) {
            case "add":
                if (args.length != 3) {
                    System.out.println("Uso: java -jar libreta.jar add <nombre> <teléfono>");
                    return;
                }
                String nombre = args[1];
                String telefono = args[2];
                Contacto nuevoContacto = new Contacto(nombre, telefono);
                libreta.añadirContacto(nuevoContacto);
                System.out.println("Contacto añadido: " + nuevoContacto);
                break;

            case "list":
                System.out.println("Listado de contactos:");
                System.out.println(libreta.toString());
                break;

            case "help":
                mostrarAyuda();
                break;

            case "delete":
                if (args.length != 2) {
                    System.out.println("Uso: java -jar libreta.jar delete <nombre>");
                    return;
                }
                String nombreBorrar = args[1];
                if (libreta.borrarContacto(nombreBorrar)) {
                    System.out.println("Contacto " + nombreBorrar + " borrado.");
                } else {
                    System.out.println("No se encontró el contacto.");
                }
                break;

            case "update":
                if (args.length != 3) {
                    System.out.println("Uso: java -jar libreta.jar update <nombre> <nuevo teléfono>");
                    return;
                }
                String nombreActualizar = args[1];
                String nuevoTelefono = args[2];
                if (libreta.modificarContacto(nombreActualizar, nuevoTelefono)) {
                    System.out.println("Contacto " + nombreActualizar + " modificado.");
                } else {
                    System.out.println("No se encontró el contacto.");
                }
                break;

            default:
                System.out.println("Operación no reconocida. Use 'help' para más información.");
                break;
        }
        case "export"
            libreta.generarCSV();
        break;
    }

    private void mostrarAyuda() {
        System.out.println("Las operaciones posibles son las siguientes:");
        System.out.println("Añadir contacto: 'java -jar libreta.jar add <nombre> <teléfono>'");
        System.out.println("Ejemplo: java -jar libreta.jar add Pepe 654321234");
        System.out.println("Mostrar contactos: 'java -jar libreta.jar list'");
        System.out.println("Borrar contacto: 'java -jar libreta.jar delete <nombre>'");
        System.out.println("Modificar contacto: 'java -jar libreta.jar update <nombre> <nuevo teléfono>'");
        System.out.println("Mostrar esta ayuda: 'java -jar libreta.jar help'");
    }
}
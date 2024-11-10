package Principal;

import Interfaz.interfaz;
import dominio.Libreta;

    public class aplicacion {

        public static void main(String[] args) {
            Libreta libreta = new Libreta();
            Interfaz Interfaz = new Interfaz();

            Interfaz.hacerPeticion(args, libreta);
        }
    }
}
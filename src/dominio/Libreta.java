package dominio;

import dominio.Contacto;
import java.io.*;
import java.util.ArrayList;

public class Libreta {
    private ArrayList<Contacto> contactos;
    private static final String ARCHIVO_CONTACTOS = "contactos.txt";

    public Libreta() {
        this.contactos = new ArrayList<>();
        cargarContactosDesdeArchivo();
    }

    public void añadirContacto(Contacto contacto) {
        contactos.add(contacto);
        guardarContactosEnArchivo();
    }

    public boolean borrarContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                contactos.remove(contacto);
                guardarContactosEnArchivo();
                return true; // Borrado exitoso
            }
        }
        return false; // No se encontró el contacto
    }

    public boolean modificarContacto(String nombre, String nuevoTelefono) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                contacto.setTelefono(nuevoTelefono);
                guardarContactosEnArchivo();
                return true; // Modificación exitosa
            }
        }
        return false; // No se encontró el contacto
    }

    private void cargarContactosDesdeArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_CONTACTOS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    Contacto contacto = new Contacto(datos[0], datos[1]);
                    contactos.add(contacto);
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo de contactos.");
        }
    }

    private void guardarContactosEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CONTACTOS))) {
            for (Contacto contacto : contactos) {
                bw.write(contacto.getNombre() + "," + contacto.getTelefono());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo de contactos.");
        }
        public void generarCSV() {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("contactos.csv"))) {
                for (Contacto contacto : contactos) {
                    bw.write(contacto.getNombre() + "," + contacto.getTelefono());
                    bw.newLine();
                }
                System.out.println("Archivo CSV generado: contactos.csv");
            } catch (IOException e) {
                System.out.println("No se pudo generar el archivo CSV.");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Contacto contacto : contactos) {
            sb.append(contacto.toString()).append("\n");
        }
        return sb.toString();
    }
}
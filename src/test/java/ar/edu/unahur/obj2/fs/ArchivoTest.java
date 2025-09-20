package ar.edu.unahur.obj2.fs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArchivoTest {

    @Test public void crearArchivoConNombreExtensionYTamanio(){
        Archivo archivo = new Archivo("Notas",".txt", 120);
        assertEquals("Notas.txt", archivo.nombre());
        assertEquals(Integer.valueOf(120), archivo.tamanio());
    }

}

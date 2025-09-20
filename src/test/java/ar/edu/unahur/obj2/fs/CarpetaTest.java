package ar.edu.unahur.obj2.fs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class CarpetaTest {

    @Test
    public void crearCarpetaVacia() {
        Carpeta carpeta = new Carpeta("MisDocumentos");
        assertEquals("MisDocumentos", carpeta.nombre());
        assertEquals(Integer.valueOf(0), carpeta.tamanio());

    }

    @Test
    public void carpetaConArchivosDevuelveTamanioTotal() {
        Carpeta carpeta = new Carpeta("Descargas");
        carpeta.agregar(new Archivo("foto", ".jpg", 300));
        carpeta.agregar(new Archivo("musica", ".mp3", 700));
        assertEquals(Integer.valueOf(1000), carpeta.tamanio());

    }

    @Test
    public void carpetaConCarpetasAnidadasDevuelveTamanioTotal() {
        Carpeta carpetaPrincipal = new Carpeta("Principal");
        Carpeta subCarpeta = new Carpeta("Sub");
        subCarpeta.agregar(new Archivo("doc", ".txt", 50));
        carpetaPrincipal.agregar(subCarpeta);
        carpetaPrincipal.agregar(new Archivo("musica", ".mp3", 200));
        assertEquals(Integer.valueOf(250), carpetaPrincipal.tamanio());

    }

    @Test
    public void obtenerArchivoMasPesadoEnCarpeta() {
        Carpeta carpeta = new Carpeta("Media");
        carpeta.agregar(new Archivo("chico", ".jpg", 100));
        carpeta.agregar(new Archivo("grande", ".mp3", 500));
        ElementoSistemaArchivos masPesado = carpeta.archivoMasPesado();
        assertEquals("grande.mp3", masPesado.nombre());

    }

    @Test
    public void obtenerArchivoMasPesadoEnCarpetaAnidada() {
    }

    @Test
    public void archivoMasPesadoEnCarpetaVaciaDevuelveNull() {
        Carpeta vacia = new Carpeta("empty");

        ElementoSistemaArchivos masPesado = vacia.archivoMasPesado();

        assertNull(masPesado);
    }

    
}

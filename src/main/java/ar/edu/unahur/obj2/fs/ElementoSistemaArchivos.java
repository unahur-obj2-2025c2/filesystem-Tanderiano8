package ar.edu.unahur.obj2.fs;

public abstract class ElementoSistemaArchivos {

    protected String nombre;

    public ElementoSistemaArchivos(String nombre) {
        this.nombre = nombre;
    }

    public abstract String nombre();

    public abstract Integer tamanio();

    public abstract ElementoSistemaArchivos archivoMasPesado();

}

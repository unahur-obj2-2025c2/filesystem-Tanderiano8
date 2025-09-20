package ar.edu.unahur.obj2.fs;

public class Archivo extends ElementoSistemaArchivos{

    private String extension;
    private Integer tamanio;

    public Archivo(String nombre, String extension, Integer tamanio) {
        super(nombre) ;
        this.extension = extension ;
        this.tamanio = tamanio ;
    }

    @Override
    public String nombre() {
        return this.nombre + this.extension;
    }

    public Integer tamanio() {
        return this.tamanio;
    }

    @Override
    public ElementoSistemaArchivos archivoMasPesado() {
        return this;
    }

}

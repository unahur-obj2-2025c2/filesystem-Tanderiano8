package ar.edu.unahur.obj2.fs;

import java.util.ArrayList;
import java.util.List;

public class Carpeta extends ElementoSistemaArchivos {

    private List<ElementoSistemaArchivos> elementos = new ArrayList<ElementoSistemaArchivos>();

    public Carpeta(String nombre) {
        super(nombre);
    }

    @Override
    public String nombre() {
        return nombre;
    }

    public Integer tamanio() {
        Integer tamanio = 0;
        for (ElementoSistemaArchivos elemento : this.elementos) {
            tamanio += elemento.tamanio();
        }
        return tamanio;
    }

    public void agregar(ElementoSistemaArchivos elemento) {
        this.elementos.add(elemento);

    }

    public ElementoSistemaArchivos archivoMasPesado() {
        ElementoSistemaArchivos masPesado = null;

        for (ElementoSistemaArchivos elemento : this.elementos) {
            if (elemento instanceof Carpeta){
                ElementoSistemaArchivos candidato = ((Carpeta) elemento).archivoMasPesado();
                masPesado = compararPesos(masPesado, candidato);
            }else {
                masPesado = compararPesos(masPesado, elemento);
            }
            
        }
        return masPesado;
    }

    private ElementoSistemaArchivos compararPesos(ElementoSistemaArchivos actual,
            ElementoSistemaArchivos candidato) {
        if (candidato == null)
            return actual;
        if (actual == null)
            return candidato;
        if (candidato.tamanio() > actual.tamanio()) {
            return candidato;
        }
        return actual;
    }

}

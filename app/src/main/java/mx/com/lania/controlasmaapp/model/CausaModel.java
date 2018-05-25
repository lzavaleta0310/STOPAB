package mx.com.lania.controlasmaapp.model;

import java.io.Serializable;

public class CausaModel implements Serializable {
    private String causa;
    private boolean seleccionado;

    public CausaModel() {}

    public CausaModel(String causa, boolean seleccionado) {
        this.causa = causa;
        this.seleccionado = seleccionado;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
}

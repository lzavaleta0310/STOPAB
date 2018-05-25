package mx.com.lania.controlasmaapp.model;

public class SintomaCard {
    private boolean isChecked;
    private String sintoma;
    private String respuestaSintoma;

    public SintomaCard() {
    }

    public SintomaCard(boolean isChecked, String sintoma, String respuestaSintoma) {
        this.isChecked = isChecked;
        this.sintoma = sintoma;
        this.respuestaSintoma = respuestaSintoma;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public String getRespuestaSintoma() {
        return respuestaSintoma;
    }

    public void setRespuestaSintoma(String respuestaSintoma) {
        this.respuestaSintoma = respuestaSintoma;
    }
}

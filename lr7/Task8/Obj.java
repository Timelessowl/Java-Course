package lr7.Task8;

import java.io.Serializable;

public class Obj implements Serializable {
    private int numField;
    private String strField;

    public String getStrField() {
        return strField;
    }

    public int getNumField() {
        return numField;
    }

    public Obj(int numField, String strField) {
        this.numField = numField;
        this.strField = strField;
    }
}

package br.gov.sp.cps.fatecipiranga;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class TesteLombok {
    private int numero;
    private String texto;

    public static void main(String[] args) {
        TesteLombok lom = new TesteLombok(887, "lombok");
        System.out.println(lom.getNumero());
        System.out.println(lom.getTexto());
        System.out.println(lom.toString());
    }
}
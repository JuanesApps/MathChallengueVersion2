package com.example.juanesteban.mathchallengueversion2;

import java.util.Random;

public class Generador {

    public int n1;
    public int n2;
    public String signo;

    public Generador(Random rdm) {
        n1 = rdm.nextInt(50);
        n2 = rdm.nextInt(50);
        signo = asignarSigno(rdm.nextInt(4) + 1);
    }

    public String asignarSigno(int i) {
        String ans = "";
        switch (i) {
            case 1:
                ans = "+";
                break;
            case 2:
                ans = "-";
                break;
            case 3:
                ans = "*";
                break;
            case 4:
                ans = "/";
                break;
            default:
                break;
        }
        return ans;
    }

    public int confirmarRespuesta() {
        int i = 0;
        switch (signo) {
            case "+":
                i = n1 + n2;
                break;
            case "-":
                i = n1 - n2;
                break;
            case "*":
                i = n1 * n2;
                break;
            case "/":
                i = n1 / n2;
                break;
            default:
                break;
        }
        return i;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }
}

package org.example;
import java.util.Collections;
import java.util.TreeMap;
import java.util.Map;

public class Polynomial {
    private Map<Integer, Double> monomials;
    public Polynomial() {
        this.monomials = new TreeMap<>(Collections.reverseOrder());// un TreeMap gol
    }
    public Polynomial(Map<Integer, Double> monomials) {
        this.monomials = monomials;
    }//initializare
    public Map<Integer, Double> getMonomials() {

        return this.monomials;
    }

    public void setMonomials(Map<Integer, Double> monomials) {
        this.monomials = monomials;
    }
    public void addMonomial(int exponent, double coeficient) {
        this.monomials.put(exponent, coeficient);
    }

    public Polynomial add(Polynomial p2) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> entry : this.monomials.entrySet()) {//iterez prin fiecare monom al  primului  polinom
            result.addMonomial(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<Integer, Double> entry : p2.getMonomials().entrySet()) {
            int exponent = entry.getKey();
            double coeficient = entry.getValue();
            if (result.getMonomials().containsKey(exponent)) {//verific daca exista deja un exponent potrivit
                coeficient += result.getMonomials().get(exponent);//schimb coeficientul , adaug la coeficient coeficientul din primul polinom
            }
            result.addMonomial(exponent, coeficient);
        }
        return result;
    }
    public Polynomial subtract(Polynomial p2) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> entry : this.monomials.entrySet()) {
            result.addMonomial(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<Integer, Double> entry : p2.getMonomials().entrySet()) {
            int exponent = entry.getKey();
            double coeficient = -entry.getValue();//neg coeficientii si ii adun
            if (result.getMonomials().containsKey(exponent)) {
                coeficient += result.getMonomials().get(exponent);
            }
            result.addMonomial(exponent, coeficient);
        }
        return result;
    }
    public Polynomial multiply(Polynomial p2) {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> entry1 : this.monomials.entrySet()) {
            for (Map.Entry<Integer, Double> entry2 : p2.getMonomials().entrySet()) {
                int exponent = entry1.getKey() + entry2.getKey();//exp se aduna
                double coeficient = entry1.getValue() * entry2.getValue();//coef se inmultesc
                if (result.getMonomials().containsKey(exponent)) {//daca exista deja un monom cu acelasi exp  se adauga coeficientul nou la  la acel exp
                    coeficient += result.getMonomials().get(exponent);
                }
                result.addMonomial(exponent, coeficient);
            }
        }
        return result;
    }
    public Polynomial differentiate() {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> entry : this.monomials.entrySet()) {
            int exponent = entry.getKey();
            double coeficient = entry.getValue() * exponent;
            if (exponent > 0) {
                result.addMonomial(exponent - 1, coeficient);
            }
        }
        return result;
    }
    public Polynomial integrate() {
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Double> entry : this.monomials.entrySet()) {
            int exponent = entry.getKey();
            double coeficient = entry.getValue() / (exponent + 1);
            coeficient = Math.round(coeficient * 100.0) / 100.0;//pentru ca rezultatul sa fie 1,67 nu 1,666666
            result.addMonomial(exponent + 1, coeficient);
        }
        return result;
    }

    public static Polynomial parsePolynomial(String input) {
        TreeMap<Integer, Double> monomials = new TreeMap<>();
        String[] regex = input.split("(?=[-+])");
        for (String sir : regex) {
            if (sir.isEmpty()) {
                continue;//daca e gol sa continue
            }
            int exponent = 0;
            double coeficient = 0;
            if (sir.contains("x")) {//daca am intalnit x
                String[] parte = sir.split("x\\^");//despart exp de coef
                if (parte.length > 1) {
                    exponent = Integer.parseInt(parte[1]);
                }
                if (parte[0].isEmpty() || parte[0].equals("+")) {
                    coeficient = 1;//daca ce e inainte de x e + se transforma coef in 1
                } else if (parte[0].equals("-")) {
                    coeficient = -1;//daca e - coef se transforma in -1
                } else {
                    coeficient = Double.parseDouble(parte[0]);//daca nu e + sau - se transforma acel caracter intr-un double
                }
            } else {
                coeficient = Double.parseDouble(sir);//daca nu avem deloc x
            }
            monomials.put(exponent, monomials.getOrDefault(exponent, 0.0) + coeficient);
        }
        return new Polynomial(monomials);
    }
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, Double> entry : monomials.entrySet()) {
            int exponent = entry.getKey();
            double coeficient = entry.getValue();
            if (coeficient == 0) {//in urma scaderii 0x^2
                continue;
            }
            if (result.length() > 0) {//verific daca  exista deja ceva in result
                result.append(coeficient > 0 ? " + " : " - ");//punem semnul potrivit
                coeficient = Math.abs(coeficient);// sa ne asiguram ca vom avea doar un singur semn in output
            }
            if (coeficient != 1 || exponent == 0) {// sa nu avem 1x^
                result.append(coeficient);
            }
            if (exponent > 0) {
                result.append("x");
                if (exponent != 1) {//pentru a nu avea x^1 verific daca exp e dif de 1
                    result.append("^").append(exponent);
                }
            }
        }
        if (result.length() == 0) {
            result.append("0");//daca rezultatul de ex la scadere e 0 se afiseaza 0
        }
        return result.toString();
    }


    }

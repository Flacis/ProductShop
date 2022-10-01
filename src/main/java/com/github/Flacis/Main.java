package com.github.Flacis;

public class Main {
    public static void main(String[] args) {
        Product product = new Product();
        Price price = new Price();
        Bascet bascet = new Bascet();
        new Menu().menuError(product, price, bascet);
    }
}

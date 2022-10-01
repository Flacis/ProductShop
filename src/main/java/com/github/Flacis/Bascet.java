package com.github.Flacis;

import java.util.Arrays;

public class Bascet implements Output, Empty, CalcProduct {

    @Override
    public void output(Product product, Price price) {
        System.out.println("В корзине: ");
        for (int i = 0; i < product.numberOfProducts.length; i++) {
            if (product.numberOfProducts[i] > 0) {
                System.out.printf("%15s %12d %12d %12d %n", product.product[i], product.numberOfProducts[i], price.price[i], (product.numberOfProducts[i] * price.price[i]));
            }
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t\tИтого: " + Arrays.toString(price.finalPrices) + " руб");
    }

    @Override
    public void empty(Product product, Price price) {
        if (price.finalPrices[0] == 0) {
            System.out.println("В корзине пусто!");
        }
    }

    @Override
    public void calcProduct(Product product, Price price, String input) {
        String[] getNumber = input.split(" ");
        int productGetNumber = Integer.parseInt(getNumber[0]) - 1;
        int productGetCoint = Integer.parseInt(getNumber[1]);
        int currentPrice = price.price[productGetNumber];
        int sumProducts = 0;
        product.numberOfProducts[productGetNumber] += productGetCoint;
        price.finalPrices[sumProducts] += productGetCoint * currentPrice;
        int i = price.price[productGetNumber] * productGetCoint;
        product.numberProduct[sumProducts] += i;
    }
}

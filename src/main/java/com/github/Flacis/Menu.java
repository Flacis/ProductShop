package com.github.Flacis;


import java.util.Scanner;

public class Menu implements IMenu {

    @Override
    public void menu(Product product, Price price) {
        System.out.println("Выберите номер продукта и количество");
        for (int i = 0; i < product.product.length; i++) {
            System.out.printf("%-2d %-10s %10d %s", (i + 1), product.product[i], price.price[i], "\n");
        }
    }

    @Override
    public void menuError(Product product, Price price, Bascet bascet){
        while (true) {
            new Menu().menu(product, price);
            String input = new Scanner(System.in).nextLine();
            switch (input) {
                case ("end"):
                    bascet.output(product, price);
                    return;
                case ("show"):
                    bascet.output(product, price);
                    break;
                default:
                    try {
                        bascet.calcProduct(product, price, input);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Введине раздельно номер продукта и количество");

                    } catch (IllegalArgumentException e) {
                        System.out.println("Введены неправильные данные!");
                        System.out.println("Info" + "\n" +
                                "show - введите для того чтобы посмотреть корзину" + "\n" +
                                "end - введите для того чтобы закончить покупку" + "\n");
                    }
            }
        }
    }
}

package org.meucafe;

import org.meucafe.decorators.ChocolateCoverDecorator;
import org.meucafe.decorators.MilkDecorator;
import org.meucafe.factories.ProductFactory;
import org.meucafe.interfaces.Product;

import javax.swing.*;
import java.util.List;

public class Main {
    private List<Order> orders;

    public static void main(String[] args) {
        int option = 0;


        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(null, "Olá Bem vindo(a)! Selecione um produto:\n1 - Café\n2 - Bolo\n0 - Sair"));

            if(option != 0) {
                Product product = getProduct(option);

                if(product != null) {

                    boolean additional = JOptionPane.showConfirmDialog(null, "Deseja colocar algum adicional?") == JOptionPane.YES_OPTION;

                    if(additional) {

                        int additionalOpt =  getAdditional();

                        if(additionalOpt != 0) {
                            switch(additionalOpt) {
                                case 1:
                                    product = new MilkDecorator(product);
                                    break;
                                case 2:
                                    product = new ChocolateCoverDecorator(product);
                                    break;
                            }
                        }

                        JOptionPane.showMessageDialog(null, product.getName() + " R$ " + product.getPrice());
                    }
                }

            }


        }while (option != 0);
    }

    static Product getProduct(int opt) {
        Product product;

        switch (opt) {
            case 1:
                product = ProductFactory.create("coffee");
                break;
            case 2:
                product = ProductFactory.create("cake");
                break;
            default:
                product = ProductFactory.create("");
                break;
        }

        return product;
    }

    static int getAdditional() {
        return Integer.parseInt(JOptionPane.showInputDialog(null, "Qual adicional deseja colocar?\n1 - Leite\n2 - Cobertura de chocolate\n0 - Voltar"));
    }
}
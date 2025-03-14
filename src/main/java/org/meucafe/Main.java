package org.meucafe;

import org.meucafe.constants.MenuOptions;
import org.meucafe.decorators.ChocolateCoverDecorator;
import org.meucafe.decorators.MilkDecorator;
import org.meucafe.factories.ProductFactory;
import org.meucafe.interfaces.Product;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    private Queue<Order> orders = new ArrayDeque<Order>();
    static Order currentOrder = new Order();

    public static void main(String[] args) {
        /*
        * TODO
        *  - List of Orders
        *  - Implement specific additional
        *  - checkout
        *  - queue
        * */
        int productOption = 0;
        int menuOption = 0;

        do {
            menuOption = getMenuOption();

            if(menuOption == MenuOptions.NEW_ORDER) {
                currentOrder.setCustomerName(JOptionPane.showInputDialog(null, "Olá Bem-vindo(a)! Informe o nome do cliente para ser chamado:"));

                productOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione um produto:\n1 - Café\n2 - Bolo\n0 - Sair"));
            }

        }while (menuOption != 0);

        /*do {
            menuOption = getMenuOption();

            if (menuOption == MenuOptions.NEW_ORDER) {
                
            }

            if(currentOrder.getCustomerName() == null){
                currentOrder.setCustomerName(JOptionPane.showInputDialog(null, "Olá Bem-vindo(a)! Informe o nome do cliente para ser chamado:"));
            }

            option = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione um produto:\n1 - Café\n2 - Bolo\n0 - Sair"));

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

                    currentOrder.addProduct(product);
                }

            }

            option = Integer.parseInt(JOptionPane.showInputDialog(null, "Deseja adicionar mais produto?\n1 - Continuar\n0 - Finalizar\nOpção escolhida:"));

        }while (menuOption != 0);

        for (Product product : currentOrder.getProducts()) {
            System.out.println(product.getName() + " R$ " + product.getPrice());
        }
        System.out.println(currentOrder.getTotalPrice());*/
    }

    static int getMenuOption() {
        return Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Novo pedido\n2 - Fila Pedidos\n0 - Sair"));
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
package org.meucafe;

import org.meucafe.constants.MenuOptions;
import org.meucafe.decorators.ChocolateCoverDecorator;
import org.meucafe.decorators.MilkDecorator;
import org.meucafe.facades.OrderInvoiceGenerator;
import org.meucafe.factories.ProductFactory;
import org.meucafe.interfaces.Product;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static Queue<Order> pendingOrders = new ArrayDeque<Order>();
    static Order currentOrder = new Order();

    public static void main(String[] args) {
        /*
        * TODO
        *  - Implement specific additional
        *  - queue
        * */
        int productOption = 0;
        int menuOption = 0;
        int additionalOption = 0;
        boolean hasMoreProduct = false;

        do {
            menuOption = getMenuOption();

            if(menuOption == MenuOptions.NEW_ORDER) {
                currentOrder = new Order();

                do {
                    if (currentOrder.getCustomerName() == null) {
                        currentOrder.setCustomerName(JOptionPane.showInputDialog(null, "Olá Bem-vindo(a)! Informe o nome do cliente para ser chamado:"));
                    }

                    productOption = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione um produto:\n1 - Café\n2 - Bolo\n0 - Voltar/Cancelar Pedido"));

                    if(productOption != 0) {
                        Product product = getProduct(productOption);

                        if (product != null) {
                            if(hasAdditional()) {
                                boolean hasMoreAdditionalOption;

                                do {
                                    additionalOption = getAdditional();

                                    product = putAdditional(product, additionalOption);

                                    hasMoreAdditionalOption = JOptionPane.showConfirmDialog(null, "Deseja colocar mais um adicional?") == JOptionPane.YES_OPTION;
                                }while (hasMoreAdditionalOption);
                            }

                            currentOrder.addProduct(product);
                            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");

                            hasMoreProduct = JOptionPane.showConfirmDialog(null, "Adicionar mais produtos ao pedido?") == JOptionPane.YES_OPTION;
                        }else {
                            JOptionPane.showMessageDialog(null, "Produto selecionado inválido!");
                        }
                    }else {
                        hasMoreProduct = false;
                    }


                }while (hasMoreProduct);

                if(!currentOrder.getProducts().isEmpty()) {
                    JOptionPane.showMessageDialog(null, currentOrder.formattedOutput());
                    OrderInvoiceGenerator.generateInvoice(currentOrder);
                    pendingOrders.add(currentOrder);
                }

            }

        }while (menuOption != 0);
    }

    static int getMenuOption() {
        return Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Novo pedido\n2 - Fila Pedidos\n0 - Sair"));
    }

    static Product getProduct(int opt) {
        Product product = switch (opt) {
            case 1 -> ProductFactory.create("coffee");
            case 2 -> ProductFactory.create("cake");
            default -> ProductFactory.create("");
        };

        return product;
    }

    static boolean hasAdditional() {
        return JOptionPane.showConfirmDialog(null, "Deseja colocar algum adicional?") == JOptionPane.YES_OPTION;
    }

    static int getAdditional() {
        return Integer.parseInt(JOptionPane.showInputDialog(null, "Qual adicional deseja colocar?\n1 - Leite\n2 - Cobertura de chocolate\n0 - Voltar"));
    }

    static Product putAdditional(Product product, int option) {
        if(option == 0) {
            throw new IllegalArgumentException("Adicional inválido!");
        }

        switch(option) {
            case 1:
                product = new MilkDecorator(product);
                break;
            case 2:
                product = new ChocolateCoverDecorator(product);
                break;
        }

        return product;
    }
}
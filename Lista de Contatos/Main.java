package com.lista.contatos;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        int option;
        do{
            System.out.println("Por favor, escolha uma opção");
            System.out.println("\t1. Gerenciar contatos");
            System.out.println("\t2. Gerenciar mensagens");
            System.out.println("\t3. Sair");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> Contact.manageContacts();
                case 2 -> Message.manageMessages();
                case 3 -> System.out.println("Até mais!");
                default -> {
                    System.out.println("Escolha uma opção de 1 a 4");
                }
            }

        }while(option != 3);

    }
}

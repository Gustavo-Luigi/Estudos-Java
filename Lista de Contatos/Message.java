package com.lista.contatos;

import java.util.Scanner;

public class Message {
    private static final Scanner scanner = new Scanner(System.in);

    public static void manageMessages() {
        System.out.println("Por favor, escolha uma opção");
        System.out.println("\t1. Ver mensagens enviadas");
        System.out.println("\t2. Enviar mensagem");
        System.out.println("\t3. Voltar");
        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1 -> showAllMessages();
            case 2 -> sendMessage();
            case 3 -> Main.mainMenu();
            default -> {
                System.out.println("Escolha uma opção de 1 a 3");
                manageMessages();
            }
        }
    }

    private static void showAllMessages() {
        boolean noMessagesSent = true;
        if(Contact.contacts.isEmpty()) {
            System.out.println("Você não possui nenhum contato em sua lista.");
        } else {
            for (Contact c: Contact.contacts) {
                if(!c.getMessages().isEmpty()) {
                    System.out.println("Nome: " + c.getName());
                    noMessagesSent = false;
                    for (int i = 0; i < c.messages.size(); i++){
                        System.out.println("Mensagem nº" + (i + 1) + ":");
                        System.out.println("\t" + c.messages.get(i) + "\n");
                    }
                }
                System.out.println("******************");
            }
            if(noMessagesSent) {
                System.out.println("Você ainda não enviou nenhuma mensagem.");
            }
        }
    }

    public static void sendMessage() {
        if(Contact.contacts.isEmpty()) {
            System.out.println("Você não possui nenhum contato em sua lista.");
        } else {
            System.out.println("Para quem você deseja enviar uma mensagem?");
            String name = scanner.nextLine();
            boolean doesExist = false;

            for(Contact c: Contact.contacts) {
                if(c.getName().equals(name)) {
                    System.out.println("Digite a mensagem a ser enviada:");
                    String mensagem = scanner.nextLine();
                    c.messages.add(mensagem);
                    doesExist = true;
                    System.out.println("Mensagem enviada com sucesso!");
                    break;
                }
            }
            if(!doesExist) {
                System.out.println("Contato não encontrado");
            }
        }
    }
}

package com.lista.contatos;

import java.util.ArrayList;
import java.util.Scanner;

public class Contact {
    private String name;
    private String number;
    private String email;
    public ArrayList<String> messages;
    public static ArrayList<Contact> contacts = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static int option;

    public Contact(String name, String number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.messages = new ArrayList<>();
    }

    public static void manageContacts() {
        System.out.println("Por favor, escolha uma opção");
        System.out.println("\t1. Ver contatos");
        System.out.println("\t2. Adicionar contato");
        System.out.println("\t3. Editar contato");
        System.out.println("\t4. Remover contato");
        System.out.println("\t5. Voltar");
        option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {
            case 1 -> showAllContacts();
            case 2 -> addContact();
            case 3 -> editContact();
            case 4 -> deleteContact();
            case 5 -> Main.mainMenu();
            default -> {
                System.out.println("Escolha uma opção de 1 a 5");
                manageContacts();
            }
        }
    }

    private static void deleteContact() {
        System.out.println("Digite o nome do contato a ser removido:");
        String name = scanner.nextLine();
        boolean doesExist = false;


        for (Contact c: contacts) {
            if(c.getName().equals(name)) {
                doesExist = true;

                System.out.println("Tem certeza que deseja remover " + name + "?");
                System.out.println("\t1. Sim");
                System.out.println("\t2. Não");

                do{
                    option = scanner.nextInt();
                    scanner.nextLine();
                    switch (option) {
                        case 1 -> {
                            contacts.remove(c);
                            System.out.println("Contato removido com sucesso!");
                        }
                        case 2 -> Main.mainMenu();
                        default -> System.out.println("Por favor, escolha \"1\" para \"sim\" ou \"2\" para \"não\"");
                    }
                }while(option != 1 && option != 2);

                break;
            }
        }
        if (!doesExist) {
            System.out.println("Contato não encontrado!");
        }
    }

    public static void addContact() {
        System.out.println("Digite o nome do contato:");
        String name = scanner.nextLine();
        boolean doesExist = false;

        for (Contact c: contacts) {
            if(c.getName().equals(name)) {
                doesExist = true;
                break;
            }
        }

        if(doesExist){
            System.out.println("O contato " + name + " já está cadastrado!");
            manageContacts();
        } else {
            System.out.println("Digite o número do contato:");
            String number = scanner.nextLine();
            System.out.println("Digite o e-mail do contato:");
            String email = scanner.nextLine();

            Contact contact = new Contact(name, number, email);
            contacts.add(contact);
            System.out.println("O contato " + name + " foi adicionado com sucesso!");

        }
    }

    public static void showAllContacts() {
        if(contacts.isEmpty()){
            System.out.println("Você não possui nenhum contato.");
        } else {
            for (Contact c: contacts) {
                System.out.println("Nome: " + c.getName());
                System.out.println("Número: " + c.getNumber());
                System.out.println("E-mail: " + c.getEmail());
                System.out.println("\n*********************\n");
            }
        }
    }

    public static void editContact() {
        System.out.println("Digite o nome do contato que deseja editar.");
        boolean doesExist = false;
        boolean repeatedName = false;
        String name = scanner.nextLine();

        for(Contact c: contacts) {
            if(c.getName().equals(name)) {
                doesExist = true;

                System.out.println("O que deseja alterar?");
                System.out.println("1. Nome");
                System.out.println("2. Número");
                System.out.println("3. E-mail");
                option = scanner.nextInt();
                scanner.nextLine();

                switch(option) {
                    case 1 -> {
                        System.out.println("Digite o novo nome.");
                        name = scanner.nextLine();

                        //Verifica se o novo nome já está em uso
                        for(Contact repeated: contacts) {
                            if(repeated.getName().equals(name)) {
                                System.out.println("Nome já existe, alteração negada.");
                                repeatedName = true;
                            }
                        }
                        //Caso não exista, altera o nome normalmente
                        if(!repeatedName){
                            c.setName(name);
                            System.out.println("Nome alterado com sucesso!");
                        }
                    }

                    case 2 -> {
                        System.out.println("Digite o novo número");
                        String number = scanner.nextLine();
                        c.setNumber(number);
                        System.out.println("Número alterado com sucesso!");
                    }

                    case 3 -> {
                        System.out.println("Digite o novo e-mail");
                        String email = scanner.nextLine();
                        c.setEmail(email);
                        System.out.println("E-mail alterado com sucesso!");
                    }
                }
                break; //Corta o loop a após encontrar o contato e decidir o que ser feito.
            }
            if(!doesExist){
                System.out.println("Contato não encontrado.");
            }
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

}

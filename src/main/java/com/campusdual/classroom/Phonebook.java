package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook extends Contact{

    private static Map<String, Contact> agenda = new HashMap<>();

    public Phonebook(String name, String surname, String phone) {
        super(name, surname, phone);
    }

    public Phonebook() {
        super();
    }

    public Map<String, Contact> getData() {
        return agenda;
    }

    public void deleteContact(String contactCode) {
        agenda.remove(contactCode);
    }

    public void addContact(Contact contact) {
        agenda.put(contact.getCode(), contact);
    }

    public static void loadAgenda() {
        Contact c1 = new Contact("Javier", "López", "664740662");
        Contact c2 = new Contact("Carlos", "Fernández-Simón", "664740663");
        Contact c3 = new Contact("Jose Manuel", "Soria", "664740672");
        Contact c4 = new Contact("Santiago", "Fernández Rocha", "664740664");
        Contact c5 = new Contact("Esteban", "Serrano del Río", "664740673");
        Contact c6 = new Contact("Fernando Miguel", "Juan de los Santos Requejo León", "664740665");
        agenda.put(c1.getCode(),c1);
        agenda.put(c2.getCode(),c2);
        agenda.put(c3.getCode(),c3);
        agenda.put(c4.getCode(),c4);
        agenda.put(c5.getCode(),c5);
        agenda.put(c6.getCode(),c6);

    }

    public static void addAgenda(){
        Contact c3 = new Contact(Utils.string("Introduce el nombre: "),Utils.string("Introduce el apellido: "),Utils.string("Introduce el número de teléfono: "));
        agenda.put(c3.getCode(),c3);
    }

    public static void selectContact(){
        int input;
        String contactCode;
        boolean contactFound = false;
        int exit;
        showPhonebook();


        while (!contactFound) {
            contactCode = Utils.string("Introduce el código del contacto que quieres seleccionar: ");

            if (agenda.containsKey(contactCode)) {
                Contact contact = agenda.get(contactCode);

                System.out.println("===================================");



                System.out.println("1. Llamar \n2. Ver detalles \n3. Eliminar un contacto \n4. Volver al menú principal");

                input = Utils.integer("Selecciona lo que quieres hacer: ");

                switch (input){
                    case 1:
                        contact.callMyNumber();
                        break;
                    case 2:
                        System.out.println("Mostrando información de " + contact.getCode());
                        contact.showContactDetails();
                        break;
                    case 3:
                        agenda.remove(contact.getCode());
                        System.out.println("Eliminando a: " + contact.getName() + " " + contact.getSurnames() + " de la agenda..." );
                        break;
                    case 4:
                        System.out.println("Saliendo al menú principal...");
                        break;

                }

                contactFound = true;
            } else {
                exit = Utils.integer("No es posible encontrar el contacto :(\n1. Intentarlo de nuevo" + "\n2. Salir al menú principal " + "\nSeleccione una opción: ");
                switch (exit){
                    case 1:
                        System.out.println("Inténtelo de nuevo");
                        break;
                    case 2:
                        System.out.println("Volviendo al menú principal...");
                        contactFound = true;

                        break;


                }

            }
        }
    }

    public void displayMenu2() {
        int option;
        do {


            System.out.println("\nMenú del Listín Telefónico:");
            System.out.println("1. Añadir un contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Seleccionar un contacto");
            System.out.println("4. Salir");

            option = Utils.integer("Introduce una opción: ");
            System.out.println("=====================");


            switch (option) {
                case 1:
                    addAgenda();
                    break;
                case 2:
                    showPhonebook();
                    break;
                case 3:
                    selectContact();
                    break;
                default:
                    System.out.println("Saliendo de la aplicación...");


            }
        } while (option != 4);

    }

//    public void displayMenu() {
//        int option = Utils.integer("Introduce una opción: ");
//        System.out.println(option);
//
//        do {
//            System.out.println("\nMenú del Listín Telefónico:");
//            System.out.println("1. Añadir un contacto");
//            System.out.println("2. Mostrar contactos");
//            System.out.println("3. Seleccionar un contacto");
//            System.out.println("4. Eliminar un contacto");
//            System.out.println("5. Salir");
//            System.out.print("Seleccione una opción: ");
//
//            switch (option) {
//                case 1 -> addContact(Utils.string());
//                case 2 -> displayContacts();
//                case 3 -> selectContact(scanner);
//                case 4 -> removeContact(scanner);
//                case 5 -> System.out.println("Saliendo del programa...");
//                default -> System.out.println("Opción no válida, intente de nuevo.");
//            }
//        } while (option != 5);{
//
//        }
//    }

    public static void showPhonebook() {
        for (Map.Entry<String, Contact> entry : agenda.entrySet()) {
            Contact contact = entry.getValue();
            System.out.println("Name: " + contact.getName() +
                    "\nSurname: " + contact.getSurnames() +
                    "\nPhone number: " + contact.getPhone() +
                    "\nCode: " + contact.getCode());
            System.out.println("----------");

        }
    }

    public static List<Contact> searchByName (String name){
        List<Contact> result = new ArrayList<>();

        for (Contact contact : agenda.values()){
            if (contact.getName().equalsIgnoreCase(name)){
                result.add(contact);
            }
        }
        return result;
    }

    public static void showAgendaByCode(String code){
        Contact contact = agenda.get(code);
        if(contact != null){
            System.out.println("Name: " + contact.getName() +
                    "\nSurname: " + contact.getSurnames() +
                    "\nPhone number: " + contact.getPhone() +
                    "\nCode: " + contact.getCode());
        } else {
            System.out.println("No contact found with code: " + code);
        }
    }


}

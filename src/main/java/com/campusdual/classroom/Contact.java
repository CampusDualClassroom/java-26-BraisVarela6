package com.campusdual.classroom;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Contact implements ICallActions{

        private String name;
        private String surname;
        private String phone;
        private String code;
        public final String MY_NUMBER = "664740662";


    public Contact(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.code = genCode();
    }

    public Contact() {

    }

    public static String remove(String texto) {
        String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        Pattern patron = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return patron.matcher(textoNormalizado).replaceAll("").replaceAll("ñ", "n").replaceAll("Ñ", "N");
    }

    public static String omitFirstWord(String input) {
        int spaceIndex = input.indexOf(" ");
        if (spaceIndex == -1) {
            return input;
        }
        return input.substring(spaceIndex + 1);
    }

    public String genCode(){
        char first=Character.toLowerCase(this.getName().charAt(0));
        char second = Character.toLowerCase(this.getSurnames().charAt(0));

        String codigoUnico;
        if (this.surname.split(" ").length == 1){
            codigoUnico = remove(Character.toString(first) + surname.toLowerCase());
        } else {
            codigoUnico = remove(Character.toString(first) + Character.toString(second) + omitFirstWord(surname.toLowerCase()).replaceAll(" ", ""));
        }
        return codigoUnico;
    }





    public String getCode() {
        return code;
    }

    private void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void callOtherNumber(String phone) {
        System.out.println("Estás llamando al número: " + phone + " (Contacto: " + this.name + " " + this.surname + ")");    }

    @Override
    public void callMyNumber() {
        if (MY_NUMBER.equals(this.phone)){
            System.out.println("Se está llamando a usted mismo: " + this.phone + " " + this.name + " " + this.surname);
        } else {
            callOtherNumber(this.phone);
        }
    }



    @Override
    public void showContactDetails() {
        System.out.println("\n==================================" + "\nName: " + getName() +
                "\nSurname: " + getSurnames() +
                "\nPhone number: " + getPhone() + "\nCode: " + getCode() +
                "\n==================================");
    }
}

package com.sda;

public class NIP {

    String inputNip;

    String nip;

    private String convertNIP(String inputNip) {
        return nip = inputNip.replaceAll(" ", "-");
    }


    boolean isNIPValid(String nip) {

        String nipTest = this.nip;
        nipTest = nip.replaceAll("-", "");

        int sum = 0;

        if ((sum % 11) == nipTest.charAt(9)) {

        int weights[] = {6, 5, 7, 2, 3, 4, 5, 6, 7};


        for (int i = 0; i < weights.length; i++) {
            sum += weights[i] * nipTest.charAt(i);
        }

        } else {
            System.out.println("Wrong NIP number.");
        }
        return true;
    }
}

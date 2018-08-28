package com.sda;


import com.sda.exceptions.InvalidNipNumberException;

public class Nip {

    private String nip;
    private final static int weights[] = {6, 5, 7, 2, 3, 4, 5, 6, 7};

    public Nip(final String nip) throws InvalidNipNumberException {
        this.nip = normaliseNIP(nip);
    }

    private String normaliseNIP(String nip) throws InvalidNipNumberException {

        String nipTrim = nip.replaceAll("-", "")
                .replaceAll(" ", "");

        if (!nipTrim.matches("^\\d{10}$"))
            throw new InvalidNipNumberException("Invalid NIP number.");

        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += Integer.valueOf("" + nipTrim.charAt(i)) * weights[i];
        }

        int controlNumber = sum % 11;
        if (controlNumber != Integer.valueOf("" + nipTrim.charAt(9)))
            throw new InvalidNipNumberException("Invalid checksum, invalid NIP number.");

        return nipTrim.replaceAll("^(\\\\d{3})(\\\\d{3})(\\\\d{2})(\\\\d{2})$", "$1-$2-$3-$4");
    }

    public String getNip() {
        return nip;
    }

}

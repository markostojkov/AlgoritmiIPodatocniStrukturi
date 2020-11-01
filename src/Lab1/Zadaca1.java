package Lab1;

import java.util.Arrays;
import java.util.Scanner;

class ZadacaMaraton {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        Atleticar[] atleticari = new Atleticar[n];

        String ime;
        String pol;
        int vozrast;
        double vreme;
        String zemja;

        input.nextLine();

        for(int i=0;i<n;i++)
        {
            ime = input.nextLine();
            pol = input.nextLine();
            vozrast = input.nextInt();
            vreme = input.nextDouble();
            input.nextLine();
            zemja = input.nextLine();
            atleticari[i]=new Atleticar(ime,pol,vozrast,vreme,zemja);
        }

        String mesto;
        int godina;
        String zemjaP;
        mesto = input.nextLine();
        godina = input.nextInt();
        input.nextLine();

        Maraton m1 = new Maraton(mesto, godina, atleticari);
        System.out.print(m1.toString());

        zemjaP = input.nextLine();
        System.out.println("Prvo mesto: " + m1.najdobroVreme().toString());
        System.out.println("Ima vkupno " + m1.atleticariOd(zemjaP) + " atleticar/i od " + zemjaP);
    }
}

class Atleticar {
    private String Ime;
    private String Pol;
    private int Vozrast;
    private double VremeNaIstrcuvanje;
    private String Zemja;

    Atleticar() {}

    Atleticar(String ime, String pol, int vozrast, double vremeNaIstrcuvanje, String zemja) {
        Ime = ime;
        Pol = pol;
        Vozrast = vozrast;
        VremeNaIstrcuvanje = vremeNaIstrcuvanje;
        Zemja = zemja;
    }

    public String getZemja() {
        return Zemja;
    }

    public double getVremeNaIstrcuvanje() {
        return VremeNaIstrcuvanje;
    }

    @Override
    public String toString() {
        return String.format("%s\n%d\n%s\n%.1f\n", Ime, Vozrast, Zemja, VremeNaIstrcuvanje);
    }
}

class Maraton implements IMaraton {
    private String MestoNaOdrzuvanje;
    private int Godina;
    private Atleticar[] Atleticari;

    Maraton() {}

    Maraton(String mestoNaOdrzuvanje, int godina, Atleticar[] atleticari) {
        MestoNaOdrzuvanje = mestoNaOdrzuvanje;
        Godina = godina;
        Atleticari = atleticari;
    }

    public Atleticar najdobroVreme() {
        Atleticar najdobarAtleticar = Atleticari[0];
        double najdobroVremeNaIstrcuvanje = najdobarAtleticar.getVremeNaIstrcuvanje();

        for (Atleticar atleticar : Atleticari) {
            if (najdobroVremeNaIstrcuvanje > atleticar.getVremeNaIstrcuvanje()) {
                najdobarAtleticar = atleticar;
                najdobroVremeNaIstrcuvanje = atleticar.getVremeNaIstrcuvanje();
            }
        }

        return najdobarAtleticar;
    }

    public int atleticariOd(String s) {
        return (int) Arrays.stream(Atleticari).filter(x -> x.getZemja().equals(s)).count();
    }

    @Override
    public String toString() {
        String maratonDescription = String.format("%s\n%d\n", MestoNaOdrzuvanje, Godina);

        for (Atleticar atleticar: Atleticari) {
            maratonDescription += atleticar.toString();
        }

        return maratonDescription;
    }
}

interface IMaraton {
    Atleticar najdobroVreme();

    int atleticariOd(String s);
}

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;


abstract class Patuvanje {
    String ImeNaAgencija;
    int CenaNaPatuvanje;

    Patuvanje(String imeNaAgencija, int cenaNaPatuvanje) {
        ImeNaAgencija = imeNaAgencija;
        CenaNaPatuvanje = cenaNaPatuvanje;
    }

    public int getCenaNaPatuvanje() {
        return CenaNaPatuvanje;
    }

    public static int vratiMinCena(Patuvanje niza[], int n, Patuvanje zaSporedba)
    {
        int min=0, flag=1;

        for(int i=0;i<niza.length;i++)
        {
            if(niza[i].vratiVremeVoDenovi() > zaSporedba.vratiVremeVoDenovi())
            {
                if(flag==1)
                {
                    min = niza[i].getCenaNaPatuvanje();
                    flag=0;
                }
                if(niza[i].getCenaNaPatuvanje() < min)
                {
                    min = niza[i].getCenaNaPatuvanje();
                }

            }

        }
        return min;
    }

    public abstract int vratiVremeVoDenovi();
}

class PraznicnoPatuvanje extends Patuvanje {
    private static final int DenoviVoEdenMesec = 30;
    private int PocetenDen;
    private int PocetenMesec;
    private int ZavrsenDen;
    private int ZavrsenMesec;

    PraznicnoPatuvanje(String ime, int cena, int pocetenDen, int pocetenMesec, int zavrsenDen, int zavrsenMesec) {
        super(ime, cena);
        PocetenDen = pocetenDen;
        PocetenMesec = pocetenMesec;
        ZavrsenDen = zavrsenDen;
        ZavrsenMesec = zavrsenMesec;

        try {
            if (vratiVremeVoDenovi() < 0) {
                throw new Exception("Iskluchok");
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            this.promentPocetnoIZavrsnoVreme();
        }

    }

    public int getPocetenMesec() {
        return PocetenMesec;
    }

    public void pecatiAgencija() {
        System.out.print(ImeNaAgencija + " ");
    }

    @Override
    public int vratiVremeVoDenovi() {
        return ((ZavrsenMesec - PocetenMesec) * DenoviVoEdenMesec) + (ZavrsenDen - PocetenDen);
    }

    private void promentPocetnoIZavrsnoVreme() {
        int tempDen = ZavrsenDen;
        int tempMesec = ZavrsenMesec;

        ZavrsenDen = PocetenDen;
        ZavrsenMesec = PocetenMesec;
        PocetenDen = tempDen;
        PocetenMesec = tempMesec;
    }
}

class GodishenOdmor extends Patuvanje {
    private int VremetraenjeVoDenovi;

    GodishenOdmor(String ime, int cena, int vreme) {
        super(ime, cena);
        VremetraenjeVoDenovi = vreme;
    }

    @Override
    public int vratiVremeVoDenovi() {
        return VremetraenjeVoDenovi;
    }

    @Override
    public int getCenaNaPatuvanje() {
        return CenaNaPatuvanje - 1000;
    }
}


public class Test {

    public static void main(String[] args) {

        int n;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();

        Patuvanje nizaPatuvanje[]=new Patuvanje[n];

        for (int i=0;i<n;i++){
            int tip=in.nextInt();
            if (tip==0){
                String ime=in.next();
                int cena =in.nextInt();
                int vreme=in.nextInt();
                nizaPatuvanje[i]=new GodishenOdmor(ime,cena,vreme);
            }
            else {
                String ime=in.next();
                int cena =in.nextInt();
                int pocD=in.nextInt();
                int pocM=in.nextInt();
                int krajD=in.nextInt();
                int krajM=in.nextInt();
                nizaPatuvanje[i]=new PraznicnoPatuvanje(ime,cena,pocD,pocM, krajD,krajM);
            }
        }

        //решение на барање 1
        for (Patuvanje patuvanje: nizaPatuvanje) {
            if (patuvanje instanceof PraznicnoPatuvanje) {
                if (((PraznicnoPatuvanje) patuvanje).getPocetenMesec() == 6) {
                    ((PraznicnoPatuvanje) patuvanje).pecatiAgencija();
                }
            }
        }
        System.out.println();

        //решение на барање 2
        int sumaVoDenovi = 0;

        for (Patuvanje patuvanje: nizaPatuvanje) {
            sumaVoDenovi += patuvanje.vratiVremeVoDenovi();
        }

        System.out.println(sumaVoDenovi * 1.0 / nizaPatuvanje.length);

        //решение на барање 3
        String agencija = in.next();
        int cena = in.nextInt();
        int vremetraenje = in.nextInt();
        GodishenOdmor odmor = new GodishenOdmor(agencija,cena,vremetraenje);

        //решение на барање 4
        System.out.println(Patuvanje.vratiMinCena(nizaPatuvanje, n ,odmor));
    }

}

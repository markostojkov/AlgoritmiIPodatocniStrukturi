import java.util.*;


class MVR {
    public static void main(String[] args) {
        Scanner br = new Scanner(System.in);
        List<Gragjanin> gragjani = new ArrayList<>();

        int N = Integer.parseInt(br.nextLine());
        for (int i = 1; i <= N; i++) {
            Gragjanin covek = new Gragjanin(
                    br.nextLine(),
                    Integer.parseInt(br.nextLine()),
                    Integer.parseInt(br.nextLine()),
                    Integer.parseInt(br.nextLine()));
            gragjani.add(covek);
        }

        Collections.sort(gragjani);

        for (Gragjanin gragjanin: gragjani) {
            System.out.println(gragjanin.toString());
        }
    }
}

class Gragjanin implements Comparable<Gragjanin> {
    private String imePrezime;
    private int queuePriority;

    public Gragjanin(String imePrezime, int vadiLicnaKarta, int vadiPasos, int vadiVozacka) {
        this.imePrezime = imePrezime;
        this.queuePriority = vadiLicnaKarta *1 + vadiPasos * 2 + vadiVozacka * 5;
    }

    public int getQueuePriority() {
        return this.queuePriority;
    }

    @Override
    public String toString() {
        return this.imePrezime;
    }

    @Override
    public int compareTo(Gragjanin o) {
        return Integer.compare(this.getQueuePriority(), o.getQueuePriority());
    }
}
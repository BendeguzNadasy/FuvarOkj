package fuvar;

public class Fuvar {
    private int taxiId;
    private String indulas;
    private int idotartam;
    private double tav;
    private double viteldij;
    private double borravalo;
    private String fizMod;

    public Fuvar(String sor) {
        String[] s = sor.split(";");
        this.taxiId = Integer.parseInt(s[0]);
        this.indulas = s[1];
        this.idotartam = Integer.parseInt(s[2]);
        this.tav = Double.parseDouble(s[3]);
        this.viteldij = Double.parseDouble(s[4]);
        this.borravalo = Double.parseDouble(s[5]);
        this.fizMod = s[6];
    }

    public int getTaxiId() {
        return taxiId;
    }

    public String getIndulas() {
        return indulas;
    }

    public int getIdotartam() {
        return idotartam;
    }

    public double getTav() {
        return tav;
    }

    public double getViteldij() {
        return viteldij;
    }

    public double getBorravalo() {
        return borravalo;
    }

    public String getFizMod() {
        return fizMod;
    }

    @Override
    public String toString() {
        String adatok = "\tFuvar hossza: " + idotartam + " másodperc\n" +
        "\tTaxi azonosító: " + taxiId + "\n" + 
        "\tMegtett távolság: " + tav + " mérföld\n" +
        "\tViteldíj: " + viteldij + "$" ;
        return adatok;
    }
    
    
    
    
}

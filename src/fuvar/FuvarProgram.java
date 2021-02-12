package fuvar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FuvarProgram {
    public static void main(String[] args) throws IOException {
        List<String> sorok = Files.readAllLines(Paths.get("fuvar.csv"));
        
        ArrayList<Fuvar> fuvarok = new ArrayList<>();
        
        for (int i = 1; i < sorok.size(); i++) {
            fuvarok.add(new Fuvar(sorok.get(i)));
        }
        
        // 3. feladat
        int DB = 0;
        for (int i = 1; i < sorok.size(); i++) {
            DB++;
        }
        System.out.println("3.feladat: " + DB);
        
        // 4. feladat
        int fuvarDb = 0;
        double bevetele = 0;
        for (Fuvar fuvar : fuvarok) {
            if (fuvar.getTaxiId() == 6185) {
                fuvarDb++;
                bevetele += fuvar.getViteldij() + fuvar.getBorravalo();
            }
        }
        System.out.println("4.feladat: " + fuvarDb + " fuvar alatt: " + bevetele + "$");
        
        // 5.feladat
        HashMap<String, Integer> fizmodok = new HashMap<>();
        for (Fuvar fuvar : fuvarok) {
            String fizmod = fuvar.getFizMod();
            if (!fizmodok.containsKey(fizmod)) {
                fizmodok.put(fizmod, 1);
            }
            else {
                int fizDb = fizmodok.get(fizmod);
                fizmodok.put(fizmod, ++fizDb);
            }
        }
        System.out.println("5. feladat:");
        for (Map.Entry<String, Integer> entry : fizmodok.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("\t" + key + ": " + value);
        }
        
        // 6.feladat
        double osszKm = 0;
        for (Fuvar fuvar : fuvarok) {
            osszKm += (fuvar.getTav() * 1.6);
        }
        System.out.printf("6. feladat: %.2f\n", osszKm);
        
        // 7.feladat
        int kerIndex = 0;
        double maxFuvar = 0;
        for (int i = 0; i < fuvarok.size(); i++) {
            if (fuvarok.get(i).getIdotartam() > maxFuvar) {
                kerIndex = i;
                maxFuvar = fuvarok.get(i).getIdotartam();
            }
        }
        
        System.out.println("7 feladat: Leghosszabb fuvar:");
        System.out.println("\tFuvar hossza: " + fuvarok.get(kerIndex).getIdotartam() + " másodperc");
        System.out.println("\tTaxi azonosító: " + fuvarok.get(kerIndex).getTaxiId());
        System.out.println("\tMegtett távolság: " + fuvarok.get(kerIndex).getTav() + " mérföld");
        System.out.println("\tViteldíj: " + fuvarok.get(kerIndex).getViteldij() + "$");
        
    }   
}

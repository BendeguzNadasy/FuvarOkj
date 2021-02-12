package fuvar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
    }   
}

package bazaDanych;

import java.util.ArrayList;

/**
 * Created by Marek on 12.06.2017.
 */
public class BazaHistoria {
    private ArrayList<Historia> historia = new ArrayList<Historia>();
    public int size(){
        return historia.size();
    }
    public Historia getObject(int i){
        return historia.get(i);
    }
    public void add(Historia dane){
        historia.add(dane);
    }
}

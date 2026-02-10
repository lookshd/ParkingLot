package repository;

import exception.NoOperatorFoundException;
import models.Opreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OpreatorRepository {
    private HashMap<Integer, Opreator> opreators;
    private static int id_counter = 1;

    public OpreatorRepository() {
        this.opreators = new HashMap<>();
    }

    public Opreator getOpreatorById(int id) {
        if(opreators.containsKey(id)){
            return opreators.get(id);
        }
        throw new NoOperatorFoundException("No operator found with id: " + id);
    }

    public Opreator saveOpreator(Opreator opreator){
        if (!opreators.containsKey(opreator.getId())) {
            opreator.setId(id_counter++);
        }
        opreators.put(opreator.getId(), opreator);
        return opreator;
    }

    public void delete(int opreatorId) {
        opreators.remove(opreatorId);
    }

    public List<Opreator> getAllOpreators() {
        return new ArrayList<>(opreators.values());
    }
}

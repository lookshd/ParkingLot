package repository;

import exception.NoGateFoundException;
import models.Gate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GateRepository {
    private HashMap<Integer, Gate> gates;
    private static int id_counter = 1;

    public GateRepository() {
        this.gates = new HashMap<>();
    }

    public Gate getGateById(int id) {
        if(gates.containsKey(id)){
            return gates.get(id);
        }
        throw new NoGateFoundException("No gate found with id: " + id);
    }

    public Gate saveGate(Gate gate){
        if (!gates.containsKey(gate.getId())) {
            gate.setId(id_counter++);
        }
        gates.put(gate.getId(), gate);
        return gate;
    }

    public void delete(int gateId) {
        gates.remove(gateId);
    }

    public List<Gate> getAllGates() {
        return new ArrayList<>(gates.values());
    }
}

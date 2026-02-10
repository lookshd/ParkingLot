package repository;

import exception.NoBillFoundException;
import models.Bill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BillRepository {
    private HashMap<Integer, Bill> bills;
    private static int id_counter = 1;

    public BillRepository() {
        this.bills = new HashMap<>();
    }

    public Bill getBillById(int id) {
        if(bills.containsKey(id)){
            return bills.get(id);
        }
         throw new NoBillFoundException("No bill found with id: " + id);
    }

    public Bill saveBill(Bill bill){
        if (!bills.containsKey(bill.getId())) {
            bill.setId(id_counter++);
        }
        bills.put(bill.getId(), bill);
        return bill;
    }

    public void delete(int billId) {
        bills.remove(billId);
    }

    public List<Bill> getAllBills() {
        return new ArrayList<>(bills.values());
    }

}

package models;

import models.constants.BillStatus;
import models.constants.PaymentMode;

import java.time.LocalDateTime;
import java.util.Vector;

public class Bill extends  BaseModel{
    private  Ticket ticket;
    private LocalDateTime exitTime;
    private  double amount;
    private BillStatus billStatus;
    private PaymentMode paymentMode;
    private  String paymentRefrenceNo;

    public Bill(){}
    public Bill(double amount, BillStatus billStatus, LocalDateTime exitTime, PaymentMode paymentMode, String paymentRefrenceNo, Ticket ticket) {
        this.amount = amount;
        this.billStatus = billStatus;
        this.exitTime = exitTime;
        this.paymentMode = paymentMode;
        this.paymentRefrenceNo = paymentRefrenceNo;
        this.ticket = ticket;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentRefrenceNo() {
        return paymentRefrenceNo;
    }

    public void setPaymentRefrenceNo(String paymentRefrenceNo) {
        this.paymentRefrenceNo = paymentRefrenceNo;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}

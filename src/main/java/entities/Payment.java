package entities;

import javax.enterprise.context.RequestScoped;
import java.time.LocalDate;
import java.util.ArrayList;

@RequestScoped
public class Payment {
    int idPayment;
    String clientUsername;
    String sevice;
    int sumOfPayment;
    LocalDate dateOfPayment;

    public Payment(){
    }

    public Payment(int idPayment, String clientName, String sevice, int sumOfPayment, LocalDate dateOfPayment) {
        this.idPayment = idPayment;
        this.clientUsername = clientName;
        this.sevice = sevice;
        this.sumOfPayment = sumOfPayment;
        this.dateOfPayment = dateOfPayment;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public int getSumOfPayment() {
        return sumOfPayment;
    }

    public void setSumOfPayment(int sumOfPayment) {
        this.sumOfPayment = sumOfPayment;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public void setClientUsername(String clientUsername) {
        this.clientUsername = clientUsername;
    }

    public String getSevice() {
        return sevice;
    }

    public void setSevice(String sevice) {
        this.sevice = sevice;
    }

    public LocalDate getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDate dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }
}

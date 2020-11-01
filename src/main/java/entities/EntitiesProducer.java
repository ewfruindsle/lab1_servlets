package entities;

import qualifiers.Payments;
import qualifiers.Services;
import qualifiers.Users;

import javax.enterprise.inject.Produces;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;

public class EntitiesProducer {
    @Produces
    @Users
    public static HashSet<User> getUsers(){
        HashSet<User> users = new HashSet<>();
        users.add(new User(1, "Tom", "tom123", "qwerty"));
        users.add(new User(2, "Alice", "alice_01", "qwerty"));
        users.add(new User(3, "Anastasiia", "admin", "admin"));
        return users;
    }

    @Produces
    @Services
    public ArrayList<Service> getServices(){
        ArrayList<Service> services = new ArrayList<>();
        services.add(new Service(1, "cold water", 13));
        services.add(new Service(2, "hot water", 21));
        services.add(new Service(3, "heating", 35));
        return services;
    }

    @Produces
    @Payments
    public ArrayList<Payment> getPayments(){
        ArrayList<Payment> payments = new ArrayList<>();
        payments.add(new Payment(1,"tom123", "heating", 155, LocalDate.of(2020,9,12)));
        payments.add(new Payment(2,"tom123", "hot water", 239, LocalDate.of(2020,9,15)));
        payments.add(new Payment(3,"alice_01", "cold water", 129, LocalDate.of(2020,10,1)));
        payments.add(new Payment(4,"alice_01", "heating", 571, LocalDate.of(2020,10,2)));
        payments.add(new Payment(5,"alice_01", "heating", 571, LocalDate.of(2020,10,4)));
        return payments;
    }

}

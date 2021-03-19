package com.wwsi.ti.idx8558.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCustomer;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private List<CusOrder> cusOrderList;

    protected Customer() {
    }

    public Customer(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        cusOrderList = new ArrayList<>();
    }

    public void addOrder(CusOrder cusOrder) {
        cusOrderList.add(cusOrder);
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "id_Klienta=" + idCustomer +
                ", imie='" + name + '\'' +
                ", nazwisko='" + surname + '\'' +
                ", numerTelefonu='" + phoneNumber + '\'' +
                ", listaZamowien=" + cusOrderList +
                '}';
    }

    //hashcode, equals -> bussinessKey (imie, nazwisko, numerTelefonu)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return name.equals(customer.name) && surname.equals(customer.surname) && phoneNumber.equals(customer.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, phoneNumber);
    }
}

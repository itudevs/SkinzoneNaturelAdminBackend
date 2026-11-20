package main.java.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="Client")
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int ClientID;
    @Column(unique=false, nullable=false)
    private String ClientName;
    @Column(unique=false, nullable=false)
    private String ClientSurname;
    @Column(unique=true, nullable=false,length = 10)
    private String ClientPhone;

    public int getClientID() {
        return ClientID;
    }



    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public String getClientSurname() {
        return ClientSurname;
    }

    public void setClientSurname(String surname) {
        ClientSurname = surname;
    }

    public String getClientPhone() {
        return ClientPhone;
    }

    public void setClientPhone(String clientPhone) {
        ClientPhone = clientPhone;
    }
}

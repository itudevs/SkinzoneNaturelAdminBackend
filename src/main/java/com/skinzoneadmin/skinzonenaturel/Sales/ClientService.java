package com.skinzoneadmin.skinzonenaturel.Sales;

import com.skinzoneadmin.skinzonenaturel.Dtos.*;
import com.skinzoneadmin.skinzonenaturel.Entities.Client;
import com.skinzoneadmin.skinzonenaturel.Entities.Sale;
import com.skinzoneadmin.skinzonenaturel.Entities.Sale_Line;
import com.skinzoneadmin.skinzonenaturel.Entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private  SaleLineRepository saleLineRepository;
    public void addClient(ClientDto clientDto){
        try{
            Client client = new Client();
            client.setEmail(clientDto.email());
            client.setAddress(clientDto.address());
            client.setName(clientDto.name());
            client.setSurname(clientDto.surname());
            client.setPhone(clientDto.phone());
            clientRepository.save(client);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<LoadClientDto> loadClients(){
        List<Client> clients = clientRepository.findAll();
        List<LoadClientDto> clientDtos = new ArrayList<>();
        if(clients.isEmpty()){
            return null;
        }else{
            for(Client client : clients){
                clientDtos.add(new LoadClientDto(client.getId(),client.getName()+" "+client.getSurname()));

            }
            return clientDtos;
        }
    }
    public List<ClientListDto> loadClientList(){
        List<Client> clients = clientRepository.findAll();
        List<ClientListDto> clientDtos = new ArrayList<>();
        if(clients.isEmpty()){
            return null;
        }else{
            for(Client client : clients){
                clientDtos.add(new ClientListDto(client.getId(),client.getName(),client.getSurname(),
                        client.getEmail(),client.getPhone(),client.getAddress()));

            }
            return clientDtos;
        }
    }
    public List<TransactionDto> loadTransactions(Integer clientId){
         List<Sale> sales =saleRepository.findAllByClient_Id(clientId);
         List<TransactionDto> transactionDtos = new ArrayList<>();
         if(!sales.isEmpty()){
             for(Sale sale : sales){
                 Transaction transaction =sale.getTransaction();
                 //find the sales in sale line
                 List<Sale_Line> saleLines=saleLineRepository.findAllBySale(sale);
                 List<ProductUndetailedDto> productUndetailedDtos=getTransactionProducts(sale);
                 transactionDtos.add(new TransactionDto(transaction.getTransactionDate(),transaction.getTransactionTime(),
                         ))
             }
         }{
             return null;
        }
    }
    private List<ProductUndetailedDto> getTransactionProducts(Integer serviceId){
        return null;
    }
    private List<TreatmentUndetailedDto> getTransactionTreatments(Integer serviceId){
        return null;
    }
}

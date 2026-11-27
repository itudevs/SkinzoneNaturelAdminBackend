package com.skinzoneadmin.skinzonenaturel.Sales;

import com.skinzoneadmin.skinzonenaturel.Dtos.*;
import com.skinzoneadmin.skinzonenaturel.Entities.*;
import com.skinzoneadmin.skinzonenaturel.StockList.StockRepository;
import com.skinzoneadmin.skinzonenaturel.TreatmentList.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private  SaleLineRepository saleLineRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private TreatmentRepository treatmentRepository;
    @Autowired
    private ClientFormRepository clientFormRepository;
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
    public ClientDto LoadClient(Integer id){
        Optional<Client> client = clientRepository.findById(id);
        if(client.isPresent()){
            Client foundClient=client.get();
            return new ClientDto(foundClient.getName(),foundClient.getSurname(), foundClient.getPhone(), foundClient.getEmail(), foundClient.getAddress());
        }
        return null;
    }
    /**
     * Method used to load client list in sale with their name and linked id
     * @return List of the name and surname and associated id
     */
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
                 for(Sale_Line sale_Line:saleLines){
                     List<ProductUndetailedDto> productUndetailedDtos=getTransactionProducts(sale_Line.getService().getServiceID());
                     List<TreatmentUndetailedDto> treatmentUndetailedDtos=getTransactionTreatments(sale_Line.getService().getServiceID());
                     transactionDtos.add(new TransactionDto(transaction.getTransactionDate(),transaction.getTransactionTime(),
                             treatmentUndetailedDtos,productUndetailedDtos));
                 }
             }
         }{
             return null;
        }
    }
    public ClientFormDto getForm(Integer formId){
        Optional<ClientForm> clientForm = clientFormRepository.findById(formId);
        if(clientForm.isPresent()){
            ClientForm foundClientForm = clientForm.get();
            Client client = foundClientForm.getClient();
            ClientDto clientDto=new ClientDto(client.getName(),client.getSurname(),client.getEmail(),client.getPhone(),client.getAddress());
            return new ClientFormDto(foundClientForm.getDate(),foundClientForm.getTodayTreatmentGoal(),foundClientForm.getAnswers(),clientDto);
        }
        return null;
    }
    public List<ClientFormListDto> getForms(Integer clientId){
        List<ClientForm> clientForms=clientFormRepository.findAllByClientId(clientId);
        List<ClientFormListDto> clientFormListDtos = new ArrayList<>();
        if(!clientForms.isEmpty()){
            for(ClientForm clientForm : clientForms){
                clientFormListDtos.add(new ClientFormListDto(clientForm.getId(),clientForm.getDate(),clientForm.getTime()));

            }
            return clientFormListDtos;
        }
        return null;
    }
    private List<ProductUndetailedDto> getTransactionProducts(Integer serviceId){
        List<Product> product=stockRepository.findAllProductByService_ServiceID(serviceId);
        List<ProductUndetailedDto>  productUndetailedDtos = new ArrayList<>();
        if(!product.isEmpty()){
            for(Product foundProduct : product){
                com.skinzoneadmin.skinzonenaturel.Entities.Service service=foundProduct.getService();
                productUndetailedDtos.add(new ProductUndetailedDto(foundProduct.getProductID(),service.getName(),
                        service.getRetailPrice(),foundProduct.getQuantity()));
            }
            return productUndetailedDtos;
        }
        return null;
    }
    private List<TreatmentUndetailedDto> getTransactionTreatments(Integer serviceId){
        List<Treatment> treatment=treatmentRepository.findAllTreatmentByService_ServiceID(serviceId);
        List<TreatmentUndetailedDto>  treatmentUndetailedDtos= new ArrayList<>();
        if(!treatment.isEmpty()){
            for(Treatment foundTreatment : treatment){
                com.skinzoneadmin.skinzonenaturel.Entities.Service service=foundTreatment.getService();
                treatmentUndetailedDtos.add(new TreatmentUndetailedDto(foundTreatment.getId(),service.getName(),
                        service.getRetailPrice()));
            }
            return treatmentUndetailedDtos;
        }
        return null;
    }
}

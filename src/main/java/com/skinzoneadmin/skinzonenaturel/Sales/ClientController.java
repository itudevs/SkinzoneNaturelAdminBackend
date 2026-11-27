package com.skinzoneadmin.skinzonenaturel.Sales;

import com.skinzoneadmin.skinzonenaturel.Dtos.*;
import com.skinzoneadmin.skinzonenaturel.Entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping("/clients")
    public List<ClientListDto> getClients(){
        return  clientService.loadClientList();
    }
    @GetMapping("/client/{clientId}")
        public ClientDto getClient(@PathVariable Integer clientId){
        return clientService.LoadClient(clientId);
    }
    @PostMapping("/add/client")
    public void addClient(@RequestBody ClientDto clientDto){
        clientService.addClient(clientDto);
    }
    @GetMapping("/transactions/{clientId}")
    public List<TransactionDto> getTransactions(@PathVariable Integer clientId){
        return clientService.loadTransactions(clientId);
    }
    @GetMapping("/forms/{clientId}")
    public List<ClientFormListDto> getClientForms(@PathVariable Integer clientId){
        return clientService.getForms(clientId);
    }
    @GetMapping("/form/{formId}")
    public ClientFormDto getClientForm(@PathVariable Integer formId){
        return clientService.getForm(formId);
    }
}

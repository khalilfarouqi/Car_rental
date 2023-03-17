package com.app.rest.controller;

import com.app.dto.ClientDto;
import com.app.rest.api.ClientApi;
import com.app.sevice.impl.ServiceClientImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ClientController implements ClientApi {

    private final ServiceClientImpl clientService;

    @Override
    public List<ClientDto> getAllClient() {
        return clientService.getAllClient();
    }

    @Override
    public ClientDto getClientById(Long id) {
        return clientService.getClientById(id);
    }

    @Override
    public void saveClient(ClientDto clientDto) {
        clientService.saveClient(clientDto);
    }

    @Override
    public void updateClient(ClientDto clientDto) {
        clientService.updateClient(clientDto);
    }

    @Override
    public void deleteClient(Long id) {
        clientService.deleteClient(id);
    }
}

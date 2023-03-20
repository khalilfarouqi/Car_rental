package com.app.rest.controller;

import com.app.dto.ClientDto;
import com.app.entity.Client;
import com.app.rest.api.ClientApi;
import com.app.sevice.IBaseService;
import com.app.sevice.impl.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ClientController extends BaseController<Client, ClientDto> implements ClientApi {

    private final ClientService clientService;

    @Override
    public ClientDto getById(@PathVariable("id") Long id) {
        return clientService.getClientById(id);
    }

    @Override
    public Page<ClientDto> search(String query, Integer page, Integer size, String order, String sort) {
        return clientService.rsqlQuery(query, page, size, order, sort);
    }

    @Override
    public List<ClientDto> getAll() {
        return clientService.getAllClient();
    }

    @Override
    public IBaseService<Client, ClientDto> getService() {
        return clientService;
    }
}

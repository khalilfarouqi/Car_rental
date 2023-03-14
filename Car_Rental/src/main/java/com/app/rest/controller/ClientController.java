package com.app.rest.controller;

import com.app.dto.ClientDto;
import com.app.entity.Client;
import com.app.rest.api.ClientApi;
import com.app.sevice.IBaseService;
import com.app.sevice.impl.ServiceClientImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ClientController extends BaseController<Client, ClientDto> implements ClientApi {

    private final ServiceClientImpl serviceClient;

    @Override
    public IBaseService getService() {
        return serviceClient;
    }
}

package com.app.rest.api;

import com.app.dto.ClientDto;
import com.app.entity.Client;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin
@Tag(name = "Client", description = "REST API for Client information")
@RequestMapping("/v1/client")
public interface ClientApi {

}

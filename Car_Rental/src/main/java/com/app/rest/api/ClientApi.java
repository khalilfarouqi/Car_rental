package com.app.rest.api;

import com.app.dto.ClientDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Tag(name = "Client", description = "REST API for Client information")
@RequestMapping("/v1/client")
public interface ClientApi {
    @GetMapping
    List<ClientDto> getAllClient();

    @GetMapping(value = "/{id}")
    ClientDto getClientById(@PathVariable Long id);

    @PostMapping
    void saveClient(@RequestBody ClientDto clientDto);

    @PutMapping(value = "/updateClient")
    void updateClient(@RequestBody ClientDto clientDto);

    @DeleteMapping(value = "/{id}")
    void deleteClient(@PathVariable Long id);
}

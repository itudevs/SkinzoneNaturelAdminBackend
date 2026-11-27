package com.skinzoneadmin.skinzonenaturel.Sales;

import com.skinzoneadmin.skinzonenaturel.Dtos.ClientFormDto;
import com.skinzoneadmin.skinzonenaturel.Entities.ClientForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientFormRepository extends JpaRepository<ClientForm,Integer> {
    Optional<ClientForm> findByClientId(Integer clientId);

    Optional<ClientForm> findByClientIdAndId(int clientId, int id);
    List<ClientForm> findAllByClientId(int clientId);
}

package com.skinzoneadmin.skinzonenaturel.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skinzoneadmin.skinzonenaturel.Entities.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service,Long> {
    Optional<Service> findServiceByName(String serviceName);

    List<Service> findAllByTypeAndActive(main.java.structures.ServiceType type, boolean active);
}

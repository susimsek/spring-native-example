package io.github.susimsek.springnativeexample.service.impl;

import io.github.susimsek.springnativeexample.exception.RecordNotFoundException;
import io.github.susimsek.springnativeexample.model.Organization;
import io.github.susimsek.springnativeexample.repository.OrganizationRepository;
import io.github.susimsek.springnativeexample.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;


    @Override
    public Organization createOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    @Override
    public Organization getOrganizationById(Long id) {
        return organizationRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Organization %s not found", id)));
    }

    @Override
    public Organization updateOrganization(Long id, Organization organization) {
        Organization stored = organizationRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Organization %s not found", id)));
        stored.setName(organization.getName());
        return organizationRepository.save(stored);
    }

    @Override
    public void deleteOrganizationById(Long id) {
        Organization stored = organizationRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Organization %s not found", id)));
        organizationRepository.delete(stored);
    }
}

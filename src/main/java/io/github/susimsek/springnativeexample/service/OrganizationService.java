package io.github.susimsek.springnativeexample.service;

import io.github.susimsek.springnativeexample.model.Organization;

import java.util.List;

public interface OrganizationService {

    Organization createOrganization(Organization organization);

    List<Organization> getAllOrganizations();

    Organization getOrganizationById(Long id);

    Organization updateOrganization(Long id, Organization organization);

    void deleteOrganizationById(Long id);

}

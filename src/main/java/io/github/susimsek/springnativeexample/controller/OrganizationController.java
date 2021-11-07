package io.github.susimsek.springnativeexample.controller;

import io.github.susimsek.springnativeexample.model.Organization;
import io.github.susimsek.springnativeexample.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "organization", description = "the  Organization API")
@Slf4j
@RequiredArgsConstructor
@RestController
public class OrganizationController {
	
	private final OrganizationService organizationService;


	@Operation(summary = "Create Organization", tags = { "organization" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "successful operation",
					content = {
							@Content(mediaType = "application/json", schema = @Schema(implementation = Organization.class))
					}
			),
			@ApiResponse(responseCode = "400", description = "Invalid Organization supplied", content = @Content)
	})
	@PostMapping(value = "/",
			produces = { "application/json" },
			consumes = { "application/json"})
	public ResponseEntity<Organization> add(@Parameter(description = "Organization to add. Cannot null or empty.", required = true, schema =@Schema(implementation = Organization.class))
											  @Valid @RequestBody Organization organization) {
		log.info("Organization add: {}", organization);
		organization = organizationService.createOrganization(organization);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(organization);
	}

	@Operation(summary = "Find All Organizations", tags = { "organization" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation",
					content = {
							@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Organization.class)))
					}
			)
	})
	@GetMapping(value = "/",
			produces = { "application/json"})
	public ResponseEntity<List<Organization>> findAll() {
		log.info("Organization findAll");
		List<Organization> organizations =  organizationService.getAllOrganizations();
		return ResponseEntity.ok()
				.body(organizations);
	}

	@Operation(summary = "Find Organization by ID", tags = { "organization" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation",
					content = {
							@Content(mediaType = "application/json", schema = @Schema(implementation = Organization.class))
					}
			),
			@ApiResponse(responseCode = "400", description = "Invalid Organization ID supplied",content = @Content),
			@ApiResponse(responseCode = "404", description = "Organization not found", content = @Content)
	})
	@GetMapping(value = "/{id}", produces = { "application/json"})
	public ResponseEntity<Organization> findById(@Parameter(description = "Id of the organization to be obtained. Cannot be empty.", required = true) @PathVariable("id") Long id) {
		log.info("Organization find: id={}", id);
		Organization organization = organizationService.getOrganizationById(id);
		return ResponseEntity.ok()
				.body(organization);
	}

	@Operation(summary = "Update Organization", tags = { "organization" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation",
					content = {
							@Content(mediaType = "application/json", schema = @Schema(implementation = Organization.class))
					}
			),
			@ApiResponse(responseCode = "400", description = "Invalid Organization supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Organization not found", content = @Content)
	})
	@PutMapping(value = "/{id}",
			produces = { "application/json" },
			consumes = { "application/json"})
	public ResponseEntity<Organization> add(@Parameter(description = "Id of the organization to be obtained. Cannot be empty.", required = true) @PathVariable("id") Long id,
											@Parameter(description = "Organization to update. Cannot null or empty.", required = true, schema = @Schema(implementation = Organization.class))
											@Valid @RequestBody Organization organization) {
		log.info("Organization update: id={}", id);
		organization = organizationService.updateOrganization(id, organization);
		return ResponseEntity.ok(organization);
	}

	@Operation(summary = "Delete Organization by ID", tags = { "organization" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "successful operation", content = @Content),
			@ApiResponse(responseCode = "400", description = "Invalid Organization ID supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Organization not found", content = @Content)
	})
	@DeleteMapping(value = "/{id}", produces = { "application/json"})
	public ResponseEntity<Organization> deleteById(@Parameter(description = "Id of the organization to be obtained. Cannot be empty.", required = true) @PathVariable("id") Long id) {
		log.info("Organization delete: id={}", id);
		organizationService.deleteOrganizationById(id);
		return ResponseEntity.noContent()
				.build();
	}
	
}

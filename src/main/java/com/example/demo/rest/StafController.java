package com.example.demo.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.StafEntity;
import com.example.demo.exception.DataNotFoundExceptio;
import com.example.demo.service.StafService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Staf")
@RequestMapping("api/Staf")
@RestController
@RequiredArgsConstructor
public class StafController {

	private final StafService service;

	@Operation(description = "Get end points for Staf", summary = "This end point used to create staf", responses = {
			@ApiResponse(description = "Success", responseCode = "200"),
			@ApiResponse(description = "UnAuthorized / Invalid Token", responseCode = "403") })

	 @PostMapping("/staf")
    public ResponseEntity<String> createStaf(@RequestBody  @Valid StafEntity stafEntity,@RequestParam Integer id) {
        StafEntity savedStaf = service.create(stafEntity, id);
		return ResponseEntity.ok("Staf saved with ID: " + savedStaf.getStafId());
	}

	@Operation(description = "Get end points for Staf", summary = "This end point used to fetch staf", responses = {
			@ApiResponse(description = "Success", responseCode = "200"),
			@ApiResponse(description = "UnAuthorized / Invalid Token", responseCode = "403") })
	@GetMapping("/fetch")
	public ResponseEntity<List<StafEntity>> getAll() {
		List<StafEntity> fetch = service.fetch();
		if (fetch.isEmpty()) {
			throw new DataNotFoundExceptio("Data Not found",LocalDate.now());
		} else {
			return ResponseEntity.ok(fetch);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StafEntity> getById(@PathVariable Integer id){
		  StafEntity entity = service.getById(id);
		  return ResponseEntity.ok(entity);
	}
	
	@Operation(description = "Get end points for Staf", summary = "This end point used to create staf", responses = {
			@ApiResponse(description = "Success", responseCode = "200"),
			@ApiResponse(description = "UnAuthorized / Invalid Token", responseCode = "403") })

	 @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody  @Valid StafEntity stafEntity, Integer id) {
        StafEntity savedStaf = service.updateId(id, stafEntity);
		return ResponseEntity.ok("Staf saved with ID: " + savedStaf.getStafId());
	}
	
	
	@Operation(description = "Get end points for Staf", summary = "This end point used to create staf", responses = {
			@ApiResponse(description = "Success", responseCode = "200"),
			@ApiResponse(description = "UnAuthorized / Invalid Token", responseCode = "403") })

	 @DeleteMapping("/delete")
    public ResponseEntity<String> Delete( Integer id) {
         String deleteById = service.deleteById(id);
		return ResponseEntity.ok("Deleted ID: ");
	}
}

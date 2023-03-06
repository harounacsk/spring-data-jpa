package de.controller;

import de.configuration.Message;
import de.model.Distributor;
import de.repository.DistributorRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/distributor")
public class DistributorController {
  private DistributorRepository distributorRepository;
  private Message message;

  public DistributorController(DistributorRepository distributorRepository, Message message) {
    this.distributorRepository = distributorRepository;
    this.message = message;
  }

  @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
  public String save(@RequestBody Distributor distributor) {
    this.distributorRepository.save(distributor);
    return this.message.success();
  }

  @GetMapping("/{id}")
  public Distributor getDistributorById(@PathVariable("id") Long id) {
    Optional<Distributor> distributor = this.distributorRepository.findById(id);
    return distributor.get();
  }

  @GetMapping(value = "/all")
  public List<Distributor> getAll() {
    return this.distributorRepository.findAll();
  }

  @GetMapping("/name/{name}")
  public Distributor getDistributorByName(@PathVariable("name") String name) {
    return this.distributorRepository.findByName(name).get();
  }
}

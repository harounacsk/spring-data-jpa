package de.controller;

import de.configuration.Message;
import de.model.Depot;
import de.repository.DepotRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/depot")
public class DepotController {
  private DepotRepository depotRepository;
  private Message message;

  public DepotController(DepotRepository depotRepository, Message message) {
    this.depotRepository = depotRepository;
    this.message = message;
  }

  @PostMapping(value = "/add")
  public String save(@RequestBody Depot depot) {
    this.depotRepository.save(depot);
    return this.message.success();
  }
  @PutMapping(value = "/update")
  public ResponseEntity<String> update(@RequestBody Depot depot) {
    Depot dpt=this.depotRepository.findById(depot.getId()).get();
    if(dpt != null){
      dpt.setName(depot.getName());
      this.depotRepository.save(dpt);
      return new ResponseEntity<>(this.message.success(), HttpStatus.OK);
    }
    return new ResponseEntity<>(this.message.error(), HttpStatus.BAD_REQUEST);
  }

  @GetMapping("/{id}")
  public Depot getDepotById(@PathVariable("id") Long id) {
    Optional<Depot> depot = this.depotRepository.findById(id);
    return depot.get();
  }

  @GetMapping(value = "/all")
  public List<Depot> getAll() {
    return this.depotRepository.findAll();
  }
}

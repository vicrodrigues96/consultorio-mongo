package br.com.meli.crudmongo.controllers;

import br.com.meli.crudmongo.dtos.TurnRequestDto;
import br.com.meli.crudmongo.entities.Turn;
import br.com.meli.crudmongo.services.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultorio/turns")
public class TurnController {

    private TurnService turnService;

    @Autowired
    public TurnController(TurnService turnService) {
        this.turnService = turnService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void persist(@RequestBody TurnRequestDto turnDto) throws Exception {
        this.turnService.persist(turnDto);
    }

    @GetMapping()
    public List<Turn> listAllTurns() {
        return this.turnService.listTurns();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTurnByid(@PathVariable String id) {
        this.turnService.deleteTurnById(id);
    }

    @GetMapping("/dentist")
    public List<Turn> listAllTurnsByDentist(@RequestParam String name) {
        return this.turnService.listTurnsByDentist(name);
    }

    @GetMapping("/status/{status}")
    public List<Turn> listAllTurnsByStatus(@PathVariable String status) {
        return this.turnService.listTurnsByStatus(status);
    }
}

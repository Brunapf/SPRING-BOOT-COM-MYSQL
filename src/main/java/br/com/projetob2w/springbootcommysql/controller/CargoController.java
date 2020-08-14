package br.com.projetob2w.springbootcommysql.controller;

import org.springframework.web.bind.annotation.*;

import br.com.projetob2w.springbootcommysql.controller.dto.CargoRq;
import br.com.projetob2w.springbootcommysql.controller.dto.CargoRs;
import br.com.projetob2w.springbootcommysql.model.Cargo;
import br.com.projetob2w.springbootcommysql.model.Trilha;
import br.com.projetob2w.springbootcommysql.repository.CargoCustomRepository;
import br.com.projetob2w.springbootcommysql.repository.CargoRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    private final CargoRepository cargoRepository;
    private final CargoCustomRepository cargoCustomRepository;

    public CargoController(CargoRepository cargoRepository, CargoCustomRepository cargoCustomRepository) {
        this.cargoRepository = cargoRepository;
        this.cargoCustomRepository = cargoCustomRepository;
    }

    @GetMapping("/")
    public List<CargoRs> findAll() {
        var cargos = cargoRepository.findAll();
        return cargos
                .stream()
                .map(CargoRs::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CargoRs findById(@PathVariable("id") Long id) {
        var cargo = cargoRepository.getOne(id);
        return CargoRs.converter(cargo);
    }

    @PostMapping("/")
    public void savePerson(@RequestBody CargoRq cargo) {
        var c = new Cargo();
        c.setCargoNome(cargo.getCargoNome());
        c.setTrilhaId(cargo.getTrilhaId());
        cargoRepository.save(c);
    }

    @PutMapping("/{id}")
    public void updatePerson(@PathVariable("id") Long id, @RequestBody CargoRq cargo) throws Exception {
        var c = cargoRepository.findById(id);

        if (c.isPresent()) {
            var cargoSave = c.get();
            cargoSave.setCargoNome(cargo.getCargoNome());
            cargoSave.setTrilhaId(cargo.getTrilhaId());
            cargoRepository.save(cargoSave);
        } else {
            throw new Exception("Cargo Não encontrada");
        }
    }

    @GetMapping("/filter")
    public List<CargoRs> findPersonByName(@RequestParam("nome") String nome) {
        return this.cargoRepository.findByNomeContains(nome)
                .stream()
                .map(CargoRs::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/filter/custom")
    public List<CargoRs> findPersonByCustom(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "cargo_nome", required = false) String cargo_nome,
            @RequestParam(value = "trilha_id", required = false) Trilha trilha_id
    ) {
        return this.cargoCustomRepository.find(id, cargo_nome, trilha_id)
                .stream()
                .map(CargoRs::converter)
                .collect(Collectors.toList());
    }

}

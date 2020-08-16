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
        Cargo cargo = cargoRepository.getOne(id);
        return CargoRs.converter(cargo);
    }

    @PostMapping("/")
    public void saveCargo(@RequestBody CargoRq cargo) {
        Cargo c = new Cargo(cargo.getCargoNome(),cargo.getTrilha());
        c.setCargoNome(cargo.getCargoNome());
        c.setTrilha(cargo.getTrilha());
        cargoRepository.save(c);
    }

    @PutMapping("/{id}")
    public void updateCargo(@PathVariable("id") Long id, @RequestBody CargoRq cargo) throws Exception {
        var c = cargoRepository.findById(id);

        if (c.isPresent()) {
            var cargoSave = c.get();
            cargoSave.setCargoNome(cargo.getCargoNome());
            cargoSave.setTrilha(cargo.getTrilha());
            cargoRepository.save(cargoSave);
        } else {
            throw new Exception("Cargo não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCargo(@PathVariable("id") Cargo id){
        cargoRepository.delete(id);
    }

    @GetMapping("/filter")
    public List<CargoRs> findPersonByName(@RequestParam("name") String name) {
        return this.cargoRepository.findByCargoNomeContains(name)
                .stream()
                .map(CargoRs::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/filter/custom")
    public List<CargoRs> findPersonByCustom(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "cargoNome", required = false) String cargoNome,
            @RequestParam(value = "trilhaId", required = false) Trilha trilhaId
    ) {
        return this.cargoCustomRepository.find(id, cargoNome, trilhaId)
                .stream()
                .map(CargoRs::converter)
                .collect(Collectors.toList());
    }

}

package br.com.projetob2w.springbootcommysql.controller;

import org.springframework.web.bind.annotation.*;

import br.com.projetob2w.springbootcommysql.controller.dto.TrilhaRq;
import br.com.projetob2w.springbootcommysql.controller.dto.TrilhaRs;
import br.com.projetob2w.springbootcommysql.model.Trilha;
import br.com.projetob2w.springbootcommysql.repository.TrilhaCustomRepository;
import br.com.projetob2w.springbootcommysql.repository.TrilhaRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trilha")
public class TrilhaController {

    private final TrilhaRepository trilhaRepository;
    private final TrilhaCustomRepository trilhaCustomRepository;

    public TrilhaController(TrilhaRepository trilhaRepository, TrilhaCustomRepository trilhaCustomRepository) {
        this.trilhaRepository = trilhaRepository;
        this.trilhaCustomRepository = trilhaCustomRepository;
    }

    @GetMapping("/")
    public List<TrilhaRs> findAll() {
        var trilhas = trilhaRepository.findAll();
        return trilhas
                .stream()
                .map(TrilhaRs::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TrilhaRs findById(@PathVariable("id") Long id) {
        var trilha = trilhaRepository.getOne(id);
        return TrilhaRs.converter(trilha);
    }

    @PostMapping("/")
    public void savePerson(@RequestBody TrilhaRq trilha) {
        var p = new Trilha();
        p.setTrilhaNome(trilha.getTrilhaNome());
        p.setDiretoria(trilha.getDiretoria());
        trilhaRepository.save(p);
    }

    @PutMapping("/{id}")
    public void updatePerson(@PathVariable("id") Long id, @RequestBody TrilhaRq trilha) throws Exception {
        var p = trilhaRepository.findById(id);

        if (p.isPresent()) {
            var trilhaSave = p.get();
            trilhaSave.setTrilhaNome(trilha.getTrilhaNome());
            trilhaSave.setDiretoria(trilha.getDiretoria());
            trilhaRepository.save(trilhaSave);
        } else {
            throw new Exception("Trilha Não encontrada");
        }
    }

    @GetMapping("/filter")
    public List<TrilhaRs> findPersonByName(@RequestParam("name") String name) {
        return this.trilhaRepository.findByNomeContains(name)
                .stream()
                .map(TrilhaRs::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/filter/custom")
    public List<TrilhaRs> findPersonByCustom(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "trilha_nome", required = false) String trilha_nome,
            @RequestParam(value = "diretoria", required = false) String diretoria
    ) {
        return this.trilhaCustomRepository.find(id, trilha_nome, diretoria)
                .stream()
                .map(TrilhaRs::converter)
                .collect(Collectors.toList());
    }

}

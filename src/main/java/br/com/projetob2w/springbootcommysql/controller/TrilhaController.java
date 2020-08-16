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
        Trilha trilha = trilhaRepository.getOne(id);
        return TrilhaRs.converter(trilha);
    }

    @PostMapping("/")
    public void saveTrilha(@RequestBody TrilhaRq trilha) {
        Trilha t = new Trilha(trilha.getTrilhaNome(),trilha.getDiretoria());
        t.setTrilhaNome(trilha.getTrilhaNome());
        t.setDiretoria(trilha.getDiretoria());
        trilhaRepository.save(t);
    }

    @PutMapping("/{id}")
    public void updateTrilha(@PathVariable("id") Long id, @RequestBody TrilhaRq trilha) throws Exception {
        var t = trilhaRepository.findById(id);

        if (t.isPresent()) {
            var trilhaSave = t.get();
            trilhaSave.setTrilhaNome(trilha.getTrilhaNome());
            trilhaSave.setDiretoria(trilha.getDiretoria());
            trilhaRepository.save(trilhaSave);
        } else {
            throw new Exception("Trilha não encontrada");
        }
    }

    @GetMapping("/filter")
    public List<TrilhaRs> findPersonByName(@RequestParam("name") String name) {
        return this.trilhaRepository.findByTrilhaNomeContains(name)
                .stream()
                .map(TrilhaRs::converter)
                .collect(Collectors.toList());
    }

    @GetMapping("/filter/custom")
    public List<TrilhaRs> findPersonByCustom(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "trilhaNome", required = false) String trilhaNome,
            @RequestParam(value = "diretoria", required = false) String diretoria
    ) {
        return this.trilhaCustomRepository.find(id, trilhaNome, diretoria)
                .stream()
                .map(TrilhaRs::converter)
                .collect(Collectors.toList());
    }

}

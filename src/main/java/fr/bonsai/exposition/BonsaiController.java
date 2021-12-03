package fr.bonsai.exposition;

import fr.bonsai.BonsaiMapper;
import fr.bonsai.domain.BonsaiService;
import fr.bonsai.domain.model.Bonsai;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bonsais")
public class BonsaiController {


    private final BonsaiService bonsaiService;


    public BonsaiController(BonsaiService bonsaiService) {
        this.bonsaiService = (BonsaiService) bonsaiService;
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> findById(@PathVariable("uuid") UUID uuid) {
        try {
            BonsaiDTO bonsaiDTO = BonsaiMapper.BonsaiToDto(bonsaiService.findById(uuid));
            return ResponseEntity.ok(bonsaiDTO);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping
    public List<BonsaiDTO> findAll() {
        List<Bonsai> bonsais = bonsaiService.findAll();
        List<BonsaiDTO> dto = new ArrayList<>();

        for (int i = 0; i < bonsais.size(); i++) {
            Bonsai bonsai = bonsais.get(i);
            BonsaiDTO bonsaiDTO = BonsaiMapper.BonsaiToDto(bonsai);
            dto.add(bonsaiDTO);
        }
        return dto;

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        bonsaiService.delete(id);
    }

    @PostMapping
    public ResponseEntity<BonsaiDTO> create(@RequestBody fr.bonsai.infrastructure.common.BonsaiEntity bonsai) {

        Bonsai bonsaiTemp = bonsaiService.create(bonsai);

        BonsaiDTO resultat = BonsaiMapper.BonsaiToDto(bonsaiTemp);

        return ResponseEntity.created(null).body(resultat);

    }

    @PatchMapping("/{id}")
    public ResponseEntity<BonsaiDTO> update(@PathVariable UUID id, @RequestBody BonsaiDTO updatedBonsai) {
        return bonsaiService.update(id, BonsaiMapper.DtoToBonsai(updatedBonsai)).map(bonsai -> ResponseEntity.ok(BonsaiMapper.BonsaiToDto(bonsai))).orElse(ResponseEntity.notFound().build());
    }
}
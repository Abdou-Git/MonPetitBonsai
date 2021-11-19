package fr.bonsai.exposition;

import fr.bonsai.BonsaiMapper;
import fr.bonsai.domain.BonsaiService;
import fr.bonsai.infrastructure.BonsaiDao;
import fr.bonsai.infrastructure.BonsaiEntity;
import fr.bonsai.infrastructure.BonsaiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bonsais")
public class BonsaiController {


    private final BonsaiService bonsaiService;


    public BonsaiController(BonsaiService bonsaiService){
        this.bonsaiService = (BonsaiService) bonsaiService;
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<BonsaiDTO> findById(@PathVariable("uuid") UUID uuid){
        try{
            BonsaiDTO bonsaiDTO = BonsaiMapper.BonsaiToDto(bonsaiService.findById(uuid));
            return ResponseEntity.ok(bonsaiDTO);
        }catch(Exception e) {
            return ResponseEntity.notFound().build();
        }


    }

    @PostMapping
    public BonsaiEntity create (@RequestBody BonsaiEntity bonsai){
        return (ResponseEntity<BonsaiDTO>) bonsaiService.create(bonsai);
    }

}

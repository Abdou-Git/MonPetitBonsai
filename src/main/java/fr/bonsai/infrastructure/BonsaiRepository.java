package fr.bonsai.infrastructure;

import fr.bonsai.BonsaiMapper;
import fr.bonsai.domain.model.Bonsai;
import fr.bonsai.infrastructure.common.BonsaiDao;
import fr.bonsai.infrastructure.common.BonsaiEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Component
public class BonsaiRepository {

    private final BonsaiDao bonsaiDao;

    public BonsaiRepository(BonsaiDao bonsaiDao){
        this.bonsaiDao = bonsaiDao;
    }


    public List<Bonsai> findAll() {
        List<BonsaiEntity> res = bonsaiDao.findAll();
        List<Bonsai> collect = res.stream()
                .map(bonsaiEntity -> BonsaiMapper.EntityToBonsai(bonsaiEntity))
                .collect(Collectors.toList());

        return collect;
    }

    @GetMapping("/{uuid}")
    public Bonsai findById(@PathVariable("uuid") UUID uuid ) {
        Optional<fr.bonsai.infrastructure.common.BonsaiEntity> res = bonsaiDao.findById(uuid);
        if(res.isPresent()){
            Bonsai resultat = BonsaiMapper.EntityToBonsai(res.get());
            return resultat;
        }else{
            return null;
        }
    }

    @DeleteMapping
    public void delete(UUID id) {
        bonsaiDao.deleteById(id);

    }

    @PostMapping
    public Bonsai create (@RequestBody fr.bonsai.infrastructure.common.BonsaiEntity bonsai){
        fr.bonsai.infrastructure.common.BonsaiEntity res = bonsaiDao.save(bonsai);
        Bonsai resultat = BonsaiMapper.EntityToBonsai(res);
        return resultat;
    }

    @PatchMapping
    public Bonsai update(Bonsai bonsai) {
        return BonsaiMapper.EntityToBonsai(bonsaiDao.save(BonsaiMapper.BonsaiToEntity(bonsai)));

    }


}
package fr.bonsai;

import fr.bonsai.domain.model.Bonsai;
import fr.bonsai.exposition.BonsaiDTO;

import java.util.List;

public class BonsaiMapper {


    public static Bonsai DtoToBonsai(BonsaiDTO bonsaiDTO){

        Bonsai bonsaiConverted = new Bonsai();
        bonsaiConverted.setId(bonsaiDTO.getId());
        bonsaiConverted.setName(bonsaiDTO.getName());

        return bonsaiConverted;
    }

    public static fr.bonsai.infrastructure.common.BonsaiEntity BonsaiToEntity(Bonsai bonsai){

        fr.bonsai.infrastructure.common.BonsaiEntity bonsaiConverted = new fr.bonsai.infrastructure.common.BonsaiEntity();
        bonsaiConverted.setId(bonsai.getId());
        bonsaiConverted.setName(bonsai.getName());

        return bonsaiConverted;
    }

    public static Bonsai EntityToBonsai(fr.bonsai.infrastructure.common.BonsaiEntity bonsaiEntity){

        Bonsai bonsaiConverted = new Bonsai();
        bonsaiConverted.setId(bonsaiEntity.getId());
        bonsaiConverted.setName(bonsaiEntity.getName());

        return bonsaiConverted;
    }



    public static BonsaiDTO BonsaiToDto(Bonsai bonsai){

        BonsaiDTO bonsaiConverted = new BonsaiDTO();
        bonsaiConverted.setId(bonsai.getId());
        bonsaiConverted.setName(bonsai.getName());

        return bonsaiConverted;
    }



}

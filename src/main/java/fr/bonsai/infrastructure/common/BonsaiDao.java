package fr.bonsai.infrastructure.common;

import fr.bonsai.infrastructure.common.BonsaiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BonsaiDao extends JpaRepository<BonsaiEntity, UUID> {
}

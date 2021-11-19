package fr.bonsai.infrastructure;

import fr.bonsai.infrastructure.BonsaiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BonsaiDao extends JpaRepository<BonsaiEntity, UUID> {
}

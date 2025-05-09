package parkingslot.parkingslot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepositoy
		extends JpaRepository<VehicleEntity, Integer>, JpaSpecificationExecutor<VehicleEntity> {
}

package parkingslot.parkingslot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSlotRepository extends JpaRepository<ParkingSlotEntity, Integer>, JpaSpecificationExecutor<ParkingSlotEntity> {
}

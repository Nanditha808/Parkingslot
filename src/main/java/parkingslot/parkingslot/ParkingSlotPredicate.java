package parkingslot.parkingslot;

import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ParkingSlotPredicate {
	public static Specification<ParkingSlotEntity> createPredicate(ParkingSlotSearchBean searchBean) {
		return (Root<ParkingSlotEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
			Predicate predicate = cb.conjunction();

			if (searchBean.getIsOccupied() != null) {
				predicate = cb.and(predicate, cb.equal(root.get("isOccupied"), searchBean.getIsOccupied()));
			}
			if (searchBean.getVehicleType() != null) {
				predicate = cb.and(predicate,
						cb.equal(root.join("parkedVehicle").get("type"), searchBean.getVehicleType()));
			}

			return predicate;
		};
	}
}

package parkingslot.parkingslot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSlotSearchBean {
	private Boolean isOccupied;

	private String vehicleType;

}

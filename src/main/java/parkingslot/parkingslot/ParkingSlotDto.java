package parkingslot.parkingslot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ParkingSlotDto {

	private Integer slotNum;

	private boolean isOccupied;

	private VehicleDto vehicleId;

	private Long entryTime;

}

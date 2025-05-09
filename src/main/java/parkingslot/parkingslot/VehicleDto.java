package parkingslot.parkingslot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VehicleDto {
	private Integer id;

	private String numberPlate;

	private String typeOfVehicle;

}

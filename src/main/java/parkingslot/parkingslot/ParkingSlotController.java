package parkingslot.parkingslot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parking")
public class ParkingSlotController {

	@Autowired
	private ParkingSlotServiceImpl parkingSlotServiceImpl;

	@PostMapping("/park")
	public String parkedVehicle(@RequestBody VehicleDto vehicleDto) {
		return parkingSlotServiceImpl.parkedVehicle(vehicleDto);
	}

	@PostMapping("/leave/{slotNumber}")
	public String leaveVehicle(@PathVariable("slotNumber") Integer slotNumber) {
		return parkingSlotServiceImpl.leaveVehicle(slotNumber);
	}
}
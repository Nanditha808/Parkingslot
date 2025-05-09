package parkingslot.parkingslot;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParkingSlotServiceImpl {
	@Autowired
	private ParkingSlotRepository parkingSlotRepository;

	@Autowired
	private VehicleRepositoy vehicleRepositoy;

	@Transactional
	public String parkedVehicle(VehicleDto vehicleDto) {
		Optional<ParkingSlotEntity> availaveSlot = parkingSlotRepository.findAll().stream()
				.filter(slot -> !slot.isOccupied()).findFirst();

		if (availaveSlot.isPresent()) {
			ParkingSlotEntity parkingSlotEntity = availaveSlot.get();
			VehicleEntity vehicle = new VehicleEntity();
			vehicle.setNumberPlate(vehicleDto.getNumberPlate());
			vehicle.setTypeOfVehicle(vehicleDto.getTypeOfVehicle());
			vehicle = vehicleRepositoy.save(vehicle);
			parkingSlotEntity.setOccupied(true);
			parkingSlotEntity.setEntryTime(new Timestamp(System.currentTimeMillis()));
			parkingSlotEntity.setVehicleId(vehicle);
			parkingSlotRepository.save(parkingSlotEntity);

			return "Vehicle parked in slot " + parkingSlotEntity.getSlotNum();
		}
		return "No available slot";
	}

	public String leaveVehicle(Integer slotNumber) {
		Optional<ParkingSlotEntity> slot = parkingSlotRepository.findById(slotNumber);
		if (slot.isPresent())
			if (slot.get().isOccupied()) {
				ParkingSlotEntity slotOpt = slot.get();
				Long duration = System.currentTimeMillis() - slotOpt.getEntryTime().getTime();
				slotOpt.setOccupied(false);
				slotOpt.setVehicleId(null);
				slotOpt.setEntryTime(null);
				parkingSlotRepository.save(slotOpt);
				return "vehicle left" + +slotNumber + "duration" + +(duration / 1000) + "sec";
			} else {
				return "slot is free" + " "+slotNumber;
			}

		return "invalid slotnum";
	}
}

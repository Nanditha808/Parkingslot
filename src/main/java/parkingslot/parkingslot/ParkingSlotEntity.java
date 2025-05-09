package parkingslot.parkingslot;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="parking_slot",schema="public")
public class ParkingSlotEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="slot_num",unique = true,nullable = false)
	private Integer slotNum;
	
	@Column(name="is_occuppied",nullable = false)
	private boolean isOccupied;
	
	@OneToOne
	@JoinColumn(name="vehicle_id",nullable = true,referencedColumnName = "id")
	private VehicleEntity vehicleId;
	
	@Column(name="entry_time",nullable = true)
	private Timestamp entryTime;

}

package parkingslot.parkingslot;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="vehicles",schema="public")
public class VehicleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",unique = true,nullable  = false)
    private Integer id;
	
	@Column(name="number_plate",nullable = false)
	private String numberPlate;
	
	@Column(name="type_of_vehicle",nullable = false)
	private String typeOfVehicle;
}

package hrms.hrms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "system_employee")
public class SystemEmployee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sytem_employeeId")
	private int id;
	
	@NotBlank(message = "First name cannot be blank.")
    @Size(min = 2, max = 100, message = "First name must be between 2 and 100 characters.")
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @NotBlank(message = "Last name cannot be blank.")
    @Size(min = 2, max = 100, message = "Last name must be between 2 and 100 characters.")
    @Column(name = "lastName", nullable = false, length = 100)
    private String lastName;
	

}

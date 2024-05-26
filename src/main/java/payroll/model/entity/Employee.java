package payroll.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @SequenceGenerator(name = "role_action_seq", sequenceName = "role_action_seq", allocationSize = 2, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_action_seq")
    private Long id;
    private String name;
    private String role;

}

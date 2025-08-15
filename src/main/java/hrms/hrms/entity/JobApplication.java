package hrms.hrms.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Table(
	    name = "job_applications",
	    uniqueConstraints = @UniqueConstraint(columnNames = {"job_advertisement_id", "job_seeker_id"})
	)
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_application_id")
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "job_advertisement_id", nullable = false)
    private JobAdvertisement jobAdvertisement;

    @ManyToOne(optional = false)
    @JoinColumn(name = "job_seeker_id", nullable = false)
    private JobSeeker jobSeeker;

    @Column(name = "application_date", nullable = false)
    private LocalDateTime applicationDate = LocalDateTime.now();

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private JobApplicationStatus status = JobApplicationStatus.PENDING;
}
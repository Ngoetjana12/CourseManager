package com.mecerintered.coursemanager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Course Name cannot be empty!")
    @Size(min = 3, max = 100)
    @Column(name = "course_name", unique = true)
    private String courseName;

    @NotNull(message = "Start date cannot be null!")
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull(message = "End date cannot be null!")
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @NotNull(message = "Course cost is required!")
    @Column(name = "course_cost", nullable = false)
    private BigDecimal courseCost;

    @NotBlank(message = "Course Venue cannot be empty!")
    @Column(name = "course_venue", nullable = false, length = 100)
    private String courseVenue;


    @AssertTrue(message = "End Date must be after start Date!")
    public boolean isEndDateValid(){

        if (startDate == null || endDate == null){

            return true;
        }

        return endDate.isAfter(startDate);
    }
}

package io.fdlessard.codebites.jpaflush.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Table(name = "customer", schema = "public")
@Entity
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {

    private String aliasId;

    @NotBlank(message = "lastName name cannot be blank")
    @Size(min = 2, message = "lastName must have more thant 2 characters")
    private String lastName;

    @NotBlank(message = "firstName name cannot be blank")
    @Size(min = 2, message = "firstName must have more thant 2 characters")
    private String firstName;

    @NotBlank(message = "company name cannot be blank")
    @Size(min = 2, message = "company must have more thant 2 characters")
    private String company;

}



package com.epam.infinispan.embedded.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="country")
@Data
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name",nullable=false)
    private String name;

    @Column(name="registration_date",nullable=false)
    private Date registrationDate;

    @Column(name="population",nullable=false)
    private Integer population;

    @Column(name="language",nullable=false)
    private String language;

}

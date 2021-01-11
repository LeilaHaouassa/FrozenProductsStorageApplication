package com.lilly182.frigoapi.models;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Getter
@Setter
public class Package extends BaseEntity {
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "owner_id", nullable = false)
    private PackageType packageType;
    @ManyToOne
    @JoinColumn(name = "storehouse_id", nullable = false)
    private Storehouse storehouse;
    @CreationTimestamp
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date entryDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date exitDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    @NotNull
    private Double quantity;
    @Enumerated(value = EnumType.STRING)
    private PackageStatus packageStatus = PackageStatus.IN;
}

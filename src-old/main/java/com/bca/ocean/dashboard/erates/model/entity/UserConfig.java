package com.bca.ocean.dashboard.erates.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_USER_DASHBOARD_CONFIG")
public class UserConfig {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "VARCHAR(36)", unique = true,nullable = false)
    private Long id;

    @JsonProperty(value = "user_id")
    @Column(name = "user_id")
    private String userId;

    @JsonProperty(value = "corporate_id")
    @Column(name = "corporate_id")
    private String corporateId;
    @JsonProperty(value = "rate_order")
    @Column(name = "rate_order")
    private String rateOrder;

    @JsonProperty(value = "insert_date")
    @Column(name = "insert_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date insertDate;

    @JsonProperty(value = "update_date")
    @Column(name = "update_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updateDate;

}

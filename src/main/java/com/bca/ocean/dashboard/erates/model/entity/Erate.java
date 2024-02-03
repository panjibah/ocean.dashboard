package com.bca.ocean.dashboard.erates.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.Primary;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_ERATES")
public class Erate {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "VARCHAR(32)", unique = true,nullable = false)
    private Long id;

    @JsonProperty(value = "rate")
    @Column(name = "rate")
    private String rate;

    @JsonProperty(value = "currency")
    @Column(name = "currency")
    private String currency;
    @JsonProperty(value = "bid")
    @Column(name = "bid")
    private String bid;
    @JsonProperty(value = "ask")
    @Column(name = "ask")
    private String ask;

    @JsonProperty(value = "mid")
    @Column(name = "mid")
    private String mid;

    @JsonProperty(value = "last_update")
    @Column(name = "last_update")
    private String lastUpdate;

    @JsonProperty(value = "tracing_id")
    @Column(name = "tracing_id")
    private String tracingId;

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

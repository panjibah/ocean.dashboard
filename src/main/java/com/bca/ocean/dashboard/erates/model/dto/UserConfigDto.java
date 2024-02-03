    package com.bca.ocean.dashboard.erates.model.dto;

    import com.fasterxml.jackson.databind.PropertyNamingStrategy;
    import com.fasterxml.jackson.databind.annotation.JsonNaming;
    import lombok.Data;

    import java.util.Date;
    import java.util.List;

    @Data
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public class UserConfigDto {
        private String id;
        private List<String> rateOrder;

        private Date insertDate;
        private Date updateDate;

    }

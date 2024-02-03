package com.bca.ocean.dashboard.erates.model.io.response.userConfig;

import com.bca.ocean.dashboard.erates.model.entity.UserConfig;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UpdateUserConfigOutputSchema {
 private List<String> rateOrder;


}

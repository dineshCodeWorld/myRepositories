package com.example.springpaytm;

import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties("paytm.payment.sandbox")
public class PaytmDetails
{
  private String merchantId;
  private String merchantKey;
  private String channelId;
  private String website;
  private String industryTypeId;
  private String paytmUrl;
  private Map<String, String> details;
  
}
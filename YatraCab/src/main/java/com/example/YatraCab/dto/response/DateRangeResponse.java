package com.example.YatraCab.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DateRangeResponse {
  private double totalDist;
  private double totalFair;
  private double avg;
}
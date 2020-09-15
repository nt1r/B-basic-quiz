package com.gtb.quiz.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationVo {
    @NotNull
    @Max(2020)
    Long year;

    @NotNull
    @Size(max = 32)
    String title;

    @NotNull
    @Size(max = 512)
    String description;
}

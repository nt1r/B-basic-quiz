package com.gtb.quiz.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// GTB: + 有单独的 Vo
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVo {
    @NotBlank
    @Size(max = 128)
    String name;

    @NotNull
    @Min(17)
    Long age;

    @NotNull
    @Size(min = 1, max = 512)
    String avatar;

    @Size(max = 1024)
    String description;
}

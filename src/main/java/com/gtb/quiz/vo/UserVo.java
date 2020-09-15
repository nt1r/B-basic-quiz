package com.gtb.quiz.vo;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVo {
    @NotBlank
    @Size(max = 16)
    String name;

    @NotNull
    @Min(17)
    Long age;

    @NotNull
    @Size(min = 1, max = 64)
    String avatar;

    @Size(max = 128)
    String description;
}

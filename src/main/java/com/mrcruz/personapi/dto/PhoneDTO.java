package com.mrcruz.personapi.dto;

import com.mrcruz.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @NotBlank
    private String number;
}

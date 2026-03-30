package com.eventostec.api.domain.event;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EventRequestDTO(

        @NotBlank(message = "Title é obrigatório")
        String title,

        @NotBlank(message = "Description é obrigatório")
        String description,

        @NotNull(message = "Data é obrigatória")
        Long data,

        @NotBlank(message = "City é obrigatório")
        String city,

        @NotBlank(message = "State é obrigatório")
        String state,

        @NotNull(message = "Remote é obrigatório")
        Boolean remote,

        @NotBlank(message = "URL do evento é obrigatória")
        String eventUrl

) {}
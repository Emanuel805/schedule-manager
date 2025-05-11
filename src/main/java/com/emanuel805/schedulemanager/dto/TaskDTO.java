package com.emanuel805.schedulemanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record TaskDTO(@JsonProperty(access = JsonProperty.Access.READ_ONLY) Long id,
                      String name,
                      String description,
                      LocalDate deadline,
                      int priority) {
}

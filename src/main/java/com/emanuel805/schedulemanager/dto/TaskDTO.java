package com.emanuel805.schedulemanager.dto;

import java.time.LocalDate;

public record TaskDTO(Long id, String name, String description, LocalDate deadline) {
}

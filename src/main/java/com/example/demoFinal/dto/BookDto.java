package com.example.demoFinal.dto;
import lombok.Builder;

@Builder
public record BookDto (String title, String author){}
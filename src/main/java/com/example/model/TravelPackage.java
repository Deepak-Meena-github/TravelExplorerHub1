package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TravelPackage {
    private final String travelPackageId;
    private final List<Iternary> iternaries;
}

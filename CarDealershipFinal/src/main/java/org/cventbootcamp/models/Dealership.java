package org.cventbootcamp.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dealership {
    private int dealership_id;
    private String name;
    private String address;
    private String phone;
}


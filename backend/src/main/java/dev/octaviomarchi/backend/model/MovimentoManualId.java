package dev.octaviomarchi.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovimentoManualId implements Serializable {

    private Long datMes;

    private Long datAno;
}

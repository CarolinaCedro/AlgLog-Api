package io.github.CarolinaCedro.algalogapi.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Errors {
    private Integer status;
    private LocalDate dataHora;
    private String titulo;
    private List<Campo>campos;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Campo{
        private String nome;
        private String msg;
    }
}

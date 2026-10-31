package com.gqs.aula.tdd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraNotaTest {

    // --- Ciclo 1 & 2: Soma das notas ---

    @Test
    void deveSomarAsTresNotas() {
        CalculadoraNota calc = new CalculadoraNota();
        double resultado = calc.calcularNotaFinal(20, 20, 30);
        assertEquals(70, resultado);
    }

    @Test
    void deveSomarOutrasNotas() {
        CalculadoraNota calc = new CalculadoraNota();
        double resultado = calc.calcularNotaFinal(10, 15, 25);
        assertEquals(50, resultado);
    }

    // --- Ciclo 3: Verificação de Aprovação ---

    @Test
    void deveAprovarComNota70() {
        CalculadoraNota calc = new CalculadoraNota();
        assertTrue(calc.estaAprovadoPorNota(70));
    }

    @Test
    void deveReprovarComNota69() {
        CalculadoraNota calc = new CalculadoraNota();
        assertFalse(calc.estaAprovadoPorNota(69));
    }

    // --- Ciclo 4: Validação de Notas Inválidas (Parte 2) ---

    @Test
    void deveRejeitarA1MaiorQue30() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class, () -> calc.calcularNotaFinal(35, 20, 30));
    }

    @Test
    void deveRejeitarA2MaiorQue30() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class, () -> calc.calcularNotaFinal(20, 35, 30));
    }

    @Test
    void deveRejeitarA3MaiorQue40() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class, () -> calc.calcularNotaFinal(20, 20, 45));
    }

    @Test
    void deveRejeitarA1Negativa() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class, () -> calc.calcularNotaFinal(-5, 20, 30));
    }

    @Test
    void deveAceitarNotasMaximas() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(100, calc.calcularNotaFinal(30, 30, 40));
    }
}
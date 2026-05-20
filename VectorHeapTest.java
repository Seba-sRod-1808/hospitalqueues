/**
 * Pruebas de caja negra y blanca para validar el comportamiento del VectorHeap.
 * Comprueba las politicas estrictas del triaje medico segun JUnit 4.
 * @author Sebastian Rodas 25038
 * @version 1.0
 * @since 2026-05-19
 */
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class VectorHeapTest {
    private VectorHeap<Paciente> heap;

    @Before
    public void setUp() {
        heap = new VectorHeap<>();
    }

    @Test
    public void testInsertarYReorganizarRaiz() {
        heap.add(new Paciente("Paciente Leve", "Dolor menor", "E"));
        heap.add(new Paciente("Paciente Critico", "Apendicitis", "A"));
        heap.add(new Paciente("Paciente Moderado", "Fractura", "C"));

        assertFalse(heap.isEmpty());
        assertEquals(3, heap.size());
        assertEquals("A", heap.peek().getCodigoEmergencia());
        assertEquals("Paciente Critico", heap.peek().getNombre());
    }

    @Test
    public void testExtraccionOrdenadaCompleta() {
        heap.add(new Paciente("N3", "Sintoma", "C"));
        heap.add(new Paciente("N1", "Sintoma", "A"));
        heap.add(new Paciente("N4", "Sintoma", "E"));
        heap.add(new Paciente("N2", "Sintoma", "B"));

        assertEquals("A", heap.remove().getCodigoEmergencia());
        assertEquals("B", heap.remove().getCodigoEmergencia());
        assertEquals("C", heap.remove().getCodigoEmergencia());
        assertEquals("E", heap.remove().getCodigoEmergencia());
        assertTrue(heap.isEmpty());
    }
}
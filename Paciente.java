/**
 * Clase que modela la entidad de un Paciente en la sala de emergencias.
 * Implementa la interfaz Comparable para determinar la prioridad de atencion medica.
 * @author Sebastian Rodas 25038
 * @version 1.0
 * @since 2026-05-19
 */
public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private String codigoEmergencia;

    public Paciente(String nombre, String sintoma, String codigoEmergencia) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigoEmergencia = codigoEmergencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSintoma() {
        return sintoma;
    }

    public String getCodigoEmergencia() {
        return codigoEmergencia;
    }

    @Override
    public int compareTo(Paciente otro) {
        return this.codigoEmergencia.compareTo(otro.getCodigoEmergencia());
    }

    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigoEmergencia;
    }
}
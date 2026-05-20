/**
 * Interfaz generica que define el comportamiento del ADT de una Cola con Prioridad.
 * @author Sebastian Rodas 25038
 * @version 1.0
 * @since 2026-05-19
 * @param <E> Tipo de elemento que se almacenara en la cola, debe ser Comparable.
 */
public interface PriorityQueue<E extends Comparable<E>> {
    public void add(E value);
    public E peek();
    public E remove();
    public boolean isEmpty();
    public int size();
    public void clear();
}
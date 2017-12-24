package OurStack.Noded;

public class Node {
    // Variable en la cual se va a guardar el valor.
    private Object valor;
    // Variable para enlazar los nodos.
    private Node siguiente;
    /**
     * Constructor para inicializar el valor de las variables.
     */
    public void Nodo(){
        this.valor = 0;
        this.siguiente = null;
    }
    
    // Métodos get y set para los atributos.
    
    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public Node getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Node siguiente) {
        this.siguiente = siguiente;
    }   
}
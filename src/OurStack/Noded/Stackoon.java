
package OurStack.Noded;

import dto.PaintBulletDto;


public class Stackoon {
 // Puntero que indica el inicio de la pila o tambien conocida como el
    // tope de la pila.
    private Node inicio;
    // Variable para registrar el tamaño de la pila.
    private int size = 0;
    
    /**
     * Constructor por defecto.
     */
    public void Stack(){
    }
    
    /**
     * Consulta si la pila esta vacia.
     * @return true si el primer nodo (inicio), no apunta a otro nodo.
     */
    public boolean isVoid(){
        return inicio == null;
    }
    
    /**
     * Consulta cuantos elementos (nodos) tiene la pila.
     * @return numero entero entre [0,n] donde n es el numero de elementos
     * que contenga la lista.
     */
    public int getSize(){
        return size;
    }
    
    /**
     * Agrega un nuevo nodo a la pila.
     * @param valor a agregar.
     */
    public void pileUp(Object valor){
        // Define un nuevo nodo.
        Node nuevo = new Node();
        // Agrega al valor al nodo.
        nuevo.setValor(valor);
        // Consulta si la pila esta vacia.
        
        if (isVoid()) {
            // Inicializa la pila con el nuevo valor.
            inicio = nuevo;
        }
        // Caso contrario agrega el nuevo nodo al inicio de la pila.
        else{
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
        // Incrementa el contador del tamaño.
        size++;
    } 
    
    
    /*
    * Elimina el primero en la lista
    */
    public void dropFirst(){
        if (inicio != null && inicio.getSiguiente() != null)
            inicio = inicio.getSiguiente();
        else{
            inicio = null;
        }
        if(size >= 0)
            size--;
    } 
    
    
    public void list(){
        // Crea una copia de la pila.
        Node aux = inicio;
        // Recorre la pila hasta el ultimo nodo.
        while(aux != null){
            System.out.println("|\t" + aux.getValor().toString() + "\t|");
            System.out.println("-----------------");
            aux = aux.getSiguiente();
        }
    }
    
    public Node getFirst(){
        return inicio;
    }
    
    public Node getLast(){
        Node aux = inicio;
        // Recorre la pila hasta el ultimo nodo.
        while(aux.getSiguiente() == null){
            aux = aux.getSiguiente();
        }        
        return aux;
    }
    
    //Método que obtiene el Nodo a traves de un índicie
    public Node GetNodeByIndex(int index) {
        if(index >= 0) {
            int currentIndex = 0;
            Node temp = inicio;
            while(temp != null) {
                if(currentIndex == index){
                    // Formato de Pila
                    Node auxObj = null;
                    Stackoon aux = new Stackoon();
                    boolean encontrado = false;
                    
                    for (int i = 0; i <= currentIndex; i++) {
                        if (i == currentIndex){
                           encontrado = true;
                           auxObj = inicio;
                           break;
                        }else{
                            aux.pileUp(inicio.getValor());
                            dropFirst();
                        }
                    }
                    for (int i = 0; i < currentIndex; i++) {
                        pileUp(aux.inicio.getValor());
                        aux.dropFirst();
                    }
                    if(encontrado)
                        return auxObj;
                }else {
                    currentIndex++;
                    temp = temp.getSiguiente();
                }
            }
        }     
        throw new IndexOutOfBoundsException("El índice ingresado se encuentra fuera de rango para la colección.");
    }
    
    //Método que obtiene el contenido de un nodo con un índice según el orden en que se encuentra en la lista
    public Object GetByIndex(int index) {
        if(index >= 0) {
            int currentIndex = 0;
            Node temp = inicio;
            while(temp != null) {
                if(currentIndex == index){
                    // Formato de Pila
                    Object auxObj = null;
                    Stackoon aux = new Stackoon();
                    boolean encontrado = false;
                    
                    for (int i = 0; i <= currentIndex; i++) {
                        if (i == currentIndex){
                           encontrado = true;
                           auxObj = inicio.getValor();
                           break;
                        }else{
                            aux.pileUp(inicio.getValor());
                            dropFirst();
                        }
                    }
                    for (int i = 0; i < currentIndex; i++) {
                        pileUp(aux.inicio.getValor());
                        aux.dropFirst();
                    }
                    if(encontrado)
                        return auxObj;
                }else {
                    currentIndex++;
                    temp = temp.getSiguiente();
                }
            }
        }     
        throw new IndexOutOfBoundsException("El índice ingresado se encuentra fuera de rango para la colección.");
    }
    
    //Borre un nodo según índice
    public boolean DeleteByIndex(int index) {
        if(index >= 0) {
            int currentIndex = 0;
            Node temp = inicio;
            while(temp != null) {
                System.out.println("currentIndex " + currentIndex);
                if(currentIndex == index){
                    // Formato de Pila
                    Object auxObj = null;
                    Stackoon aux = new Stackoon();
                    boolean encontrado = false;
                    
                    for (int i = 0; i <= currentIndex; i++) {
                        System.out.println("Indice " + i);
                        if (i == currentIndex){
                            encontrado = true;
                            dropFirst();
                        }else{
                            aux.pileUp(inicio.getValor());
                            dropFirst();
                        }
                    }
                    for (int i = 0; i < currentIndex; i++) {
                        pileUp(aux.inicio.getValor());
                        aux.dropFirst();
                    }
                    if(encontrado)
                        return true;
                }else {
                    currentIndex++;
                    temp = temp.getSiguiente();
                }
            }
            return false;
        }     
        throw new IndexOutOfBoundsException("El índice ingresado se encuentra fuera de rango para la colección.");
    }
}
public class MiLista implements ListInterface {
    private ListNode cabeza;

    @Override
    public boolean isEmpty() {
        return this.cabeza == null;
    }


    @Override
    public int getSize() {

        ListNode iterador = this.cabeza;
        int contador = 0;
        while (iterador.siguiente != null) {
            iterador = iterador.siguiente;
            contador++;

        }
        return contador;
    }

    @Override
    public void clear() {
        this.cabeza = null;

    }

    @Override
    public Object getHead() {
        if (this.cabeza == null) {
            return null;
        }
        return this.cabeza.dato;

    }

    @Override
    public Object getTail() {
        if (this.cabeza == null) {
            return null;
        }
        ListNode iterador = this.cabeza;
        while (iterador.siguiente != null) {
            iterador = iterador.siguiente;

        }
        return iterador.dato;
    }

    @Override
    public Object get(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode iterador = this.cabeza;
        while (iterador != null) {
            if (iterador == node) {
                return iterador.dato;
            }
            iterador = iterador.siguiente;
        }
        return null;
    }


    @Override
    public Object search(Object object) {
        if (object == null) {
            return null;
        }
        ListNode iterador = this.cabeza;
        while (iterador != null) {
            if (iterador.dato.equals(object)) {
                return iterador.dato;
            }
            iterador = iterador.siguiente;
        }
        return null;
    }

    @Override
    public boolean add(Object object) {
        if (object == null) {
            return false;
        }
        ListNode nuevo = new ListNode(object);
        if (this.cabeza == null) {
            this.cabeza = nuevo;
            return true;
        }
        ListNode iterador = this.cabeza;
        while (iterador.siguiente != null) {
            iterador = iterador.siguiente;

        }
        iterador.siguiente = nuevo;
        return true;
    }

    @Override
    public boolean insert(ListNode node, Object object) {
        if (node == null || object == null) {
            return false;
        }
        ListNode nuevo = new ListNode(object);
        nuevo.siguiente = node.siguiente;
        node.siguiente = nuevo;
        return true;
    }

    @Override
    public boolean insert(Object ob, Object object) {
        if (ob == null || object == null) {
            return false;
        }
        ListNode iterador = this.cabeza;
        while (iterador != null) {
            if (iterador.dato.equals(ob)) {
                ListNode nuevo = new ListNode(object);
                nuevo.siguiente = iterador.siguiente;
                iterador.siguiente = nuevo;
                return true;
            }
            iterador = iterador.siguiente;
        }
        return false;
    }

    @Override
    public boolean insertHead(Object object) {
        try {
            // 1er paso: Crear el nuevo nodo con la información recibida
            ListNode nuevaCabeza = new ListNode(object);
            //2do paso: Conectar el nodo a la cabeza
            nuevaCabeza.siguiente = this.cabeza;
            //3er paso: redefinir la cabeza
            this.cabeza = nuevaCabeza;
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrió un error");
            return false;
        }
    }

    @Override
    public boolean insertTail(Object object) {
        if (this.cabeza == null) {
            ListNode nuevaCabeza = new ListNode(object);
            this.cabeza = nuevaCabeza;
        } else {
            ListNode nuevaCola = new ListNode(object);
            ListNode iterador = this.cabeza;
            while (iterador.siguiente != null) {
                iterador = iterador.siguiente;

            }
            iterador.siguiente = nuevaCola;
        }
        return true;

    }

    @Override
    public boolean set(ListNode node, Object object) {
        if (node == null || object == null) {
            return false;
        }
        node.dato = object;
        return true;
    }

    @Override
    public boolean remove(ListNode node) {
        if (node == null || this.cabeza == null) {
            return false;
        }
        if (this.cabeza == node) {
            this.cabeza = this.cabeza.siguiente;
            return true;
        }
        ListNode iterador = this.cabeza;
        while (iterador.siguiente != null) {
            if (iterador.siguiente == node) {
                iterador.siguiente = node.siguiente;
                return true;
            }
            iterador = iterador.siguiente;
        }
        return false;
    }

    @Override
    public boolean contains(Object object) {
        if (object == null) {
            return false;
        }
        ListNode iterador = this.cabeza;
        while (iterador != null) {
            if (iterador.dato.equals(object)) {
                return true;
            }
            iterador = iterador.siguiente;
        }
        return false;
    }


    @Override
    public Object[] toArray() {
        Object[] arreglo = new Object[this.getSize()];
        ListNode iterador = this.cabeza;
        int i = 0;
        while (iterador != null) {
            arreglo[i] = iterador.dato;
            i++;
            iterador = iterador.siguiente;
        }
        return arreglo;
    }

    @Override
    public Object[] toArray(Object[] object) {
        int tamano = this.getSize();
        if (object.length < tamano) {
            object = new Object[tamano];
        }
        ListNode iterador = this.cabeza;
        int i = 0;
        while (iterador != null) {
            object[i] = iterador.dato;
            i++;
            iterador = iterador.siguiente;
        }
        if (object.length > tamano) {
            object[tamano] = null;
        }
        return object;
    }


    @Override
    public Object getBeforeTo(ListNode node) {
        if (node == null || this.cabeza == null || this.cabeza == node) {
            return null;
        }
        ListNode iterador = this.cabeza;
        while (iterador.siguiente != null) {
            if (iterador.siguiente == node) {
                return iterador.dato;
            }
            iterador = iterador.siguiente;
        }
        return null;
    }


    @Override
    public Object getNextTo(ListNode node) {
        if (node == null || node.siguiente == null) {
            return null;
        }
        return node.siguiente.dato;
    }


    @Override
    public MiLista subList(ListNode from, ListNode to) {
        if (from == null || to == null || this.cabeza == null) {
            return null;
        }
        MiLista resultado = new MiLista();
        ListNode iterador = from;
        boolean encontroTo = false;
        while (iterador != null) {
            resultado.add(iterador.dato);
            if (iterador == to) {
                encontroTo = true;
                break;
            }
            iterador = iterador.siguiente;
        }
        if (!encontroTo) {
            return null;
        }
        return resultado;
    }


    @Override
    public MiLista sortList() {
        if (this.cabeza == null || this.cabeza.siguiente == null) {
            return this;
        }
        boolean huboIntercambio;
        do {
            huboIntercambio = false;
            ListNode iterador = this.cabeza;
            while (iterador.siguiente != null) {
                int comparacion = ((Comparable) iterador.dato).compareTo(iterador.siguiente.dato);
                if (comparacion > 0) {
                    Object temporal = iterador.dato;
                    iterador.dato = iterador.siguiente.dato;
                    iterador.siguiente.dato = temporal;
                    huboIntercambio = true;
                }
                iterador = iterador.siguiente;
                }
        } while (huboIntercambio);
        return this;
    }
}








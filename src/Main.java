public class Main {

    public static void main(String[] args) {

        MiLista lista = new MiLista();

        lista.insertTail(10);
        lista.insertTail(20);
        lista.insertTail(30);
        lista.insertHead(5);

        System.out.println(lista.toString());
        System.out.println(lista.getSize());
        System.out.println(lista.getHead());
        System.out.println(lista.getTail());

        System.out.println(lista.search(20));
        System.out.println(lista.contains(30));

        lista.insert(20, 999);
        System.out.println(lista.toString());

        Object[] arreglo = lista.toArray();
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
        }

        lista.clear();
        System.out.println(lista.isEmpty());
    }
}

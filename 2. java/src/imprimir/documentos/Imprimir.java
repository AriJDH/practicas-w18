package imprimir.documentos;

public interface Imprimir<T> {
	
	default void imprimir(T object) {
		
		System.out.println(object.toString());
		
	}

}

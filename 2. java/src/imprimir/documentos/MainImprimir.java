package imprimir.documentos;

public class MainImprimir {
	
	public static void main(String[] args) {
		
		Informes informes = new Informes();
		informes.imprimir(informes);
		
		LibrosPDF libros = new LibrosPDF();
		libros.imprimir(libros);
		
		Curriculum curriculum = new Curriculum();
		curriculum.imprimir(curriculum);
		
		
	}

}

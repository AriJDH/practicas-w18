public class LibrosPDF implements Documento{
    private String cantidadDePaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibrosPDF(){}
    public LibrosPDF(String cantidadDePaginas, String nombreAutor, String titulo, String genero){
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }
    public String getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(String cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public void imprimirDocumento(String tipoDocumento) {
        System.out.println("Tipo de documento: Libros PDF");
        LibrosPDF librosPDF = new LibrosPDF();
        System.out.println(librosPDF.toString());
    }
}


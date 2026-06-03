package AssistenteInstalacao;

public class Sistema {

    private String diretorio;
    private String usuario;

    public void definirDiretorio(String diretorio) {
        this.diretorio = diretorio;
        System.out.println("Diretório configurado para: " + this.diretorio);
    }

    public void limparDiretorio() {
        System.out.println("Configuração do diretório " + this.diretorio + " desfeita.");
        this.diretorio = null;
    }

    public void criarUsuario(String usuario) {
        this.usuario = usuario;
        System.out.println("Usuário " + this.usuario + " criado.");
    }

    public void removerUsuario() {
        System.out.println("Criação do usuário " + this.usuario + " desfeita.");
        this.usuario = null;
    }

    public String getDiretorio() {
        return diretorio;
    }

    public String getUsuario() {
        return usuario;
    }

}

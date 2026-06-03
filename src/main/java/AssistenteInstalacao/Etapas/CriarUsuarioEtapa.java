package AssistenteInstalacao.Etapas;

import AssistenteInstalacao.EtapaInstalacao;
import AssistenteInstalacao.Sistema;

public class CriarUsuarioEtapa implements EtapaInstalacao {

    private Sistema sistema;
    private String usuario;

    public CriarUsuarioEtapa(Sistema sistema, String usuario) {
        this.sistema = sistema;
        this.usuario = usuario;
    }

    public void executar() {
        this.sistema.criarUsuario(this.usuario);
    }

    public void cancelar() {
        this.sistema.removerUsuario();
    }

}

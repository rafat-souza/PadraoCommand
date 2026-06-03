package AssistenteInstalacao.Etapas;

import AssistenteInstalacao.EtapaInstalacao;
import AssistenteInstalacao.Sistema;

public class ConfigurarDiretorioEtapa implements EtapaInstalacao {

    private Sistema sistema;
    private String diretorio;

    public ConfigurarDiretorioEtapa(Sistema sistema, String diretorio) {
        this.sistema = sistema;
        this.diretorio = diretorio;
    }

    public void executar() {
        this.sistema.definirDiretorio(this.diretorio);
    }

    public void cancelar() {
        this.sistema.limparDiretorio();
    }

}

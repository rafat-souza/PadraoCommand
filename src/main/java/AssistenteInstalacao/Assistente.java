package AssistenteInstalacao;

import java.util.ArrayList;
import java.util.List;

public class Assistente {

    private List<EtapaInstalacao> etapas = new ArrayList<EtapaInstalacao>();

    public void avancarEtapa(EtapaInstalacao etapa) {
        this.etapas.add(etapa);
        etapa.executar();
    }

    public void voltarUltimaEtapa() {
        if (etapas.size() != 0) {
            EtapaInstalacao etapa = this.etapas.get(this.etapas.size() - 1);
            etapa.cancelar();
            this.etapas.remove(this.etapas.size() - 1);
        }
    }

}

package Testes;

import AssistenteInstalacao.Assistente;
import AssistenteInstalacao.EtapaInstalacao;
import AssistenteInstalacao.Etapas.ConfigurarDiretorioEtapa;
import AssistenteInstalacao.Etapas.CriarUsuarioEtapa;
import AssistenteInstalacao.Sistema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssistenteTest {

    private Assistente assistente;
    private Sistema sistema;

    @BeforeEach
    void setUp() {
        assistente = new Assistente();
        sistema = new Sistema();
    }

    @Test
    void deveExecutarEtapaConfigurarDiretorio() {
        EtapaInstalacao etapa = new ConfigurarDiretorioEtapa(sistema, "C:/Arquivos de Programas/App");
        assistente.avancarEtapa(etapa);

        assertEquals("C:/Arquivos de Programas/App", sistema.getDiretorio());
    }

    @Test
    void deveCancelarEtapaConfigurarDiretorio() {
        EtapaInstalacao etapa = new ConfigurarDiretorioEtapa(sistema, "C:/Arquivos de Programas/App");
        assistente.avancarEtapa(etapa);
        assistente.voltarUltimaEtapa();

        assertNull(sistema.getDiretorio());
    }

    @Test
    void deveExecutarMultiplasEtapas() {
        EtapaInstalacao etapa1 = new ConfigurarDiretorioEtapa(sistema, "C:/App");
        EtapaInstalacao etapa2 = new CriarUsuarioEtapa(sistema, "admin");

        assistente.avancarEtapa(etapa1);
        assistente.avancarEtapa(etapa2);

        assertEquals("C:/App", sistema.getDiretorio());
        assertEquals("admin", sistema.getUsuario());
    }

    @Test
    void deveCancelarUltimaEtapaExecutada() {
        EtapaInstalacao etapa1 = new ConfigurarDiretorioEtapa(sistema, "C:/App");
        EtapaInstalacao etapa2 = new CriarUsuarioEtapa(sistema, "admin");

        assistente.avancarEtapa(etapa1);
        assistente.avancarEtapa(etapa2);

        assistente.voltarUltimaEtapa();

        assertEquals("C:/App", sistema.getDiretorio());
        assertNull(sistema.getUsuario());
    }

    @Test
    void naoDeveLancarExcecaoAoCancelarSemEtapas() {
        assertDoesNotThrow(() -> assistente.voltarUltimaEtapa());
    }

}

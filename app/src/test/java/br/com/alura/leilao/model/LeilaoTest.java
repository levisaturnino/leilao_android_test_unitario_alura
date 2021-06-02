package br.com.alura.leilao.model;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.List;

public class LeilaoTest extends TestCase {

   public final Leilao CONSOLE = new Leilao("Console");
   public final Usuario LEVI = new Usuario("Levi");


    public void testDeve_Devolve_Descricao_Quando_Recebe_Descricao() {

        //executar a acao espera
        String  descricaoDevolvida = CONSOLE.getDescricao();

        //testar resultado esperado
        assertEquals("Console",descricaoDevolvida);
    }

    @Test
    public void testDeveDevolve_Maior_LanceG_Quando_Recebe_Apenas_Um_Lance(){

        CONSOLE.propoe(new Lance(LEVI,200.0));

        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        assertEquals(200.0,maiorLanceDevolvido);

    }

    @Test
    public void testDeve_Maior_Lance_Quando_Recebe_Mais_De_Um_Lance_Em_Ordem_Crescente_Devolve() {

        CONSOLE.propoe(new Lance(LEVI,100.0));
        CONSOLE.propoe(new Lance(new Usuario("Dias"),200.0));

        double maiorLanceDevolvido = CONSOLE.getMaiorLance();

        assertEquals(200.0,maiorLanceDevolvido);
    }

    @Test
    public void testDeve_Devolve_Maior_Lance_Lance_Quando_Recebe_Mais_De_Um_Lance_Em_Ordem_Descrente() {
        CONSOLE.propoe(new Lance(LEVI,10000.0));
        CONSOLE.propoe(new Lance(new Usuario("Dias"),9000.0));

        double maiorLanceDevolvido  = CONSOLE.getMaiorLance();

        assertEquals(10000.0,maiorLanceDevolvido);
    }


    @Test
    public void testDeveDevolve_Menor_LanceG_Quando_Recebe_Apenas_Um_Lance(){

        CONSOLE.propoe(new Lance(LEVI,200.0));

        double menorLanceDevolvidoConsole = CONSOLE.getMenorLance();

        assertEquals(200.0,menorLanceDevolvidoConsole);

    }


    @Test
    public void testDeve_Menor_Lance_Quando_Recebe_Mais_De_Um_Lance_Em_Ordem_Crescente_Devolve() {

        CONSOLE.propoe(new Lance(LEVI,100.0));
        CONSOLE.propoe(new Lance(new Usuario("Dias"),200.0));

        double menorLanceDevolvidoComputador = CONSOLE.getMenorLance();

        assertEquals(100.0,menorLanceDevolvidoComputador);
    }

    @Test
    public void testDeve_Devolve_Menor_Lance_Lance_Quando_Recebe_Mais_De_Um_Lance_Em_Ordem_Descrente() {

        CONSOLE.propoe(new Lance(LEVI,10000.0));
        CONSOLE.propoe(new Lance(new Usuario("Dias"),9000.0));

        double menorLanceDevolvidoCarro = CONSOLE.getMenorLance();

        assertEquals(9000.0,menorLanceDevolvidoCarro);
    }

    @Test
    public void testDeve_DevolverTresMaioresLances_QuandoRecebeExatosTresLances(){

        CONSOLE.propoe(new Lance(LEVI,200.0));
        CONSOLE.propoe(new Lance(new Usuario("Dias"),300.0));
        CONSOLE.propoe(new Lance(LEVI,400.0));

        List<Lance> tresMaioresLances = CONSOLE.tresMaiorLances();

        assertEquals(3,tresMaioresLances.size());

        assertEquals(400.0,tresMaioresLances.get(0).getValor());
        assertEquals(300.0,tresMaioresLances.get(1).getValor());
        assertEquals(200.0,tresMaioresLances.get(2).getValor());

    }


    @Test
    public void testDeve_DevolverTresMaioresLances_QuandoRecebeLances(){

        List<Lance> tresMaioresLances = CONSOLE.tresMaiorLances();

        assertEquals(0,tresMaioresLances.size());

    }


    @Test
    public void testDeve_DevolverTresMaioresLances_QuandoRecebeApenasUmLances(){

        CONSOLE.propoe(new Lance(LEVI,200.0));

        List<Lance> tresMaioresLances = CONSOLE.tresMaiorLances();

        assertEquals(1,tresMaioresLances.size());

        assertEquals(200.0,tresMaioresLances.get(0).getValor());

    }


    @Test
    public void testDeve_DevolverTresMaioresLances_QuandoRecebeApenasDoisLances(){

        CONSOLE.propoe(new Lance(LEVI,300.0));
        CONSOLE.propoe(new Lance(new Usuario("Dias"),400.0));
        List<Lance> tresMaioresLances = CONSOLE.tresMaiorLances();

        assertEquals(2,tresMaioresLances.size());

        assertEquals(400.0,tresMaioresLances.get(0).getValor());
        assertEquals(300.0,tresMaioresLances.get(1).getValor());

    }

    @Test
    public void testDeve_DevolverTresMaioresLances_QuandoRecebeApenasQuatroLances(){

        CONSOLE.propoe(new Lance(LEVI,300.0));
        CONSOLE.propoe(new Lance(new Usuario("Dias"),400.0));
        CONSOLE.propoe(new Lance(LEVI,500.0));
        CONSOLE.propoe(new Lance(LEVI,600.0));

        List<Lance> tresMaioresLances = CONSOLE.tresMaiorLances();

        assertEquals(3,tresMaioresLances.size());

        assertEquals(600.0,tresMaioresLances.get(0).getValor());
        assertEquals(500.0,tresMaioresLances.get(1).getValor());
        assertEquals(400.0,tresMaioresLances.get(2).getValor());

    }


    @Test
    public void testDeve_DevolverTresMaioresLances_QuandoRecebeApenasMaisQuatroLances(){

        CONSOLE.propoe(new Lance(LEVI,300.0));
        CONSOLE.propoe(new Lance(new Usuario("Dias"),400.0));
        CONSOLE.propoe(new Lance(LEVI,500.0));
        CONSOLE.propoe(new Lance(LEVI,600.0));

        List<Lance> tresMaioresLances = CONSOLE.tresMaiorLances();

        assertEquals(3,tresMaioresLances.size());

        assertEquals(600.0,tresMaioresLances.get(0).getValor());
        assertEquals(500.0,tresMaioresLances.get(1).getValor());
        assertEquals(400.0,tresMaioresLances.get(2).getValor());

        CONSOLE.propoe(new Lance(LEVI,700.0));

        final List<Lance> tresMaioresLances5valores = CONSOLE.tresMaiorLances();
        assertEquals(3,tresMaioresLances5valores.size());

        assertEquals(700.0,tresMaioresLances5valores.get(0).getValor());

        CONSOLE.propoe(new Lance(LEVI,800.0));

        final List<Lance> tresMaioresLances7valores = CONSOLE.tresMaiorLances();

        assertEquals(3,tresMaioresLances7valores.size());

        assertEquals(800.0,tresMaioresLances7valores.get(0).getValor());

    }

}
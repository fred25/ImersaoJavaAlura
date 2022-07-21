import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        // pega dado do IMDB com relação HTTP

        //String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        //ExtratorDeConteudo extrator = new ExtratorDeConteudoDoImdb();
        
        String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        var http = new ClienteHTTP();
        String json = http.buscaDados(url);

        List<Conteudo> conteudos = extrator.extraiConteudos(json);


        var gerador = new GeradorFigurinha();

        for(int i = 0; i < 3; i++){

            Conteudo conteudo = conteudos.get(i);

            String urlImagem = conteudo.getUrlImagem();
            String titulo = conteudo.getTitulo();

            InputStream inputStream = new URL(urlImagem).openStream();

            String nomeArquivo = titulo + ".png";

            gerador.cria(inputStream, nomeArquivo);



            System.out.println("Title: \u001b[1m" + titulo);
            System.out.println();            
        }
    }


}
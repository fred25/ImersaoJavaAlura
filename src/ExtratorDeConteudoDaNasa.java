import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo{
    
    @Override
    public List<Conteudo> extraiConteudos(String json){

        var parser = new JsonParser();

        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        //popular a lista de conteudos
        for(Map<String, String> atributo : listaDeAtributos){

            String titulo = atributo.get("title");
            String urlImagem = atributo.get("url");
            
            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);

        }

        return conteudos;

    }

}
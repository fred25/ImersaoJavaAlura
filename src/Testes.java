import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Testes {
    
    public static void main(String[] args) throws Exception{
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // separar por título, poster e classificação (parsear)

        var parser = new JsonParser();

        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        var PrimeiroFilme = listaDeFilmes.get(0);

        String link = PrimeiroFilme.get("image");

        String[] linkPicotado = link.split("@");

        linkPicotado[linkPicotado.length-1] = "";

        String resultado = "";

        for (String pedaco : linkPicotado){
            resultado += pedaco + "@";
        }

        StringBuffer sb= new StringBuffer(resultado);  

        sb.deleteCharAt(sb.length()-1);

        String resultadoFinal = sb.toString();

        resultadoFinal += ".jpg";

        System.out.println(resultadoFinal);
    
    }

    public String ajeitarLink(String link) {

        String[] linkPicotado = link.split("@");

        linkPicotado[linkPicotado.length-1] = "";

        String resultado = "";

        for (String pedaco : linkPicotado){
            resultado += pedaco + "@";
        }

        StringBuffer sb= new StringBuffer(resultado);  

        sb.deleteCharAt(sb.length()-1);

        String resultadoFinal = sb.toString();

        resultadoFinal += ".jpg";

        return resultadoFinal;
    
    }

}


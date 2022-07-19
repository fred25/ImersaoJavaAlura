import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
public class App {

    public static void main(String[] args) throws Exception {

        // pega dado do IMDB com relação HTTP

        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // separar por título, poster e classificação (parsear)

        var parser = new JsonParser();

        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular de qqr jeiro

        for(Map<String, String> filme : listaDeFilmes){

            System.out.println("Title: \u001b[1m" + filme.get("fullTitle"));
            System.out.println("\u001b[m Poster: \u001b[m" + filme.get("image"));

            System.out.println("\u001b[44m Rating: \u001b[m" + filme.get("imDbRating"));

            double rating = Double.parseDouble(filme.get("imDbRating"));

            for (int i = 0; i< rating; i++){
                System.out.print("\u2B50");
            }
            System.out.println();

            System.out.println();
            
        }

    }

}
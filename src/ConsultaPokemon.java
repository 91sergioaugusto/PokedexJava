import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaPokemon {

    public Pokemon buscarPokemon(String pokemonName) {
        URI pokemon = URI.create("https://pokeapi.co/api/v2/pokemon/" + pokemonName);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(pokemon)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Pokemon.class);
        } catch (Exception e) {
            throw new RuntimeException("Não consegui achar esse pokemon");
        }

    }
}

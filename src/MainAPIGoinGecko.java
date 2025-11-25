import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainAPIGoinGecko {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe a Cripto Moeda que Deseja Consultar a Cotação: ");
        var criptoInformada = scanner.nextLine();

        String busca = "https://api.coingecko.com/api/v3/simple/price?vs_currencies=usd&ids=" + criptoInformada + "&x_cg_demo_api_key=CG-gnHhCtvCLm9bHjw13vacYZAg";


        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(busca))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println(response.body());



    }
}

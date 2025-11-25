import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainAPIGoogleBooks {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o Livro que Deseja Consultar: ");
        var livroInformado = entrada.nextLine();

        String busca = "https://www.googleapis.com/books/v1/volumes?q=intitle:" + livroInformado + "&key=AIzaSyA-QB0eOOl1kbX7jSQnXUgWvnQxKlpr7Fc";

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

        System.out.println(response.body());


    }
}

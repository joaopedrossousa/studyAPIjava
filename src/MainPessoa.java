import com.google.gson.Gson;
import modelos.Pessoa;

public class MainPessoa {
    public static void main(String[] args) {

        String json = """
                {
                 "nome" : "Joao Pedro",
                 "idade" : "24",
                 "cidade" : "Palmas"
                }
                """;

        Gson gson = new Gson();
        Pessoa pessoa = gson.fromJson(json, Pessoa.class);

        System.out.println("Nome: " + pessoa.nome() + "\n" +
                "Idade: " + pessoa.idade() + "\n" +
                "Cidade: " + pessoa.cidade());

    }
}

import Records.Pokemon;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ConsultaPokemon consulta = new ConsultaPokemon();

        System.out.println("Digite o nome do pokemon para a pesquisa:");
        var pokemon = leitura.nextLine();
        try {
            Pokemon novoPokemon = consulta.buscarPokemon(pokemon);
            System.out.println(novoPokemon);
            GeradorDeArquivo gerador =  new GeradorDeArquivo();
            gerador.salvaJson(novoPokemon);
        }catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando aplicação");
        }


    }
}

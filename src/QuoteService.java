
import java.util.*;
        import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.Random;
public class QuoteService {
    public List<Quote> lista;

    public QuoteService() {
        lista = new LinkedList<Quote>();
        try {
            File fisier = new File("C:\\Users\\Cojocariu Josua\\won11\\Curs13\\src\\quotes.txt");
            Scanner scanner = new Scanner(fisier);
            int id = 1;
            while (scanner.hasNextLine()) {
                String[] auxiliar = scanner.nextLine().split("~");
                String author = auxiliar[0];
                String quote = auxiliar[1];
                Quote q1 = new Quote(id, author, quote);
                lista.add(q1);
                id++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost gasit!");
        }
    }

    public List<String> getAllQuotes() {
        List<String> list = new LinkedList<String>();
        for (Quote q : lista)
            list.add(q.getQuote());
        return list;
    }

    public List<String> getQuotesForAuthor(String autor) {
        List<String> list = new LinkedList<String>();
        for (Quote q : lista)
            if (q.getAuthor().equals(autor))
                list.add(q.getQuote());
        return list;
    }

    public List<String> getAuthors() {
        List<String> list = new LinkedList<String>();
        for (Quote q : lista) {
            boolean gasit = false;
            for (String aux : list) {
                if (q.getAuthor().equals(aux))
                    gasit = true;
            }
            if (gasit == false)
                list.add(q.getAuthor());
        }
        return list;
    }

    public void setFavourite(int id) {
        int contor = 1;
        for (Quote q : lista) {
            if (contor == id)
                q.setFavourite(true);
            contor++;
        }
    }

    public List<Quote> getFavourites() {
        List<Quote> list = new LinkedList<>();
        for (Quote q : lista) {
            if (q.isFavourite())
                list.add(q);
        }
        return list;
    }

    public String getRandomQuote() {
        Random rand = new Random();
        int random = rand.nextInt(lista.size());
        return lista.get(random).getQuote();
    }
}

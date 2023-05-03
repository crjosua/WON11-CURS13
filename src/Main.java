public class Main {
    public static void main(String[] args) {
        QuoteService qs = new QuoteService();
        System.out.println("Lista cu toate citatele: " + qs.getAllQuotes());
        System.out.println("Lista cu toate citatele pentru autorul Mitica: " + qs.getQuotesForAuthor("Mitica"));
        System.out.println("Lista cu toti autorii: " + qs.getAuthors());
        qs.setFavourite(2);
        qs.setFavourite(3);
        System.out.println("Citatele favorite " + qs.getFavourites().toString());
        System.out.println("Citat random: " + qs.getRandomQuote());
    }
}
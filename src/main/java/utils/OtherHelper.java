package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OtherHelper {

    private static List<String> searchedProducts;
    protected static Random random;

    private static List<String> getSearchedProducts() {
        searchedProducts = new ArrayList<>();
        searchedProducts.add("Kitap");
        searchedProducts.add("mouse");
        searchedProducts.add("Klavye");
        searchedProducts.add("Harici disk");
        return searchedProducts;
    }

    public static String getRandomProductName(){
        random = new Random();
        int randomIndex=0;
        List<String> products = getSearchedProducts();
        randomIndex = random.nextInt(products.size());
        return products.get(randomIndex);
    }

}

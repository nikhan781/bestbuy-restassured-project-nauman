package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest {

    static ValidatableResponse response;


    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);

    }

    public void startOfTest() {
        System.out.println("------------------Starting Test---------------------------");
    }

    public void endOfTest() {
        System.out.println("------------------End of Test-----------------------------");
    }

    //21. Extract the limit
    @Test
    public void extractLimitValue() {
        int limit = response.extract().path("limit");
        startOfTest();
        System.out.println("The value of limit is: " + limit);
        endOfTest();
    }

    //22. Extract the total
    @Test
    public void extractTotalValue() {
        int total = response.extract().path("total");
        startOfTest();
        System.out.println("The value of total is: " + total);
        endOfTest();
    }

    //23. Extract the name of 5th product
    @Test
    public void extractNameOfFifthProduct() {
        String productName = response.extract().path("data[4].name");
        startOfTest();
        System.out.println("The name of 5th product is: " + productName);
        endOfTest();
    }

    //24. Extract the names of all the products
    @Test
    public void extractNameOfAllProduct() {
        List<String> allProductsName = response.extract().path("data.name");
        startOfTest();
        System.out.println("The names of all products are: " + allProductsName);
        endOfTest();
    }

    //25. Extract the productId of all the products
    @Test
    public void extractIDsOfAllProduct() {
        List<Integer> allProductsIDs = response.extract().path("data.id");
        startOfTest();
        System.out.println("The IDs of all products are: " + allProductsIDs);
        endOfTest();
    }

    //26. Print the size of the data list
    @Test
    public void sizeOfDataList() {
        int size = response.extract().path("data.size");
        startOfTest();
        System.out.println("The size of data list is: " + size);
        endOfTest();
    }

    //27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-
//Pack)
    @Test
    public void allValuesOfProduct() {
        List<HashMap<String, ?>> valueList = response.extract().path("data.findAll{it.name =='Energizer - MAX Batteries AA (4-Pack)'}");
        startOfTest();
        System.out.println("The list of values  is: " + valueList);
        endOfTest();
    }

    //28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-
//Pack)
    @Test
    public void modelOfProduct() {
        List<?> model = response.extract().path("data.findAll{it.name =='Energizer - N Cell E90 Batteries (2-Pack)'}.model");
        startOfTest();
        System.out.println("The model of product  is: " + model);
        endOfTest();
    }

    //29. Get all the categories of 8th products
    @Test
    public void allCategoriesOfEighthProduct() {
        List<HashMap<String, ?>> allCat = response.extract().path("data[7].categories");
        startOfTest();
        System.out.println("The list of values  is: " + allCat);
        endOfTest();
    }

    //30. Get categories of the store where product id = 150115
    @Test
    public void getCategoriesForProductId() {
        List<HashMap<String, ?>> id = response.extract().path("data.findAll{it.id == 150115}.categories");
        startOfTest();
        System.out.println("The list of categories for ID 150115: " + id);
        endOfTest();
    }

    //31. Get all the descriptions of all the products
    @Test
    public void getDescriptionOfAllProducts() {
        List<HashMap<String, ?>> des = response.extract().path("data.description");
        startOfTest();
        System.out.println("The list of Description of all products is: " + des);
        endOfTest();
    }

    //32. Get id of all the all categories of all the products
    @Test
    public void getIDsOFAllProductsCategories() {
        List<HashMap<String, ?>> cat = response.extract().path("data.categories.id");
        startOfTest();
        System.out.println("The list of IDs of all products in Categories: " + cat);
        endOfTest();
    }

    //33. Find the product names Where type = HardGood
    @Test
    public void findTheProductHardGood() {
        List<HashMap<String, ?>> type = response.extract().path("data.findAll{it.type =='HardGood'}.name");
        startOfTest();
        System.out.println("The list of all products with HardGood Type: " + type);
        endOfTest();
    }

    //34. Find the Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)
    @Test
    public void findTotalNumberOfCategoriesForProducts() {
        List<String> tCat = response.extract().path("data.find{it.name =='Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");
        int size = tCat.size();
        startOfTest();
        System.out.println("The total number of Categories are: " + size);
        endOfTest();
    }
//35. Find the createdAt for all products whose price < 5.49
@Test
public void findAllProductWithPrice() {
    List<HashMap<String, ?>> createdAt = response.extract().path("data.findAll{it.price < 5.49 }.createdAt");
    startOfTest();
    System.out.println("The createdAt list is: " + createdAt);
    endOfTest();
}
//36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4- Pack)”
@Test
public void findCategoriesForProducts() {
    List<String> cat = response.extract().path("data.find{it.name =='Energizer - MAX Batteries AA (4-Pack)'}.categories.name");
//    int size = tCat.size();
    startOfTest();
    System.out.println("The total number of Categories are: " + cat);
    endOfTest();
}
//37. Find the manufacturer of all the products
@Test
public void findManufactureForAllProducts() {
    List<String> manu = response.extract().path("data.manufacturer");
 //int size = manu.size();
    startOfTest();
    System.out.println("The names of manufacturers are: " + manu);
    endOfTest();
}
//38. Find the imge of products whose manufacturer is = Energizer
@Test
public void findImageOfAProduct() {
    List<String> image = response.extract().path("data.findAll{it.manufacturer.contains('Energizer')}.image");
    startOfTest();
    System.out.println("The image of product is: " + image);
    endOfTest();
}
//39. Find the createdAt for all categories products whose price > 5.99
@Test
public void findAllProductWithPriceOver() {
    List<HashMap<String, ?>> createdAt = response.extract().path("data.findAll{it.price >5.99 }.createdAt");
    startOfTest();
    System.out.println("The createdAt list is: " + createdAt);
    endOfTest();
}
//40. Find the uri of all the products
@Test
public void findUrlOfAProduct() {
    List<String> url = response.extract().path("data.url");
    startOfTest();
    System.out.println("The image of product is: " + url);
    endOfTest();
}
}

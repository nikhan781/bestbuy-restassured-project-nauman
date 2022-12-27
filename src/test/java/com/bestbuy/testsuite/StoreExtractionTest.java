package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoreExtractionTest {

    static ValidatableResponse response;


    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);

    }


    public void startOfTest() {
        System.out.println("------------------StartingTest---------------------------");
    }

    public void endOfTest() {
        System.out.println("------------------End of Test----------------------------");
    }

    //    1. Extract the limit
    @Test
    public void extractLimit() {
        int limit = response.extract().path("limit");
        startOfTest();
        System.out.println("The value of limit is: " + limit);
        endOfTest();
    }

    //2. Extract the total
    @Test
    public void extractTotal() {
        int total = response.extract().path("total");
        startOfTest();
        System.out.println("The total is: " + total);
        endOfTest();
    }

    //3. Extract the name of 5th store
    @Test
    public void extractFifthStoreName() {
        String sName = response.extract().path("data[4].name");
        startOfTest();
        System.out.println("The name of 5th store is: " + sName);
        endOfTest();
    }

    //4. Extract the names of all the store
    @Test
    public void extractAllStoresName() {
        List<String> sNames = response.extract().path("data.name");
        startOfTest();
        System.out.println("The Name of all stores are: " + sNames);
        endOfTest();
    }

    //5. Extract the storeId of all the store
    @Test
    public void extractStoreIDs() {
        List<Integer> id = response.extract().path("data.id");
        startOfTest();
        System.out.println("The IDs are: " + id);
        endOfTest();
    }

    //6. Print the size of the data list
    @Test
    public void extractSizeOfData() {
        int size = response.extract().path("data.size");
        startOfTest();
        System.out.println("The size is: " + size);
        endOfTest();
    }

    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void extractAllValueForStCloud() {
        HashMap<String, ?> values = response.extract().path("data.find{it.name == 'St Cloud'}");
        startOfTest();
        System.out.println("The values are: " + values);
        endOfTest();
    }
//8. Get the address of the store where store name = Rochester
@Test
public void extractAddressOfTheStore() {
    String add = response.extract().path("data.find{it.name == 'Rochester'}.address");
    startOfTest();
    System.out.println("The address is: " + add);
    endOfTest();
}
//9. Get all the services of 8th store
@Test
public void extractAllServicesOfEightStore() {
    List<String> allSer = response.extract().path("data[7].services");
    startOfTest();
    System.out.println("The all services are: " + allSer);
    endOfTest();
}
//10. Get storeservices of the store where service name = Windows Store
@Test
public void extractServicesOfTheStore() {
    List<String> servs = response.extract().path("data.find{it.name == 'Rochester'}.services");
    startOfTest();
    System.out.println("The services are: " + servs);
    endOfTest();
}
//11. Get all the storeId of all the store
@Test
public void extractAllIDs() {
    List<String> allSer = response.extract().path("data.id");
    startOfTest();
    System.out.println("The IDs are: " + allSer);
    endOfTest();
}
//12. Get id of all the store
//13. Find the store names Where state = ND
@Test
public void extractStoreState() {
    List<String> name = response.extract().path("data.findAll{it.state == 'ND'}.name");
    startOfTest();
    System.out.println("The name of stores: " + name);
    endOfTest();
}
//14. Find the Total number of services for the store where store name = Rochester
@Test
public void extractTotalServiceOfTheStore() {
    int servs = response.extract().path("data.find{it.name == 'Rochester'}.services.size");
    startOfTest();
    System.out.println("The size of services is: " + servs);
    endOfTest();
}
//15. Find the createdAt for all services whose name = “Windows Store”
@Test
public void extractTCreatedATOfTheStore() {
   List<HashMap<String,?>> created = response.extract().path("data.services*.findAll{it.name=='Windows Store'}.createdAt");
    startOfTest();
    System.out.println("The list of created at is: " + created);
    endOfTest();
}
//16. Find the name of all services Where store name = “Fargo”
@Test
public void extractNameOfServiceAtTheStore() {
    List<HashMap<String,?>> service = response.extract().path("data.findAll{it.name == 'Fargo'}.services.name");
    startOfTest();
    System.out.println("The list of services is: " + service);
    endOfTest();
}
//17. Find the zip of all the store
@Test
public void extractZippfAllStore() {
    List<HashMap<String,?>> zip = response.extract().path("data.zip");
    startOfTest();
    System.out.println("The list of zip code is: " + zip);
    endOfTest();
}
//18. Find the zip of store name = Roseville
@Test
public void extractZippfAStore() {
    List<HashMap<String,?>> zip = response.extract().path("data.findAll{it.name == 'Roseville'}.zip");
    startOfTest();
    System.out.println("The zip code is: " + zip);
    endOfTest();
}
//19. Find the storeservices details of the service name = Magnolia Home Theater
@Test
public void extractServiceDetails() {
    List<HashMap<String,?>> details = response.extract().path("data.services*.findAll{it.name == 'Magnolia Home Theater'}.storeservices");
    startOfTest();
    System.out.println("The list of details is: " + details);
    endOfTest();
}
//20. Find the lat of all the stores
@Test
public void extractSListOfLat() {
    List<HashMap<Double,?>> lat = response.extract().path("data.lat");
    startOfTest();
    System.out.println("The list of lat is: " + lat);
    endOfTest();
}
}

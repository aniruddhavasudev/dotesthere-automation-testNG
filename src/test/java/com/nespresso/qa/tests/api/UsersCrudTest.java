package com.nespresso.qa.tests.api;

import com.nespresso.qa.api.ApiClient;
import com.nespresso.qa.base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UsersCrudTest extends BaseTest {

    private final ApiClient client = new ApiClient();
    private static String createdUserId;   // shared between tests
    @Test
    public void debugTest() {
        System.out.println("Test Executed");
    }
    @Test
    public void testCreateUser() {

        Response response = client.createUser();

        Assert.assertEquals(response.getStatusCode(), 201);

        String name = response.jsonPath().getString("data.name");
        String job = response.jsonPath().getString("data.job");

        Assert.assertEquals(name, "Ankur Malviya");
        Assert.assertEquals(job, "Developer");
    }

    @Test
    public void testReadUser() {

        Response response = client.getUser("1");

        Assert.assertEquals(response.getStatusCode(), 200);

        String email = response.jsonPath().getString("data.email");
        String firstName = response.jsonPath().getString("data.first_name");

        Assert.assertEquals(email, "ankur.automation@dotesthere.com");
        Assert.assertEquals(firstName, "Ankur");
    }

    @Test
    public void testUpdateUser() {

        Response response = client.updateUser("1");

        Assert.assertEquals(response.getStatusCode(), 200);

        String updatedName = response.jsonPath().getString("data.name");
        String updatedJob = response.jsonPath().getString("data.job");

        Assert.assertEquals(updatedName, "John Updated");
        Assert.assertEquals(updatedJob, "Senior Developer");
    }

    @Test
    public void testDeleteUser() {

        String testId = "1";

        Response deleteResp = client.deleteUser(testId);

        Assert.assertEquals(deleteResp.getStatusCode(), 204, "Delete should return 204");
    }
}
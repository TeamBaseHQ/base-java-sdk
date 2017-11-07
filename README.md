Base Java SDK
==============
Offical SDK for Java.

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/287633956111487bf324#?env%5BBaseApp-Staging%5D=W3siZW5hYmxlZCI6dHJ1ZSwia2V5IjoiYmFzZV91cmwiLCJ2YWx1ZSI6Imh0dHA6Ly9iYXNlYXBwLWJhY2tlbmQua3VuYWx2YXJtYS5pbiIsInR5cGUiOiJ0ZXh0In0seyJlbmFibGVkIjp0cnVlLCJrZXkiOiJBdXRoVmFsIiwidmFsdWUiOiJleUowZVhBaU9pSktWMVFpTENKaGJHY2lPaUpTVXpJMU5pSXNJbXAwYVNJNklqZG1abUUyTVRobE1qTTVZbVJtTmpFd05qRmhOamxoTTJJNFpUVTNaR1ppTVdZd01EWTFNRE15WWpRMk5UWmxNV0kwTkdKa01EazVPRE13WkRaaE1qSmlOVGMxWkRZMU9EQm1OMlV4TkRabUluMC5leUpoZFdRaU9pSXlJaXdpYW5ScElqb2lOMlptWVRZeE9HVXlNemxpWkdZMk1UQTJNV0UyT1dFellqaGxOVGRrWm1JeFpqQXdOalV3TXpKaU5EWTFObVV4WWpRMFltUXdPVGs0TXpCa05tRXlNbUkxTnpWa05qVTRNR1kzWlRFME5tWWlMQ0pwWVhRaU9qRTFNVEF3TVRreU9EY3NJbTVpWmlJNk1UVXhNREF4T1RJNE55d2laWGh3SWpveE5URXdNVEExTmpnM0xDSnpkV0lpT2lJeElpd2ljMk52Y0dWeklqcGJYWDAuTk9tdXJYZWlZNnBHOGYyT0hpdHBwN0ZvTmJNWmN2bjRtRmNuR1VfeHMzdG8xeXQwSkxlSVUyaWMwc2xDdl9VSzg4c2Z0Ny1sWVFNbkZMb0VmTGJ1LTRGd3ZfVFF4a2xDM2swaWlvNkFUaWR3cVJaSTY1Z1BrN0pub3NiMHFqZGtxUlI1SVJVOTRFOXhZc2J6NnhyZElqTUYyRWhVa2FYbG1aWExBZ0lsWEJmVG44aFJ5U0tqUGJKX3MzVlI2VzNNUHZJeVczOVRaT1ljUklVNHB6WnZaSlBIUXpoX1h5cG1IX2tXUmxncTBXZXE3RkxCRm1DeDlva3ZDTmtvX3JiQnNiTjFMZ3JEZ2NuTnNMVnZ0SG4yczJSSkJmMjd5N0dNVUFPRWc0cWJRY2c2MFE3SHlQenZrVmhmZmZoNFBIZGduWGNyNlJ4MUQzUVRZdEJTbGZ5TGZuZGpCdklNQnJSeW5uS1hqQlFBLWRyZnZOWC1ya3J3QkgzUFNselhKOFM0MFBGQmJ4NGVuNzBoZ21iSzc5bjB5eVc4QUhVYWp0am9qUzFtWkV2T08ySWhJS2dBTDJMTW0xQ2tISUR3QnhPc2doTHVXaUJTeWlvQXI5SXJwTUpUSmxjV3ZJREluXy1YVmR0V0FMQmVCdV9xOWU4QTZ2QThFUGo1TVdkSUZYbzA4NG13N1F3YXFCdFdibzE1ZkpqcmN5VENYcnB0bXZlc1ItM3VrSklBbUZPV1hGU0Y5bmZkU3hxYmlzNnoxVnkxTi1wSDZGaVlKUFhWU19ncmNVcWpETjRRdWFfZzNJbm91ZjZpbEgwbFUza0RZbXNXNU9YT3VHaDR0NDVpOTJYRVBEaWR6Z3Y2VTNjdGNGenJ0YzdpNDktaG5FMWd5dXJrNk5xZHJZQlVZb0EiLCJ0eXBlIjoidGV4dCJ9LHsiZW5hYmxlZCI6dHJ1ZSwia2V5IjoiYXBpX3VybCIsInZhbHVlIjoie3tiYXNlX3VybH19L2FwaSIsInR5cGUiOiJ0ZXh0In0seyJlbmFibGVkIjp0cnVlLCJrZXkiOiJhcHBfY2xpZW50X2lkIiwidmFsdWUiOiIyIiwidHlwZSI6InRleHQifSx7ImVuYWJsZWQiOnRydWUsImtleSI6ImFwcF9jbGllbnRfc2VjcmV0IiwidmFsdWUiOiJDbzVZcHJuUGU1amFsVnA4QlR4Y3FxQXpxR0dRRm9ucU85VXpUYVhLIiwidHlwZSI6InRleHQifV0=)

### Installation

```
repositories {
     jcenter()
     maven { url "https://jitpack.io" }
}
dependencies {
      compile 'com.github.TeamBaseHQ:base-java-sdk:master-SNAPSHOT'
}
```

### Getting Started
```java
package com.base;

import com.base.Auth.AccessToken;
import com.base.Exceptions.BaseException;
import com.base.Exceptions.BaseHttpException;
import com.base.Exceptions.Http.InputError;
import com.base.Models.Media;
import com.base.Models.User;

import java.io.File;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        createUser();
//        getUserAccessToken();
    }

    public static void createUser() {
        Base base = getBase();
        try {
            User user = base.userService().createUser("John Doe", "abcd@gmail.com", "abcd1234");
            System.out.println(user.getName());
        } catch (InputError e) {
            // Input Error
            // Fetch all the errors from the Error Bag
            Map<String, String[]> errors = e.getErrorBag().getErrors();
            for (String key : errors.keySet()) {
                for (String error : errors.get(key)) {
                    System.out.println(error);
                }
            }
        } catch (BaseHttpException e) {
            System.out.println(String.valueOf(e.getResponse().getStatusCode()));
        }
    }

    public static void getUserAccessToken() {
        Base base = getBase();

        try {
            // Log in User
            AccessToken accessToken = base.getUserAccessToken("abcd@gmail.com", "abcd1234");

            // Set the Access Token for the current User
            // So that this can be used for all the subsequent requests.

            base.getClient().setAccessToken(accessToken);
            User user = base.userService().getCurrentUser();
            System.out.println(user.getName());

            File file = new File("C:\\propic.jpg");
            Media media = base.userService().uploadProfilePicture(file);

            System.out.println(media.getUrl("small"));

        } catch (BaseException e) {
            e.printStackTrace();
        }
    }

    private static Base getBase() {
        BaseClient baseClient = new BaseClient();
        baseClient.setApiUrl("http://backend.baseapp.io/api");

        baseClient.setClientId("9").setClientSecret("tJDLmxkA2ogjEcU3qRtUwVSitkD9VJltOKnYh5AJ");

        return new Base(baseClient);
    }

}

```

[See here for Installation](https://jitpack.io/docs/)

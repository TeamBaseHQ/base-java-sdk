Base Java SDK
==============
Offical SDK for Java.

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
import com.base.Models.Media;
import com.base.Models.User;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        getUserAccessToken();
    }

    public static void getUserAccessToken() {
        Base base = getBase();

        try {
            // Log in User
            AccessToken accessToken = base.getUserAccessToken("abcd@xyz.com", "abcd1234");

            // Set the Access Token for the current User
            // So that this can be used for all the subsequent requests.

            base.getClient().setAccessToken(accessToken);
            User user = base.userService().getCurrentUser();
            System.out.println(user.getName());

            File file = new File("C:\\profile-picture.jpg");
            Media media = base.userService().uploadProfilePicture(file);

            System.out.printf(media.getUrl("small"));

        } catch (BaseException e) {
            e.printStackTrace();
        }
    }

    private static Base getBase() {
        BaseClient baseClient = new BaseClient();
//      baseClient.setApiUrl("http://backend.baseapp.io/api");

        baseClient.setClientId("1").setClientSecret("abcd1234");

        return new Base(baseClient);
    }

}

```

[See here for Installation](https://jitpack.io/docs/)

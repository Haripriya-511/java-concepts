package solidprinciples.singleresponsibilityprinciple.corrected;

import java.io.IOException;

public class Main {
    private static final String VALID_USER="{\n" +
            "    \"name\":\"Randy\",\n" +
            "        \"email\": \"Randy@gmail.com\",\n" +
            "        \"address\":\"123 dummy United states \"\n" +
            "        }";
    private static final String INVALID_USER="{\n" +
            "    \"name\":\"Ramya\",\n" +
            "        \"email\": \"ramya@gmail\",\n" +
            "        \"address\":\"123 dummy United states \"\n" +
            "        }";

    public static void main(String[] args) throws IOException {
        UserController controller=new UserController();
        String response1=controller.createUser(VALID_USER);
        validateResponse(response1);
        String response2=controller.createUser(INVALID_USER);
        validateResponse(response2);

    }
    public static void validateResponse(String response){
        System.out.println(response);
        if(!response.equalsIgnoreCase("SUCCESS") ||
                response.equalsIgnoreCase("ERROR")) {
            System.err.println("Failed");
            System.out.println("Invalid JSON received response: "+response);
        }else {
            System.out.println("Valid JSON received response:" + response);
        }
    }
}


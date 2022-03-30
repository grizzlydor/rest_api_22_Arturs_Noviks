//This is a class with a method that creates a random task name.
//This string is then passed as a task name in the json object, in the ClickUpSteps class.
//Reasoning behind this solution to the step #5 - ClickUp does not let you make a task without providing the Task Name,
// although, the only required parameter is list_id - perhaps, it's an error in the documentation, or maybe I just misunderstood it.
//ClickUp also does not auto-generate the name on its own.

package clickUpApi.helpers;

import java.util.Random;

public class NameGenerator {
    public static String generate() {
        // create a string of all characters
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 7;

        for(int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        String randomString = sb.toString();
        return randomString;

    }
}

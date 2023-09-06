import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;
import java.util.ArrayList;
import java.util.Scanner;


public class PersonGenerator
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // Test data the lines of the file we will write
        Scanner scanner = new Scanner(System.in);

        ArrayList<Person> persons = new ArrayList<>();

        while (true) {
            System.out.println("Enter data for a person:");

            String id = SafeInput.getNonZeroLenString(scanner, "ID");
            String firstName = SafeInput.getNonZeroLenString(scanner, "First Name");
            String lastName = SafeInput.getNonZeroLenString(scanner, "Last Name");
            String title = SafeInput.getNonZeroLenString(scanner, "Title");
            int yearOfBirth = SafeInput.getInt(scanner, "Year of Birth");

            // Create a Person object with the collected data and add it to the ArrayList
            persons.add(new Person(id, firstName, lastName, title, yearOfBirth));



            if (!SafeInput.getYNConfirm(scanner, "Add another person?")) {
                break;
            }
        }
        // uses a fixed known path:
        //  Path file = Paths.get("c:\\My Documents\\data.txt");

        // use the toolkit to get the current working directory of the IDE
        // will create the file within the Netbeans project src folder
        // (may need to adjust for other IDE)
        // Not sure if the toolkit is thread safe...
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.txt");

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for (Person person : persons) {
                String personData = person.toCSV();
                writer.write(personData, 0, personData.length());
                writer.newLine();
            }

            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}

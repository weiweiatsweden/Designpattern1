package org.example;

import org.example.pants.*;

import java.util.Random;
import java.util.Scanner;

public class Webbshop {
    Scanner scanner = new Scanner(System.in);
    public Webbshop() {
        initializeCustomer();
    }

    public void initializeCustomer(){
        Customer customer1 = new Customer(1, "Kjell", "Kyrkogatan 1, Göteborg", "Kjell.Petersson@gmail.com");
        Customer customer2 = new Customer(2, "Marc", "Kungsgatan 2, Uppsala", "Marc.svensson@gmail.com");
        Customer customer3 = new Customer(3, "Sia", "Gräddegatan 2, Göteborg", "Sia.Karlsson@gmail.com");

    }

    public void runWebbshop(){
        logIn();
        produceGarment();
    }

    public void logIn() {
        System.out.println("Welcome to Wigell's webbshop");
        System.out.println("Please enter your customer ID");
        int customerId = scanner.nextInt();
    }
    public void produceGarment(){

        System.out.println("Please choose a product \n" +
                "1. Pants \n" +
                "2. T-shirts \n" +
                "3. Skirts "
        );

        switch (scanner.nextInt()) {
            case 1 :
                producePants();
                break;
            case 2 :
                produceTShirt();
                break;
            case 3 :
                produceSkirt();
                break;
            default:
                System.out.println("Invalid choice.");
                produceGarment();

        }
    }

    public void producePants() {
        System.out.println("Please enter material: \"cotton\" or \"linen\"" );
        String pantsMaterial = scanner.next();

        System.out.println("Please enter type:  \"kostym\" , \"sport\" or \"casual\" ");
        String pantsType = scanner.next();

        System.out.println("Please enter fitting \"regular\" , \"wide\" or \"slim\"" );
        String pantsFit = scanner.next();

        System.out.println("Please enter length 30, 32, 34");
        int pantsLength = scanner.nextInt();

        System.out.println("Please enter color \"black\" or \"beige\"" );
        String pantsColor = scanner.next();

        System.out.println("Please enter size  \"M\" or \"L \"");
        String pantsSize = scanner.next();

        //Builder Pattern
        PantsBuilder pantsBuilder = new PantsBuilder();
        Pants pants;
        try {
            pants = pantsBuilder
                    .addMaterial(pantsMaterial)
                    .addType(pantsType)
                    .addFit(pantsFit)
                    .build();

        }
        catch (RuntimeException exception){
            System.out.println(exception.getMessage());
            produceGarment();
            return;
        }

        //Observer Pattern
        CEOMessageNotification ceoMessageNotification = new CEOMessageNotification();
        pants.addPropertyChangeListener(ceoMessageNotification);
        pants.setId(getRandomId());


        //Command Pattern
        GarmentProcessPipeline pipeline = new GarmentProcessPipeline();
        pipeline.addCommand(new PantsLengthCommand(pantsLength, pants));
        pipeline.addCommand(new PantsColorCommand(pantsColor, pants));
        pipeline.addCommand(new PantsSizeCommand(pantsSize, pants));
        pipeline.execute();

        pants.setProductionIsCompleted(true);

        System.out.println("Pants material: " + pants.getMaterial() +
                "\n type: " + pants.getType() +
                "\n fitting: " + pants.getFit() +
                "\n length: " + pants.getLength() +
                "\n color: " + pants.getColor() +
                "\n size: " + pants.getSize());

    }
    private void produceSkirt() {
        System.out.println("Please enter material: \"cotton\" or \"linen\"" );
        String skirtMaterial = scanner.next();

        System.out.println("Please enter waist line: \"high\" , \"medium\" or \"low\"" );
        String skirtWaistline = scanner.next();

        System.out.println("Please enter pattern: \"flower\" , \" square \" or \" polka \"" );
        String skirtPattern = scanner.next();

        System.out.println("Please enter color \"black\" or \"white\"" );
        String skirtColor = scanner.next();

        System.out.println("Please enter size  \"M\" or \"L \"");
        String skirtSize = scanner.next();



        SkirtBuilder skirtBuilder = new SkirtBuilder();
        Skirt skirt;
        try {
            skirt = skirtBuilder
                    .addMaterial(skirtMaterial)
                    .addWaistLine(skirtWaistline)
                    .addPattern(skirtPattern)
                    .build();
        }
        catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
            produceGarment();
            return;
        }

        CEOMessageNotification ceoMessageNotification = new CEOMessageNotification();
        skirt.addPropertyChangeListener(ceoMessageNotification);
        skirt.setId(getRandomId());

        GarmentProcessPipeline pipeline = new GarmentProcessPipeline();
       // pipeline.addCommand(new PantsColorCommand(skirtColor));
     //   pipeline.addCommand(new SizeCommand(skirtSize));
        pipeline.execute();

        skirt.setProductionIsCompleted(true);

    }

    public void produceTShirt() {
        System.out.println("Please enter material: \"cotton\" or \"linen\"" );
        String tShirtMaterial = scanner.next();

        System.out.println("Please enter sleeve length: \"short\" , \"medium\" or \"long\"" );
        String tShirtSleeve = scanner.next();

        System.out.println("Please enter neck shape: \"v\" , \"round\" or \"turtle\"" );
        String tShirtNeck = scanner.next();

        System.out.println("Please enter color \"black\" or \"white\"" );
        String tShirtColor = scanner.next();

        System.out.println("Please enter size  \"M\" or \"L \"");
        String tShirtSize = scanner.next();


        //Builder Pattern
        TShirtBuilder tShirtBuilder = new TShirtBuilder();
        Tshirts tshirts;
        try{
            tshirts = tShirtBuilder
                    .addMaterial(tShirtMaterial)
                    .addSleeveLength(tShirtSleeve)
                    .addNeckShape(tShirtNeck)
                    .build();
        }
        catch (RuntimeException exception){
            System.out.println(exception.getMessage());
            produceGarment();
            return;
        }

        //Observer Pattern
        CEOMessageNotification ceoMessageNotification = new CEOMessageNotification();
        tshirts.addPropertyChangeListener(ceoMessageNotification);
        tshirts.setId(getRandomId());

        //Command Pattern
        GarmentProcessPipeline pipeline = new GarmentProcessPipeline();
        //pipeline.addCommand(new PantsColorCommand(tShirtColor));
        //pipeline.addCommand(new SizeCommand(tShirtSize));
        pipeline.execute();

        tshirts.setProductionIsCompleted(true);


    }




    public int getRandomId(){
        Random r = new Random();
        return r.nextInt();

    }


}

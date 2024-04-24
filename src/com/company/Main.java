package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	try{
        List<Apartment> apartments = readApartmentsFromFile("testData_Apartments");
        Map<String, List<String>> cheapestApartmentsCity = findCheapestApartments(apartments);
        writePhoneToFle(cheapestApartmentsCity, "outputs.txt");
    }
    catch (IOException | ExceptionApt e){
        System.out.println(e.getMessage());
    }
    }
    private static List<Apartment> readApartmentsFromFile(String filename) throws IOException {
        List<Apartment> apartments = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = br.readLine())!=null){
                String [] parts = line.split(", ");
                String city = parts[0];
                int rooms = Integer.parseInt(parts[1]);
                int meters = Integer.parseInt(parts[2]);
                int price = Integer.parseInt(parts[3]);
                String phone = parts[4];
                apartments.add(new Apartment(city, rooms, meters, price, phone));
            }
        }
        return apartments;
    }
    private static Map<String, List<String>>
    findCheapestApartments(List<Apartment> apartments) throws
            ExceptionApt{Map<String, List<String>> cheapestApartmentsCity = new HashMap<>();
        Map<String, Integer> cityApartmentCount = new HashMap<>();

        for(Apartment apartment : apartments){
            if(apartment.getRooms()==3 && apartment.getMeters()==100)
            {
                String city = apartment.getCity();
                cityApartmentCount.put(city, cityApartmentCount.getOrDefault(city, 0)+1);
                cheapestApartmentsCity.putIfAbsent(city, new ArrayList<>());
                cheapestApartmentsCity.get(city).add(apartment.getPhone());
            }
        }
        if(! cheapestApartmentsCity.containsKey("София") || !
                cheapestApartmentsCity.containsKey("варна") || !
                cheapestApartmentsCity.containsKey("Бургас")) {
            throw new ExceptionApt("няма апратаменти с търсените качества в София, Варна или Бругас");
        }
        return cheapestApartmentsCity;
    }
    private static void writePhoneToFile(Map<String, List<String>> cheapestApartmentsCity, String filename) throws IOException{(
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename));){
                for(Map.Entry<String, List<String>>entry : cheapestApartmentsCity.entrySet()){
                    bw.write(entry.getKey()+": ");
                    bw.write(String.join(", ", new HashSet<>(entry.getValue())));
                    bw.newLine();
                }
                String cityMostApt = Collections.max(cheapestApartmentsCity.entrySet(), Map.Entry.comparingByValue(List::size)).getKey;
                bw.write("Градът с най-много аартаменти е " + cityMostApt);
    }
}
}

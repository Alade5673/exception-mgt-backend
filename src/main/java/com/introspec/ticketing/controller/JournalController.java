package com.introspec.ticketing.controller;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JournalController {

        public  void readData() {
            String line ;
            String[] value =  new String[13];
            try (Scanner input = new Scanner(new File("src\\main\\java\\com\\introspec\\ticketing\\controller\\Journal.csv"))) {
                while (input.hasNextLine()) {

                    line =  input.nextLine();
                    value = line.split(", ");

                    saveData(value);
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }

        private void saveData(String[] value){
            try(Connection conn = connect();
                PreparedStatement pstat = conn.prepareStatement("INSERT INTO exceptionmanagement VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"))
            {
                pstat.setString(1, value[0]);
                pstat.setString(2, value[1]);
                pstat.setDouble(3, Double.parseDouble(value[2]));
                pstat.setString(4, value[3]);
                pstat.setString(5, value[4]);
                pstat.setString(6, value[5]);
                pstat.setString(7, value[6]);
                pstat.setString(8, value[7]);
                pstat.setString(9, value[8]);
                pstat.setString(10,  value[9]);
                pstat.setString(11,  value[10]);
                pstat.setInt(12, Integer.parseInt(value[11]));
                pstat.setString(13, value[12]);

                pstat.executeQuery();
            }
            catch(SQLException e){
                System.out.println("Error: "+ e);
            }


        }

        private Connection connect(){
            try {
                Class.forName("org.postgresql.Driver");
                return DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/ticket", "postgres", "OLUWASEUN5673");
            }
            catch (SQLException | ClassNotFoundException e){
                System.out.println(e);
                return null;
            }
        }

        public static void main(String[] args) {
            JournalController csv = new JournalController();
            csv.readData();
        }
    }



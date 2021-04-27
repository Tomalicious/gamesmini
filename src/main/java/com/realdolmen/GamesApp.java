package com.realdolmen;

import com.realdolmen.commandpattern.Command;
import com.realdolmen.commandpattern.CommandsEnum;
import com.realdolmen.exceptions.NotFoundException;
import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;

@Log //this is a lombok annotation and it uses de default logger from java not LogBack !
public class GamesApp {
    private static Scanner scanner = new Scanner(System.in);
    private static List<CommandsEnum> commandsEnumList = Arrays.stream(CommandsEnum.values()).collect(Collectors.toList());

    public static void main(String[] args) {
        while (true) {
            showOptions();
            try {
                Command command = chooseOption().getCommand();
                System.out.println("clear");
                command.execute();
            } catch (Exception | NotFoundException e) {
                System.out.println("clear");
                System.out.println("\u001b[35m" + "something went wrong please try again!");
                if (e.getMessage() != null) {
                    System.out.println("\u001b[35m" + e.getMessage()); //\u001b[31m is the ansi color code for red
                }
                System.out.println(e.getClass().getName());
                System.out.print("\u001b[0m"); //Reset console color
                scanner.nextLine();
            } finally {
                System.out.print("Try again? (y/n): ");
                if (scanner.next().equals("y")) {
                    System.out.println("clear");
                } else {
                    break;
                }
            }
        }
    }

    private static void showOptions() {
        System.out.println("----List of options-----");
        commandsEnumList.forEach(commandsEnum -> {
            System.out.printf("\t%s\n", commandsEnum);
        });
        System.out.println("---------");
    }

    private static CommandsEnum chooseOption() throws Exception {
        System.out.print("Choose an option: ");
        int optionId = scanner.nextInt();
        return commandsEnumList.stream()
                .filter(commandsEnum -> commandsEnum.getOptionId() == optionId).findFirst()
                .orElseThrow(() -> new Exception("Command not found, please try again"));
    }


}

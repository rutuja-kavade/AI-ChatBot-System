/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aichatbotsystem;

import java.io.FileWriter;
import java.io.IOException;

public class ChatBotEngine {

    private KnowledgeBase knowledgeBase;

    public ChatBotEngine() {
        knowledgeBase = new KnowledgeBase();
    }

    public String generateResponse(String userInput) {

        String response = knowledgeBase.findResponse(userInput);

        saveChat(userInput, response);

        return response;
    }

    private void saveChat(String question, String answer) {

        try {

            FileWriter fw =
                    new FileWriter("ChatHistory.txt", true);

            fw.write("User : " + question + "\n");
            fw.write("Bot  : " + answer + "\n");
            fw.write("---------------------------------\n");

            fw.close();

        } catch (IOException e) {

            System.out.println("Unable to save chat history.");
        }
    }
}
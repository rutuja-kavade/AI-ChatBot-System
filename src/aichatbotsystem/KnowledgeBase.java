/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aichatbotsystem;

import java.util.HashMap;
import java.util.Map;

public class KnowledgeBase {

    private Map<String, String> responses;

    public KnowledgeBase() {

        responses = new HashMap<>();

        responses.put("hello", "Hello! Welcome to AI ChatBot.");
responses.put("hi", "Hi! How can I assist you today?");
responses.put("how are you", "I am functioning perfectly. Thank you for asking.");
responses.put("your name", "I am AI ChatBot Assistant.");
responses.put("java", "Java is a powerful object-oriented programming language.");
responses.put("oop", "OOP stands for Object-Oriented Programming.");
responses.put("database", "A database stores and manages application data.");
responses.put("mysql", "MySQL is a widely used relational database.");
responses.put("html", "HTML is used to create web pages.");
responses.put("css", "CSS is used to style web pages.");
responses.put("javascript", "JavaScript makes web pages interactive.");
responses.put("python", "Python is a popular programming language for AI and automation.");
responses.put("c++", "C++ is widely used for system and application development.");
responses.put("internship", "Internships provide practical industry experience.");
responses.put("project", "Projects help improve coding and problem-solving skills.");
responses.put("github", "GitHub is a platform for version control and collaboration.");
responses.put("resume", "A professional resume highlights your skills, education, and projects.");
responses.put("job", "Keep improving your skills and applying regularly for opportunities.");
responses.put("interview", "Interview preparation includes technical knowledge and communication skills.");
responses.put("skill", "Consistent practice is the key to improving technical skills.");
responses.put("college", "College is a great place to build technical and professional skills.");
responses.put("engineer", "Engineers solve real-world problems using technology and innovation.");
responses.put("artificial intelligence", "Artificial Intelligence enables machines to simulate human intelligence.");
responses.put("ai", "Artificial Intelligence enables machines to learn and make decisions.");
responses.put("chatbot", "A chatbot is a software application that simulates conversation with users.");
responses.put("time", new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date()));
responses.put("date", new java.text.SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date()));
responses.put("thank", "You're welcome.");
responses.put("thanks", "Glad I could help.");
responses.put("bye", "Goodbye. Have a productive day.");
    }

    public String findResponse(String input) {

        input = input.toLowerCase();

        for (String keyword : responses.keySet()) {

            if (input.contains(keyword)) {
                return responses.get(keyword);
            }
        }

        return "Sorry, I don't have information about that yet. Please ask another question.";
    }
}

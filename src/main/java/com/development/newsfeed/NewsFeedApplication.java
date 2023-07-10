package com.development.newsfeed;

import com.development.newsfeed.commands.CommandRegistery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;


@SpringBootApplication
@EnableJpaAuditing
public class NewsFeedApplication implements CommandLineRunner {

	private final Scanner sc;
    private final CommandRegistery commandRegistery;

	@Autowired
	public NewsFeedApplication(CommandRegistery commandRegistery){
		sc=new Scanner(System.in);
		this.commandRegistery=commandRegistery;

	}

	public static void main(String[] args) {

		SpringApplication.run(NewsFeedApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

       while(true){
		   System.out.println("please let me know what do you want! ");
		   String input=sc.nextLine();
		   commandRegistery.Execute(input);

	   }

	}
}

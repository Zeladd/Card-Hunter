package me.filip;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class DiscordBot {

	public static void main(String[] args) throws LoginException {
		
		Token token = Token.getToken();
		
		JDA bot = JDABuilder.createDefault
				(token.toString())
				.addEventListeners(new Listener())
				.build();

	}

}

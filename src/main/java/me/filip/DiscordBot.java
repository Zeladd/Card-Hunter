package me.filip;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class DiscordBot {

	public static void main(String[] args) throws LoginException {
		
		JDA bot = JDABuilder.createDefault
				(Config.get("token"))
				.enableIntents(GatewayIntent.MESSAGE_CONTENT)
				.addEventListeners(new Listener())
				.build();

	}

}

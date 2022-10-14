package me.filip;

import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import javax.annotation.Nonnull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Listener extends ListenerAdapter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Listener.class);

	@Override
	public void onReady(@Nonnull ReadyEvent event) {
		LOGGER.info("{} is ready", event.getJDA().getSelfUser().getAsTag());
	}
	
	@Override
	public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
		String prefix = Config.get("prefix");
		String raw = event.getMessage().getContentRaw();
		
		if (event.isFromGuild()) {
			if (raw.equals(prefix + "SHUTDOWN") && 
					event.getAuthor().getId().equals(Config.get("owner_id"))) {
				LOGGER.info("Shutting down!");
				event.getJDA().shutdown();
			}
		}
	}
}

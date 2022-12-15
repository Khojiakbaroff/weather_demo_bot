package demo_project;

import demo_project.bot.WeatherBot;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
public  class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args){
        logger.info("initiation bot");
        TelegramBotsApi api;
        try {
            api = new TelegramBotsApi(DefaultBotSession.class);
            api.registerBot(new WeatherBot());
        } catch (TelegramApiException e) {
            logger.error("error with init bot :" + e.getMessage());
        }



    }
}
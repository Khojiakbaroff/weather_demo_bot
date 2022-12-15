package demo_project.bot;

import demo_project.connection.ApiConnection;
import demo_project.constants.Constants;
import demo_project.model.Weather;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WeatherBot extends TelegramLongPollingBot implements Constants {

    private final static ApiConnection connection = new ApiConnection();

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            handleMessage(update.getMessage());
        } else if (update.hasCallbackQuery()) {
            handleQuery(update.getCallbackQuery());
        }
    }
    @SneakyThrows
    private void handleQuery(CallbackQuery callbackQuery) {
        String data = callbackQuery.getData();
        if (data.equals(DELETE)){
            DeleteMessage message = new DeleteMessage();
            message.setChatId(callbackQuery.getFrom().getId());
            message.setMessageId(callbackQuery.getMessage().getMessageId());
            execute(message);
        }
    }

    @SneakyThrows
    private void handleMessage(Message message) {
        long chatId = message.getChatId();
        String text = message.getText();
        SendMessage sendMessage = new SendMessage();
        List<List<InlineKeyboardButton>> buttonList = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();

        if (text.equals(START)) {
            sendMessage.setChatId(chatId);
            sendMessage.setText(HI);
        } else {
            Weather london = connection.getConnection("London");
            buttonList.add(Arrays.asList(button));
            button.setText(DELETE);
            button.setCallbackData(DELETE);
            sendMessage.setReplyMarkup(new InlineKeyboardMarkup(buttonList));
            sendMessage.setText(london.getCurrent().toString());
            sendMessage.setChatId(chatId);
        }
        sendMessage.enableMarkdown(true);
        execute(sendMessage);
    }
}

package test_locally.api.model.event;

import com.google.gson.Gson;
import com.slack.api.model.event.MemberLeftChannelEvent;
import org.junit.Test;
import test_locally.unit.GsonFactory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MemberLeftChannelEventTest {

    @Test
    public void typeName() {
        assertThat(MemberLeftChannelEvent.TYPE_NAME, is("member_left_channel"));
    }

    @Test
    public void deserialize() {
        String json = "{\n" +
                "    \"type\": \"member_left_channel\",\n" +
                "    \"user\": \"W06GH7XHN\",\n" +
                "    \"channel\": \"C0698JE0H\",\n" +
                "    \"channel_type\": \"C\",\n" +
                "    \"team\": \"T024BE7LD\"\n" +
                "}";
        MemberLeftChannelEvent event = GsonFactory.createSnakeCase().fromJson(json, MemberLeftChannelEvent.class);
        assertThat(event.getType(), is("member_left_channel"));
        assertThat(event.getUser(), is("W06GH7XHN"));
        assertThat(event.getChannel(), is("C0698JE0H"));
        assertThat(event.getChannelType(), is("C"));
        assertThat(event.getTeam(), is("T024BE7LD"));
    }

    @Test
    public void serialize() {
        Gson gson = GsonFactory.createSnakeCase();
        MemberLeftChannelEvent event = new MemberLeftChannelEvent();
        String generatedJson = gson.toJson(event);
        String expectedJson = "{\"type\":\"member_left_channel\"}";
        assertThat(generatedJson, is(expectedJson));
    }

}

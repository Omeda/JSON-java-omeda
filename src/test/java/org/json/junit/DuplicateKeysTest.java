package org.json.junit;

import static org.junit.Assert.*;

import org.json.*;
import org.junit.Test;

public class DuplicateKeysTest {

    @Test
    public void lastPlacedKeyWins() {
        String jsonString = "{\"key1\":\"val1\",\"key1\":\"val2\"}";
        JSONObject jsonObject = new JSONObject(jsonString);
        assertTrue("key1 field should be set to val2", jsonObject.optString("key1").equalsIgnoreCase("val2"));
    }

    @Test
    public void duplicateKeyAddedWins() {
        String jsonString = "{\"key1\":\"val1\"}";
        JSONObject jsonObject = new JSONObject(jsonString);

        jsonObject.put("key1","val2");

        assertTrue("key1 field should be set to val2", jsonObject.optString("key1").equalsIgnoreCase("val2"));
    }
}

package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JoyArchiveTest {
  IJoyArchive ja;

  private final String entryName = "sample entry";

  private final String entryText = "sample text";

  @Before
  public void setup() {
    ja = new JoyArchive();
  }

  @Test
  public void testAddEntry() {
    ja.addJAEntry(entryName, entryText, "tag1", "tag2", "tag3");
    assertEquals(ja.getNumEntries(), 1);
    assertEquals("tag1 tag2 tag3\n", ja.getEntryTags(entryName));
  }
}
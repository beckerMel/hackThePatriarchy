package model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

  @Test
  public void testRemoveEntry() {
    ja.addJAEntry(entryName, entryText, "tag1", "tag2", "tag3");
    assertEquals(ja.getNumEntries(), 1);
    assertEquals("tag1 tag2 tag3\n", ja.getEntryTags(entryName));
    ja.removeJAEntry(entryName);
    assertEquals(ja.getNumEntries(), 0);
  }

  @Test
  public void testAddTag() {
    ja.addJAEntry(entryName, entryText, "tag1", "tag2", "tag3");
    assertEquals(ja.getNumEntries(), 1);
    ja.addTag(entryName, "tag4");
    assertEquals(ja.getNumEntries(), 1);
    assertEquals("tag1 tag2 tag3 tag4\n", ja.getEntryTags(entryName));
  }

  @Test
  public void testGenerateAffirmation() {
    System.out.println(ja.generateAffirmation());
    assertTrue(ja.generateAffirmation() != null);
  }

  @Test
  public void testAddHighlight() {
    ja.addHighlight("2022-10-30", "highlight");
    assertEquals("highlight", ja.getHighlights("2022-10-30", "2022-10-30").get(0));
  }

  @Test
  public void testAddMultipleHighlights() {
    ja.addHighlight("2022-10-30", "highlight1");
    ja.addHighlight("2022-11-03", "highglight2");
    List<String> list = ja.getHighlights("2022-10-30", "2022-11-02");
    assertEquals("highlight1 highlight2", list.get(0) + " " + list.get(1));
  }
}
import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMerge() {
    List<String> left = Arrays.asList("a", "d");
    List<String> right = Arrays.asList("a", "b","c");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test
  public void testFilter() {
      String[] ar = {"moon","wer","asdf","rty"};
      List<String> list = Arrays.asList(ar);
      String[] arr = new String[]{"moon"};
      StringChecker sc = new IsMoon();
      assertEquals(Arrays.asList(arr),ListExamples.filter(list, sc));
  }

  @Test
  public void testFilterEmpty() {
      List<String> list = new ArrayList<>();
      String[] arr = {};
      StringChecker sc = new IsMoon();
      assertEquals(Arrays.asList(arr), ListExamples.filter(list,sc));
  }

  @Test(timeout = 500)
  public void testMergeSimple() {
      List<String> list1 =new ArrayList<>();
      list1.add("a");
      List<String> list2 = new ArrayList<>();
      list2.add("b");
      String[] arr = {"a","b"};
      assertEquals(Arrays.asList(arr),ListExamples.merge(list1,list2));
  }
}

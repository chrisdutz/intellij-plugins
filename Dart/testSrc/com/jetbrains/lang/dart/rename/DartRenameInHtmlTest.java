package com.jetbrains.lang.dart.rename;

import com.intellij.openapi.util.io.FileUtil;
import com.jetbrains.lang.dart.DartCodeInsightFixtureTestCase;

abstract public class DartRenameInHtmlTest extends DartCodeInsightFixtureTestCase {
  @Override
  protected String getBasePath() {
    return FileUtil.toSystemDependentName("/rename/html");
  }

  public void doTest(String newName, String... additionalFiles) {
    myFixture.testRename(getTestName(false) + ".html", getTestName(false) + "After.html", newName, additionalFiles);
  }

  public void testLibrary1() throws Throwable {
    doTest("otherLib", "myLibPart.dart");
    myFixture.checkResultByFile("myLibPart.dart", "myLibPartAfter.dart", true);
  }

  public void testConstructor1() throws Throwable {
    doTest("FooNew");
  }


  public void testStaticField() throws Throwable {
    doTest("fooNew", "StaticFieldHelper.dart");
  }
}
